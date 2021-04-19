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

import com.github.wangxianzhuo.lecheng.api.wrapper.request.HttpRequest;
import com.github.wangxianzhuo.lecheng.api.wrapper.request.HttpResponseBody;

import java.util.HashMap;

public class SetDeviceSnapReturnURL extends Api {
    private final String deviceId;
    private final String channelId;

    public SetDeviceSnapReturnURL(String deviceId, String channelId) {
        this.deviceId = deviceId;
        this.channelId = channelId;
    }

    String execute() {
        String method = "setDeviceSnap";
        HashMap<String, Object> params = getBasicRequestParamsMap(deviceId, channelId);

        HttpResponseBody httpResponseBody = HttpRequest.request(method, params);
        return getValueFromResultData("url", httpResponseBody);
    }
}