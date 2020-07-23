package com.app.controller.controller;

import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import okio.BufferedSource;

import static okhttp3.internal.platform.Platform.INFO;

/**
 * Created by hp on 2017/9/27.
 */

public class CustomOKHttpLoggingInterceptor implements Interceptor {
    private static final Charset UTF8 = StandardCharsets.UTF_8;

    public enum Level {
        /**
         * No logs.
         */
        NONE,
        /**
         * Logs request and response lines.
         * <p>
         * <p>Example:
         * <pre>{@code
         * --> POST /greeting http/1.1 (3-byte body)
         *
         * <-- 200 OK (22ms, 6-byte body)
         * }</pre>
         */
        BASIC,
        /**
         * Logs request and response lines and their respective headers.
         * <p>
         * <p>Example:
         * <pre>{@code
         * --> POST /greeting http/1.1
         * Host: example.com
         * Content-Type: plain/text
         * Content-Length: 3
         * --> END POST
         *
         * <-- 200 OK (22ms)
         * Content-Type: plain/text
         * Content-Length: 6
         * <-- END HTTP
         * }</pre>
         */
        HEADERS,
        /**
         * Logs request and response lines and their respective headers and bodies (if present).
         * <p>
         * <p>Example:
         * <pre>{@code
         * --> POST /greeting http/1.1
         * Host: example.com
         * Content-Type: plain/text
         * Content-Length: 3
         *
         * Hi?
         * --> END POST
         *
         * <-- 200 OK (22ms)
         * Content-Type: plain/text
         * Content-Length: 6
         *
         * Hello!
         * <-- END HTTP
         * }</pre>
         */
        BODY
    }

    public interface Logger {
        void log(String message);

