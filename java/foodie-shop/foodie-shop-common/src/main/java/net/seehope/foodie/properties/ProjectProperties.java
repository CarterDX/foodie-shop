package net.seehope.foodie.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
//@EnableConfigurationProperties注解的作用是：使使用 @ConfigurationProperties 注解的类生效。
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "net.seehope")
public class ProjectProperties {

	private String userDefaultFace = "http://122.152.205.72:88/group1/M00/00/05/CpoxxFw_8_qAIlFXAAAcIhVPdSg994.png";

	private BrowserProperties browser = new BrowserProperties();

	private ValidateCodeProperties code = new ValidateCodeProperties();

	private QQProperties qq = new QQProperties();

	public ValidateCodeProperties getCode() {
		return code;
	}

	public void setCode(ValidateCodeProperties code) {
		this.code = code;
	}

	public BrowserProperties getBrowser() {
		return browser;
	}

	public void setBrowser(BrowserProperties browser) {
		this.browser = browser;
	}

	public QQProperties getQq() {
		return qq;
	}

	public void setQq(QQProperties qq) {
		this.qq = qq;
	}

	public String getUserDefaultFace() {
		return userDefaultFace;
	}

	public void setUserDefaultFace(String userDefaultFace) {
		this.userDefaultFace = userDefaultFace;
	}

}
