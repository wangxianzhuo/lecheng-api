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

import com.github.wangxianzhuo.lecheng.api.wrapper.common.Config;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HttpRequestBodyTest {
    @Test
    void generateSystemSign() {
        HttpRequestBody requestBody = new HttpRequestBody(Collections.EMPTY_MAP);

        assertNotNull(requestBody.getSystemSign());
        assertEquals(32, requestBody.getSystemSign().length());
    }

    @Test
    void systemJson() throws ArithmeticException {
        Map<String, Object> params = new HashMap<>();
        params.put("a", 1);
        params.put("b", "2");
        params.put("c", 1.1);

        HttpRequestBody requestBody = new HttpRequestBody(params);

        String requestBodyString = requestBody.toString();
        assertAll(
                () -> assertTrue(requestBodyString.contains(Config.getBasicConfig().getAppId()),
                        "not contain " + Config.getBasicConfig().getAppId()),
                () -> assertTrue(requestBodyString.contains("system"), "not contain system"),
                () -> assertTrue(requestBodyString.contains("ver"), "not contain ver"),
                () -> assertTrue(requestBodyString.contains("sign"), "not contain sign"),
                () -> assertTrue(requestBodyString.contains("time"), "not contain time"),
                () -> assertTrue(requestBodyString.contains("nonce"), "not contain nonce"),
                () -> assertTrue(requestBodyString.contains("id"), "not contain id"),
                () -> assertTrue(requestBodyString.contains("params"), "not contain params"),
                () -> assertTrue(requestBodyString.contains("1"), "not contain 1"),
                () -> assertTrue(requestBodyString.contains("\"2\""), "not contain \"2\""),
                () -> assertTrue(requestBodyString.contains("1.1"), "not contain 1.1")
        );
    }
}