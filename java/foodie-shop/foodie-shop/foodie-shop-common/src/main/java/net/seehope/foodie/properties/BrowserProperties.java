package net.seehope.foodie.properties;

public class BrowserProperties {

    /**
     * 默认允许的静态资源文件的访问端口
     * localhost和127.0.0.1是不同的
     */
    private String baseStaticServerUrl = "http://127.0.0.1:8848";

    public String getBaseStaticServerUrl() {
        return baseStaticServerUrl;
    }

    public void setBaseStaticServerUrl(String baseStaticServerUrl) {
        this.baseStaticServerUrl = baseStaticServerUrl;
    }

}
