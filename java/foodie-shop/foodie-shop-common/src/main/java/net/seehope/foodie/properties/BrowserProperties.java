package net.seehope.foodie.properties;

import net.seehope.foodie.common.LoginType;

public class BrowserProperties {

	/**
	 * 默认允许的静态资源文件的访问端口 localhost和127.0.0.1是不同的
	 */
	private String baseStaticServerUrl = "http://127.0.0.1:8848";

	private String loginProcessingUrl = "passport/login";

	private String loginPage = "/default-signin.html";

	private int tokenValiditySeconds = 60 * 60 * 24 * 7;

	private LoginType loginType = LoginType.JSON;

	public LoginType getLoginType() {
		return loginType;
	}

	public void setLoginType(LoginType loginType) {
		this.loginType = loginType;
	}

	public String getLoginPage() {
		return loginPage;
	}

	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}

	public String getBaseStaticServerUrl() {
		return baseStaticServerUrl;
	}

	public void setBaseStaticServerUrl(String baseStaticServerUrl) {
		this.baseStaticServerUrl = baseStaticServerUrl;
	}

	public String getLoginProcessingUrl() {
		return loginProcessingUrl;
	}

	public void setLoginProcessingUrl(String loginProcessingUrl) {
		this.loginProcessingUrl = loginProcessingUrl;
	}

	public int getTokenValiditySeconds() {
		return tokenValiditySeconds;
	}

	public void setTokenValiditySeconds(int tokenValiditySeconds) {
		this.tokenValiditySeconds = tokenValiditySeconds;
	}

}
