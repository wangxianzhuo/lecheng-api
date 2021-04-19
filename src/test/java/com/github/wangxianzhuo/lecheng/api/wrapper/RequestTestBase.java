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

import com.github.wangxianzhuo.lecheng.api.wrapper.api.Api;
import com.github.wangxianzhuo.lecheng.api.wrapper.common.Config;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * description: RequestTestBase
 * date: 2021/4/19 18:52
 *
 * @author: shangjie
 * @version: 1.0
 */
public class RequestTestBase {
    public void basicConfigCheck() {
        Config config = Config.getBasicConfig();
        basicConfigAccessTokenInit(config);

        assertNotNull(config.getAppId(), "don't config vm options app.id");
        assertNotNull(config.getAppSecret(), "don't config vm options app.secret");
    }

    private void basicConfigAccessTokenInit(Config config) {
        String accessToken = System.getProperty("test.access.token");
        if (Objects.isNull(accessToken)) {
            Api.getAccessToken();
        } else {
            config.setAccessToken(accessToken);
        }
    }
}
