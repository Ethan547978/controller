package com.app.controller.store.local.cache.quitnowCache;

interface DateProvider {

    DateProvider SYSTEM = new DateProvider() {

        @Override
        public long now() {
            return System.currentTimeMillis();
        }
    };

    long now();
}