package net.seehope.foodie.common;

public enum YesOrNo {

	YES(1, "是"), NO(0, "否");

	public final Integer type;
	public final String content;

	YesOrNo(Integer type, String content) {
		this.type = type;
		this.content = content;

	}
}
