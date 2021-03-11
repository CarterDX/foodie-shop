package net.seehope.foodie.common;

public enum CommentLevel {

	GOOD(1, "好评"), MEDIUM(2, "中评"), BAD(3, "差评");

	public final Integer type;
	public final String content;

	CommentLevel(Integer type, String content) {
		this.type = type;
		this.content = content;

	}
}
