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

package com.github.wangxianzhuo.lecheng.api.wrapper.request;

import com.alibaba.fastjson.JSON;
import com.github.wangxianzhuo.lecheng.api.wrapper.common.Config;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Map;
import java.util.UUID;

/**
 * description: HttpRequestBody
 * date: 2021/4/18 11:20
 *
 * @author: shangjie
 * @version: 1.0
 */

public class HttpRequestBody {
    private final System system;
    private final Map params;
    private final String id;

    public HttpRequestBody(Map params) {
        this.system = System.build();
        this.params = params;
        this.id = UUID.randomUUID().toString();
    }

    protected String getSystemSign() {
        return this.system.sign;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    private static class System {
        private final static String ver = "1.0";
        private String sign;
        private String appId;
        private Long time;
        private String nonce;

        private static System build() {
            System system = new System();
            system.appId = Config.getBaseConfig().getAppId();
            system.time = java.lang.System.currentTimeMillis() / 1000;
            system.nonce = UUID.randomUUID().toString();
            system.generateSign();

            return system;
        }

        private void generateSign() {
            String rawSign = "time:" + this.time +
                    ",nonce:" + this.nonce +
                    ",appSecret:" + Config.getBaseConfig().getAppSecret();

            this.sign = DigestUtils.md5Hex(rawSign);
        }

        public String getVer() {
            return ver;
        }

        public String getSign() {
            return sign;
        }

        public String getAppId() {
            return appId;
        }

        public Long getTime() {
            return time;
        }

        public String getNonce() {
            return nonce;
        }
    }

    public System getSystem() {
        return system;
    }

    public Map getParams() {
        return params;
    }

    public String getId() {
        return id;
    }
}
