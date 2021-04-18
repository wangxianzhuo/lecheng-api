package com.github.wangxianzhuo.lecheng.api.wrapper;

/**
 * description: Config
 * date: 2021/4/18 11:41
 *
 * @author: shangjie
 * @version: 1.0
 */
public class Config {
    private final String appId;
    private final String appSecret;
    private static final Config baseConfig = new Config();

    public Config() {
        this.appId = System.getProperty("app.id");
        this.appSecret = System.getProperty("app.secret");
    }

    public String getAppId() {
        return appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public static Config getBaseConfig() {
        return baseConfig;
    }
}
