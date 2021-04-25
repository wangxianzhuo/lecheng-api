/*
 * Copyright 2021 xianzhuo<wangshangjie1992@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.wangxianzhuo.lecheng.api.wrapper.common;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * description: Config
 * date: 2021/4/18 11:41
 *
 * @author: shangjie
 * @version: 1.0
 */
public class Config {
    private final String appId;
    private final String appSecret;
    private String accessToken;

    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();

    private static Config basicConfig = new Config();

    public Config() {
        this.appId = System.getProperty("app.id");
        this.appSecret = System.getProperty("app.secret");
    }

    public Config(String appId, String appSecret, String accessToken) {
        this.appId = appId;
        this.appSecret = appSecret;
        this.accessToken = accessToken;
    }

    public String getAppId() {
        return appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    /**
     * accessToken get concurrent safe
     */
    public String getAccessToken() {
        readLock.lock();
        try {
            return accessToken;
        } finally {
            readLock.unlock();
        }
    }

    /**
     * accessToken set concurrent safe
     */
    public void setAccessToken(String accessToken) {
        writeLock.lock();
        try {
            this.accessToken = accessToken;
        } finally {
            writeLock.unlock();
        }
    }

    public static Config getBasicConfig() {
        return basicConfig;
    }

    public static void setBasicConfig(Config basicConfig) {
        Config.basicConfig = basicConfig;
    }
}
