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

import com.alibaba.fastjson.JSONException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HttpResponseBodyTest {
    @Test
    void parse() {
        String responseBodyString = "{\"result\":{\"msg\":\"操作成功。\",\"code\":\"0\",\"data\":{\"expireTime\":259176,\"accessToken\":\"At_00006ac6e32d123141238f60147de7ec\"}},\"id\":\"98a7a257-c4e4-4db3-a2d3-d97a3836b87c\"}";
        String responseBodyStringWithIllegalFormat = "{\"result\":{\"msg\":\"操作成功。\",\"code\":\"0\",\"data\":{\"expireTime\":259176,\"accessToken\":\"At_00006ac6e32d123141238f60147de7ec\"}},\"id}";

        HttpResponseBody responseBody = HttpResponseBody.parseJson(responseBodyString);

        assertNotNull(responseBody.getResult(), "result field is null");
        assertAll(
                () -> assertThrows(JSONException.class, () -> {
                    HttpResponseBody.parseJson(responseBodyStringWithIllegalFormat);
                }, "not throw JSONException"),
                () -> assertEquals("98a7a257-c4e4-4db3-a2d3-d97a3836b87c", responseBody.getId(), "get error id"),
                () -> assertEquals(HttpResponseBody.ResultCode.ZERO, responseBody.getResult().getResultCode(), "result code is not HttpResponseBody.ResultCode.ZERO"),
                () -> assertEquals(responseBody.getResult().getMsg(), "操作成功。", "result msg is error"),
                () -> assertTrue(responseBody.getResult().getData().containsKey("expireTime"), "result's data filed don't have key expireTime"),
                () -> assertTrue(responseBody.getResult().getData().containsValue(259176), "result's data filed don't have value 259176"),
                () -> assertTrue(responseBody.getResult().getData().containsKey("accessToken"), "result's data filed don't have key accessToken"),
                () -> assertTrue(responseBody.getResult().getData().containsValue("At_00006ac6e32d123141238f60147de7ec"), "result's data filed don't have value At_00006ac6e32d123141238f60147de7ec")
        );
    }
}