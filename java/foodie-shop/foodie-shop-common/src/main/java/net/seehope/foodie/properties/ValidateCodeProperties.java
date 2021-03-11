package net.seehope.foodie.properties;

public class ValidateCodeProperties {

	private int width = 67;
	private int height = 23;
	private int length = 4;
	private int expireIn = 60 * 15;

	/**
	 * 验证码需要拦截的请求的地址 如果有多个地址，中间以逗号隔开
	 */
	private String urls = "/authentication/form";

	public String getUrls() {
		return urls;
	}

	public void setUrls(String urls) {
		this.urls = urls;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getExpireIn() {
		return expireIn;
	}

	public void setExpireIn(int expireIn) {
		this.expireIn = expireIn;
	}

}
