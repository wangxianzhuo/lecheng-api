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

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApiTestBaseTest extends ApiTestBase {
    private final String propertyFileName = "src/test/java/com/github/wangxianzhuo/lecheng/api/wrapper/properties/test.properties";

    @Test
    void loadPropertiesFromFileTest() {
        assertDoesNotThrow(() -> loadPropertiesFromFile(propertyFileName), "load properties error");

        assertAll(
                () -> assertNotNull(System.getProperty("app.id"), "don't config app.id"),
                () -> assertNotNull(System.getProperty("app.secret"), "don't config app.secret"),
                () -> assertNotNull(System.getProperty("test.access.token"), "don't config test.access.token"),
                () -> assertNotNull(System.getProperty("test.device.id"), "don't config test.device.id"),
                () -> assertNotNull(System.getProperty("test.channel.id"), "don't config test.channel.id")
        );
    }
}