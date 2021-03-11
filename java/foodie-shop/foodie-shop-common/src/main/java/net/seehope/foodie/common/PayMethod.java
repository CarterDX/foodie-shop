package net.seehope.foodie.common;

public enum PayMethod {

	YES(1, "微信支付"), NO(2, "支付宝支付");

	public final Integer type;
	public final String content;

	PayMethod(Integer type, String content) {
		this.type = type;
		this.content = content;

	}
}