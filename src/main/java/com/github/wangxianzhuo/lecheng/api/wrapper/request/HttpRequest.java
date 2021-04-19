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

import com.github.wangxianzhuo.lecheng.api.wrapper.common.exception.AccessFailedException;
import com.github.wangxianzhuo.lecheng.api.wrapper.common.exception.AccessTokenExpiredException;
import com.github.wangxianzhuo.lecheng.api.wrapper.common.exception.LechengApiWrapperException;
import com.github.wangxianzhuo.lecheng.api.wrapper.common.exception.RequestIdIsChangedException;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

/**
 * description: HttpRequest
 * date: 2021/4/19 12:54
 *
 * @author: shangjie
 * @version: 1.0
 */
public class HttpRequest {
    private static final Logger LOG = LoggerFactory.getLogger(HttpRequest.class);
    private static final String lechengApiHost = "https://openapi.lechange.cn:443/openapi";
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private static final OkHttpClient okHttpClient = new OkHttpClient();

    /**
     * @param method
     * @param params
     * @return
     * @throws LechengApiWrapperException
     * @throws RequestIdIsChangedException
     * @throws AccessTokenExpiredException
     */
    @NotNull
    public static HttpResponseBody request(String method, Map params) throws LechengApiWrapperException, RequestIdIsChangedException, AccessTokenExpiredException {
        String url = lechengApiHost + "/" + method;
        HttpRequestBody httpRequestBody = new HttpRequestBody(params);
        RequestBody requestBody = RequestBody.create(JSON, httpRequestBody.toString());
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            HttpResponseBody httpResponseBody = HttpResponseBody.parseJson(Objects.requireNonNull(response.body()).string());

            if (!httpResponseBody.getId().equals(httpRequestBody.getId())) {
                throw new RequestIdIsChangedException();
            }

            HttpResponseBody.ResultCode resultCode = httpResponseBody.getResult().getResultCode();
            if (resultCode == HttpResponseBody.ResultCode.TK1002) {
                throw new AccessTokenExpiredException();
            }

            if (resultCode != HttpResponseBody.ResultCode.ZERO) {
                throw new AccessFailedException(resultCode.toString());
            }

            return httpResponseBody;
        } catch (IOException e) {
            throw new LechengApiWrapperException("request[" + url + "] error,", e);
        }
    }
}
