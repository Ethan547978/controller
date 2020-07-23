package com.app.controller.event;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**
 * RxBus 传递使用事件类
 * Created by Administrator on 2016/11/1.
 */
public class Events<T> {
    //所有事件的CODE
//    public static final int TAP = 1; //点击事件
//    public static final int OTHER = 21; //其它事件
//
//    /**
//     * 直播间事件
//     */
//    public static final int ROOM_MANAGE_MSG = 101;
//
//    /**
//     * 界面事件
//     */
//    public static final int ENTER_LIVE_MSG = 201; // 进入直播间
//    public static final int PASSING_LIVE_TITLE_MSG = 202;
//
//    public static final int LOGIN_SUCCESS_MSG = 203;
//    public static final int WECHAT_AUTHORISE_MSG = 204;             //微信授权消息
//    public static final int REFRESH_USER_INFO = 205;             //微信授权消息
//
//
//    //用户加入群聊
//    public static final int USER_ADD_GROUP = 707;
//
//    //用户被踢出群聊或者退出群聊
//    public static final int USER_QUIT_GROUP = 708;
//
//    //刷新聊天列表
//    public static final int RONG_REFRESH_MESSAGE = 709;
//    //收到新消息
//    public static final int RONG_IM_MESSAGE = 710;
//
//    //未读消息
//    public static final int UNREAD_MSG = 803;
//
//    //系统消息
//    public static final int SYSTEM_MSG = 804;
//
//
//
//    /**
//     * 通用错误
//     */
//    public static final int MSG_ERROR= 100001;
//
//    /**
//     * 获取socket ibs
//     */
//    public static final int MSG_GET_IBS= 200001;
//
//    /**
//     *
//     */
//    public static final int MSG_SESSION_IBS = 200002;
//
//    //即时禁播
//    public static final int KICK_SINGER_RESULT_MSG = 200003;
//
//
//    //交换加密钥匙
//    public static final int MSG_EXCHANGE_KEY_RESULT = 200004;
//
//
//    //枚举
//    @IntDef({
//            TAP,
//            OTHER,
//            ROOM_MANAGE_MSG,
//            ENTER_LIVE_MSG,
//            PASSING_LIVE_TITLE_MSG,
//            LOGIN_SUCCESS_MSG,
//            WECHAT_AUTHORISE_MSG,
//            REFRESH_USER_INFO,
//            //通用错误
//            MSG_ERROR,
//            //socket
//            MSG_GET_IBS,
//            MSG_SESSION_IBS,
//            KICK_SINGER_RESULT_MSG
//    })

    @Retention(RetentionPolicy.SOURCE)
    public @interface EventCode {
    }

    
 


    
    public
    @Events.EventCode
    int code;
    public T content;

    public static <O> Events<O> setContent(O t) {
        Events<O> events = new Events<>();
        events.content = t;
        return events;
    }

    public <T> T getContent() {
        return (T) content;
    }
}
