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

package com.github.wangxianzhuo.lecheng.api.wrapper;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;

/**
 * description: HttpRequestBody
 * date: 2021/4/18 11:20
 *
 * @author: shangjie
 * @version: 1.0
 */
public class HttpRequestBody {
    private System system;
    private Map params;
    private String id;


    protected static class System {
        private final static String ver = "1.0";
        private String sign;
        private String appId;
        private Long time;
        private String nonce;

        protected void generateSign() throws LechengApiWrapperException {
            try {
                String rawSign = "time:" + this.time +
                        ",nonce:" + this.nonce +
                        ",appSecret:" + Config.getBaseConfig().getAppSecret();

                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(rawSign.getBytes(StandardCharsets.UTF_8));

                this.sign = Arrays.toString(messageDigest.digest());

            } catch (NoSuchAlgorithmException e) {
                throw new LechengApiWrapperException("generate sign failed", e.getCause());
            }
        }
    }
}
