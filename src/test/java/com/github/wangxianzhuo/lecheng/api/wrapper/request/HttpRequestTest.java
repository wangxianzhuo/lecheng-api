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

import static org.junit.jupiter.api.Assertions.*;

class HttpRequestTest {

    @BeforeEach
    void setUp() {
        Config config = Config.getBaseConfig();
        assertNotNull(config.getAppId(), "don't config vm options app.id");
        assertNotNull(config.getAppSecret(), "don't config vm options app.secret");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void request() {
        String method = "accessToken";
        HttpResponseBody httpResponseBody = HttpRequest.request(method, Collections.EMPTY_MAP);

        assertNotNull(httpResponseBody.getResult());
        assertAll(
                () -> assertTrue(httpResponseBody.getResult().getData().containsKey("expireTime"), "don't have key expiredTime"),
                () -> assertTrue(httpResponseBody.getResult().getData().containsKey("accessToken"), "don't have key accessToken")
        );
    }
}