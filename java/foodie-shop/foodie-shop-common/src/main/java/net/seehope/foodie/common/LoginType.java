package net.seehope.foodie.common;

public enum LoginType {

	JSON(1, "微信支付"), REDIRECT(2, "支付宝支付");

	public final Integer type;
	public final String content;

	LoginType(Integer type, String content) {
		this.type = type;
		this.content = content;

	}
}