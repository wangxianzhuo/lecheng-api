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

import com.github.wangxianzhuo.lecheng.api.wrapper.common.exception.AccessFailedException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApiTest extends ApiTestBase {
    private final String propertyFileName = "src/test/java/com/github/wangxianzhuo/lecheng/api/wrapper/properties/test.properties";

    @BeforeEach
    void setUp() {
        assertDoesNotThrow(() -> loadPropertiesFromFile(propertyFileName), "load test properties error");
        basicConfigCheck();
        basicParamsCheck();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void executeSetDeviceSnapReturnURL() {
        Api setDeviceSnapReturnURL = new SetDeviceSnapReturnURL(deviceId, channelId);
        Object url = setDeviceSnapReturnURL.execute();

        assertDoesNotThrow(() -> String.valueOf(url));
        assertNotNull(url, "url is null");
        System.out.println(url);


        Api setDeviceSnapReturnURLWithIncorrectDeviceIdOrChannelId = new SetDeviceSnapReturnURL("a", "1");
        assertThrows(AccessFailedException.class,
                setDeviceSnapReturnURLWithIncorrectDeviceIdOrChannelId::execute,
                "should throw AccessFailedException");

    }
}