        /**
         * A {@link HttpLoggingInterceptor.Logger} defaults output appropriate for the current platform.
         */
        CustomOKHttpLoggingInterceptor.Logger DEFAULT = new CustomOKHttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Platform.get().log(INFO, message, null);
            }
        };
    }

    public CustomOKHttpLoggingInterceptor() {
        this(CustomOKHttpLoggingInterceptor.Logger.DEFAULT);
    }

    public CustomOKHttpLoggingInterceptor(CustomOKHttpLoggingInterceptor.Logger logger) {
        this.logger = logger;
    }

    private final CustomOKHttpLoggingInterceptor.Logger logger;

    private volatile CustomOKHttpLoggingInterceptor.Level level = CustomOKHttpLoggingInterceptor.Level.NONE;

    /**
     * Change the level at which this interceptor logs.
     */
    public CustomOKHttpLoggingInterceptor setLevel(CustomOKHttpLoggingInterceptor.Level level) {
        if (level == null) throw new NullPointerException("level == null. Use Level.NONE instead.");
        this.level = level;
        return this;
    }

    public CustomOKHttpLoggingInterceptor.Level getLevel() {
        return level;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        CustomOKHttpLoggingInterceptor.Level level = this.level;

        Request request = chain.request();
        if (level == CustomOKHttpLoggingInterceptor.Level.NONE) {
            return chain.proceed(request);
        }

        boolean logHeaders = level == CustomOKHttpLoggingInterceptor.Level.HEADERS;
        boolean logBody = logHeaders || level == CustomOKHttpLoggingInterceptor.Level.BODY;


        RequestBody requestBody = request.body();
        boolean hasRequestBody = requestBody != null;

        StringBuilder requestStringBuilder = new StringBuilder();

        String requestStartMessage = "--> Request " + request.method() + ' ' + request.url() + "\n";
        requestStringBuilder.append(requestStartMessage);

        if (logHeaders) {
            if (hasRequestBody) {
                // Request body headers are only present when installed as a network interceptor. Force
                // them to be included (when available) so there values are known.
                if (requestBody.contentType() != null) {
                    requestStringBuilder.append("Content-Type: " + requestBody.contentType() + "\n");
                }
                if (requestBody.contentLength() != -1) {
                    requestStringBuilder.append("Content-Length: " + requestBody.contentLength() + "\n");
                }
            }

            Headers headers = request.headers();
            for (int i = 0, count = headers.size(); i < count; i++) {
                String name = headers.name(i);
                if (!"Content-Type".equalsIgnoreCase(name) && !"Content-Length".equalsIgnoreCase(name)) {
                    requestStringBuilder.append(name + ": " + headers.value(i) + "\n");
                }
            }
        }

        if (logBody && hasRequestBody) {
            Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);

            Charset charset = UTF8;
            MediaType contentType = requestBody.contentType();
            if (contentType != null) {
                charset = contentType.charset(UTF8);
            }

            if (isPlaintext(buffer)) {
                requestStringBuilder.append("-->  " + buffer.readString(charset) + " (" + requestBody.contentLength() + "-byte body)\n");
            } else {
                requestStringBuilder.append("-->" + request.method() + " (binary " + requestBody.contentLength() + "-byte body omitted)\n");
            }
        }

        logger.log(requestStringBuilder.toString());

        StringBuilder responseStringBuilder = new StringBuilder();
        long startNs = System.nanoTime();
        Response response;
        try {
            response = chain.proceed(request);
        } catch (Exception e) {
            logger.log("<-- HTTP FAILED: " + e + "\n");
            throw e;
        }

        long tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs);

        ResponseBody responseBody = response.body();
        long contentLength = responseBody.contentLength();
        String bodySize = contentLength != -1 ? contentLength + "-byte" : "unknown-length";

        responseStringBuilder.append("<-- Response " + response.code() + ' ' + response.message() + ' ' + response.request().url() + " (" + tookMs + "ms" + (!logHeaders ? ", " + bodySize + " body" : "") + ')' + "\n");

        if (logHeaders) {
            Headers headers = response.headers();
            for (int i = 0, count = headers.size(); i < count; i++) {
                responseStringBuilder.append(headers.name(i) + ": " + headers.value(i) + "\n");
            }
        }

        if (!logBody || !HttpHeaders.hasBody(response)) {
            responseStringBuilder.append("<-- END HTTP \n");
        } else if (bodyEncoded(response.headers())) {
            responseStringBuilder.append("<-- END HTTP (encoded body omitted) \n");
        } else {
            BufferedSource source = responseBody.source();
            source.request(Long.MAX_VALUE); // Buffer the entire body.
            Buffer buffer = source.buffer();

            Charset charset = UTF8;
            MediaType contentType = responseBody.contentType();
            if (contentType != null) {
                charset = contentType.charset(UTF8);
            }

            if (!isPlaintext(buffer)) {
                responseStringBuilder.append("");
                responseStringBuilder.append("<-- END HTTP (binary " + buffer.size() + "-byte body omitted)\n");
                return response;
            }

            if (contentLength != 0) {
                responseStringBuilder.append("");
                responseStringBuilder.append(buffer.clone().readString(charset) + "\n");
            }

            responseStringBuilder.append("<-- END HTTP (" + buffer.size() + "-byte body)\n");
        }

        logger.log(responseStringBuilder.toString());
        return response;
    }


    /**
     * Returns true if the body in question probably contains human readable text. Uses a small sample
     * of code points to detect unicode control characters commonly used in binary file signatures.
     */
    static boolean isPlaintext(Buffer buffer) {
        try {
            Buffer prefix = new Buffer();
            long byteCount = buffer.size() < 64 ? buffer.size() : 64;
            buffer.copyTo(prefix, 0, byteCount);
            for (int i = 0; i < 16; i++) {
                if (prefix.exhausted()) {
                    break;
                }
                int codePoint = prefix.readUtf8CodePoint();
                if (Character.isISOControl(codePoint) && !Character.isWhitespace(codePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException e) {
            return false; // Truncated UTF-8 sequence.
        }
    }

    private boolean bodyEncoded(Headers headers) {
        String contentEncoding = headers.get("Content-Encoding");
        return contentEncoding != null && !contentEncoding.equalsIgnoreCase("identity");
    }
}
