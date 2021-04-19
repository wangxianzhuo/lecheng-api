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
    private static final Config baseConfig = new Config();

    public Config() {
        this.appId = System.getProperty("app.id");
        this.appSecret = System.getProperty("app.secret");
    }

    public String getAppId() {
        return appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public static Config getBaseConfig() {
        return baseConfig;
    }
}
