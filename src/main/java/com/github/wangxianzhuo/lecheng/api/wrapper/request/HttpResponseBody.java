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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.Map;

/**
 * description: HttpResponseBody
 * date: 2021/4/18 11:20
 *
 * @author: shangjie
 * @version: 1.0
 */
public class HttpResponseBody {
    private String id;
    private Result result;

    public HttpResponseBody() {
    }

    public HttpResponseBody(String id, Result result) {
        this.id = id;
        this.result = result;
    }

    public static HttpResponseBody parseJson(String jsonString) {
        return JSON.parseObject(jsonString, HttpResponseBody.class);
    }

    public String getId() {
        return id;
    }

    public Result getResult() {
        return result;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public static class Result {
        @JSONField(name = "code")
        private ResultCode resultCode;
        private String msg;
        private Map data;

        public Result() {
        }

        public Result(ResultCode resultCode, String msg, Map data) {
            this.resultCode = resultCode;
            this.msg = msg;
            this.data = data;
        }

        public ResultCode getResultCode() {
            return resultCode;
        }

        public String getMsg() {
            return msg;
        }

        public Map getData() {
            return data;
        }

        public void setResultCode(ResultCode resultCode) {
            this.resultCode = resultCode;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public void setData(Map data) {
            this.data = data;
        }
    }

    public enum ResultCode {
        ZERO("0", "操作成功"),
        OP1001("OP1001", "操作失败"),
        OP1002("OP1002", "参数缺失，请确认参数是否有缺失"),
        OP1003("OP1003", "参数取值不合法(参数格式有误或为空)，请修正参数值"),
        OP1004("OP1004", "请求内容为空"),
        OP1005("OP1005", "无效的请求URL"),
        OP1006("OP1006", "SDK异常"),
        OP1007("OP1007", "无效的方法调用"),
        OP1008("OP1008", "appId为空"),
        OP1009("OP1009", "权限不足，无法执行此操作"),
        OP1010("OP1010", "应用被冻结"),
        OP1011("OP1011", "当天调用接口次数已达上限"),
        OP1012("OP1012", "调用接口权限不足"),
        OP1013("OP1013", "调用接口次数超出限制(总数)"),
        OP1014("OP1014", "调用接口次数超出限制（每天）"),
        OP1015("OP1015", "权限不足，无法执行此操作。(该设备不是开放平台绑定设备)"),
        OP1016("OP1016", "请求的设备相关接口达到限制。"),
        OP1019("OP1019", "此时间段无录像产生"),
        OP1021("OP1021", "获取播放地址失败"),
        OP1023("OP1023", "kitToken已过期，请重新获取"),
        SN1001("SN1001", "签名异常"),
        SN1002("SN1002", "签名超时"),
        SN1003("SN1003", "签名参数错误"),
        SN1004("SN1004", "非法的appid"),
        SN1005("SN1005", "重复的nonce"),
        TK1001("TK1001", "该账户（phone）对应的用户与您的应用已绑定"),
        TK1002("TK1002", "token已过期或不存在，请重新获取token"),
        TK1003("TK1003", "非法token，请传入正确的token"),
        TK1004("TK1004", "当前用户的手机号码还未跟您的应用绑定"),
        TK1005("TK1005", "绑定用户数量超出限制"),
        TK1006("TK1006", "当前手机号码不是开发者账号的手机号码，开发者创建应用后，在开放平台网站>开发中心>应用详情页中可以找到管理员账号一项。"),
        TK2001("TK2001", "失效的csrfToken"),
        DV1001("DV1001", "设备已被其他账号绑定"),
        DV1002("DV1002", "设备不存在"),
        DV1003("DV1003", "设备已被当前账号绑定"),
        DV1004("DV1004", "更新通道名称失败"),
        DV1005("DV1005", "设备验证码错误"),
        DV1006("DV1006", "无需更新设备，设备已是最新版本"),
        DV1007("DV1007", "设备离线"),
        DV1008("DV1008", "绑定设备数量超出限制，请先解绑其他冗余设备"),
        DV1009("DV1009", "设备正忙，请稍后再试"),
        DV1010("DV1010", "图请求过于频繁，请稍后再试"),
        DV1011("DV1011", "设备未添加，请先绑定设备"),
        DV1012("DV1012", "权限不足，该设备属于被授权（或被共享）设备"),
        DV1013("DV1013", "设备注册3天后绑定,客户端与设备必须在同一个局域网内，设备断电重启下即可再次绑定。"),
        DV1014("DV1014", "设备绑定错误连续超过10次，限制绑定30分钟"),
        DV1015("DV1015", "设备绑定错误连续超过20次，限制绑定24小时"),
        DV1016("DV1016", "设备密码错误。"),
        DV1018("DV1018", "设备注册到平台，超过三天未绑定，需在局域网内绑定，或重启设备后进行绑定"),
        DV1019("DV1019", "设备能力集不支持此操作"),
        DV1020("DV1020", "设备通道离线。"),
        DV1021("DV1021", "设备异常。"),
        DV1022("DV1022", "收藏点个数超出限制"),
        DV1023("DV1023", "收藏点已存在"),
        DV1024("DV1024", "收藏点不存在"),
        DV1025("DV1025", "设备SC码或设备密码错误"),
        DV1026("DV1026", "该设备不支持此功能的调用"),
        DV1027("DV1027", "设备安全码错误"),
        DV1028("DV1028", "用户未绑定该设备或设备通道号不存在"),
        DV1029("DV1029", "设备已经被绑定"),
        DV1030("DV1030", "设备休眠中"),
        DV1031("DV1031", "低电量拒绝升级(带电池设备)"),
        DV1032("DV1032", "设备已被本人锁定"),
        DV1033("DV1033", "设备已被他人绑定"),
        DV1034("DV1034", "设备未初始化"),
        DV1035("DV1035", "设备初始化失败"),
        DV1036("DV1036", "注销失败，设备未离线达5分钟"),
        DV1037("DV1037", "NB设备的imei和device id 不匹配"),
        DV1038("DV1038", "低电量时无法添加临时秘钥"),
        DV1039("DV1039", "临时密钥生成不满足条件"),
        DV1040("DV1040", "设备已被绑定失败20次 限制绑定24小时"),
        DV1041("DV1041", "转移设备数量超过设定的最大值"),
        DV1042("DV1042", "设备密码错误达限制次数，设备锁定"),
        DV1043("DV1043", "项目属性不支持"),
        DV1044("DV1044", "设备IP不在统一局域网内"),
        DV1045("DV1045", "设备冲突"),
        DV1047("DV1047", "设备已经自定义加密"),
        DV1049("DV1049", "设备无存储介质"),
        DV1050("DV1050", "临时秘钥生成次数超限制"),
        DV1051("DV1051", "人脸库不存在"),
        DV1052("DV1052", "添加超过人脸库的上限"),
        WF1001("WF1001", "请求超时"),
        WF1002("WF1002", "wifi密码错误"),
        SM1001("SM1001", "验证码输入错误"),
        SM1002("SM1002", "验证码已过期，请重新获取验证码"),
        SM1003("SM1003", "服务器处理错误"),
        SM1004("SM1004", "发送验证码短信失败"),
        SM1005("SM1005", "当天获取短信验证码次数已达上限"),
        SM1006("SM1006", "短信发送过于频繁，请稍后再试"),
        SMS01("SMS01", "短信发送次数超出限制"),
        SMS02("SMS02", "短信发送次数超出限制"),
        TH1001("TH1001", "当前方法有误，不是透传接口方法"),
        TH1003("TH1003", "消息回调URL格式有误"),
        ST1001("ST1001", "当前设备默认云存储套餐已到期，操作失败"),
        ST1002("ST1002", "当前设备无默认云存储套餐，操作失败"),
        ST1003("ST1003", "当前使用的云存储套餐不是默认云存储套餐，操作失败"),
        ST1004("ST1004", "云存储套餐未开通"),
        ST1005("ST1005", "云存储套餐已过期"),
        ST1006("ST1006", "云存储套餐不存在"),
        ST1007("ST1007", "调用开通云存储接口次数不足一次"),
        ST1008("ST1008", "当前设备使用的定时录像计划用云存储套餐使用中，需暂停"),
        ST1009("ST1009", "操作失败，当前设备仍有未过期的收费云存储套餐策略。"),
        ST1010("ST1010", "该设备不支持对应云存储套餐策略"),
        RC1001("RC1001", "云录像未找到"),
        LV1001("LV1001", "该视频直播已存在"),
        LV1002("LV1002", "该视频直播不存在"),
        LV1004("LV1004", "设备已经自定义加密密钥"),
        LV1005("LV1005", "直播信息不存在。"),
        LV1006("LV1006", "操作失败，同一rtsp源地址同一天内仅能被绑定1次。"),
        LV1008("LV1008", "创建直播需要实名认证，请前往开放平台网站-基本信息页完善信息，如是个人用户请上传本人身份证，如果是公司客户请上传营业执照以及其他"),
        LV1020("LV1020", "已绑定直播,无法删除"),
        YL1001("YL1001", "定时拉取模式下，拉取的时间点不能在定时录像计划时间内。"),
        YL1002("YL1002", "定时计划时间参数重合，重合时间为XX-XX。"),
        YL1003("YL1003", "操作失败，存在有效的云存储录像计划，请关闭云存储录像计划后重试。"),
        YL1004("YL1004", "操作失败，存在有效的动检计划，请关闭动检计划后重试。"),
        YL1005("YL1005", "操作失败，请开通支持设置云存储录像计划的云存储策略套餐。"),
        GT1001("GT1001", "授权角色已经存在"),
        GT1002("GT1002", "添加角色失败"),
        GT1003("GT1003", "用户授权已经存在"),
        GT1004("GT1004", "创建用户授权失败"),
        GT1005("GT1005", "用户授权不存在"),
        GT1006("GT1006", "角色不存在"),
        GT1007("GT1007", "角色为默认角色"),
        GT1008("GT1008", "授权超过限制"),
        GT1009("GT1009", "不能授权给自己"),
        GT1010("GT1010", "获取授权列表失败"),
        GT1011("GT1011", "获取权限列表所传参数有误"),
        GP1001("GP1001", "设备分组名称已经存在"),
        GP1002("GP1002", "设备分组Id不存在"),
        GP1003("GP1003", "设备已被添加至分组"),
        US1001("US1001", "用户不存在"),
        US1002("US1002", "该用户不存在这个授权关系"),
        P2P001("P2P001", "P2P鉴权接口，鉴权ID 已过期"),
        P2P002("P2P002", "P2P鉴权接口，头部域参数缺失"),
        P2P003("P2P003", "token过期"),
        P2P004("P2P004", "没有设备权限"),
        AD1001("AD1001", "未绑定综治员"),
        LD1001("LD1001", "设备本地无存储介质"),
        AP1001("AP1001", "配件不存在"),
        AP1002("AP1002", "配件离线"),
        FL1001("FL1001", "开发者剩余接入数不足"),
        FL1002("FL1002", "开发者当前无可用带宽"),
        FL1003("FL1003", "开发者当前使用带宽超过额度限制"),
        FL1004("FL1004", "开发者剩余流量不足"),
        FL1005("FL1005", "开发者音视频取流操作时没有可用带宽且剩余流量不足"),
        PF1001("PF1001", "repositoryToken不存在"),
        PF1002("PF1002", "faceToken不存在"),
        PF1003("PF1003", "未检测到人脸"),
        PF1004("PF1004", "暂不支持该功能"),
        PF1005("PF1005", "图片大小超过2M限制"),
        PF1006("PF1006", "type类型不匹配"),
        PF1007("PF1007", "获取特征值失败，请先进行图片检测"),
        UR1000("UR1000", "用户未登陆"),
        UR1001("UR1001", "不支持邮箱登陆"),
        PH1001("PH1001", "修改手机号频次已达上限"),
        ST1011("ST1011", "调用接口次数超过限制，同一个套餐24小时内只能解绑一次"),
        ST1012("ST1012", "免费云存储不支持解绑"),
        SUB1000("SUB1000", "当前子账号无接口使用权限"),
        SUB1001("SUB1001", "当前子账号无接口使用权限"),
        SUB1002("SUB1002", "当前子账号无接口使用权限"),
        SUB1005("SUB1005", "子账号token过期"),
        SUB1006("SUB1006", "子账号与设备无授权关系"),
        SUB1007("SUB1007", "创建子账号失败"),
        SUB1008("SUB1008", "子账号与当前应用无绑定关系");
        private final String code;
        private final String description;

        ResultCode(String code, String description) {
            this.code = code;
            this.description = description;
        }

        @JSONField
        public String getCode() {
            return code;
        }

        @JSONCreator
        public static ResultCode from(String code) {
            for (ResultCode v : values()) {
                if (v.code.equals(code)) {
                    return v;
                }
            }

            throw new IllegalArgumentException("code " + code);
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return "{" + code + ", " + description + "}";
        }
    }
}
