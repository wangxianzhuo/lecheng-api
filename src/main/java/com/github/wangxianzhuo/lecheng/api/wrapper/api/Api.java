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

package com.github.wangxianzhuo.lecheng.api.wrapper.api;

import com.github.wangxianzhuo.lecheng.api.wrapper.common.Config;
import com.github.wangxianzhuo.lecheng.api.wrapper.common.exception.AccessTokenExpiredException;
import com.github.wangxianzhuo.lecheng.api.wrapper.request.HttpRequest;
import com.github.wangxianzhuo.lecheng.api.wrapper.request.HttpResponseBody;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;

/**
 * description: Api
 * date: 2021/4/19 15:13
 *
 * @author: shangjie
 * @version: 1.0
 */
public abstract class Api {
    private static final Logger LOG = LoggerFactory.getLogger(Api.class);

    public static void getAccessToken() {
        String method = "accessToken";
        HttpResponseBody httpResponseBody = HttpRequest.request(method, Collections.EMPTY_MAP);
        String accessToken = getValueFromResultData(method, httpResponseBody);

        LOG.debug(accessToken);

        Config.getBasicConfig().setAccessToken(accessToken);
    }

    static String getValueFromResultData(String key, @NotNull HttpResponseBody httpResponseBody) {
        return Objects.requireNonNull(httpResponseBody.getResult().getData()).get(key).toString();
    }

    @NotNull
    static HashMap<String, Object> getBasicRequestParamsMap(String deviceId, String channelId) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("token", Config.getBasicConfig().getAccessToken());
        params.put("deviceId", deviceId);
        params.put("channelId", channelId);
        return params;
    }

    public Object executeWithExceptionCheck() {
        try {
            return execute();
        } catch (AccessTokenExpiredException e) {
            getAccessToken();
            return execute();
        }
    }

    abstract Object execute();
}
