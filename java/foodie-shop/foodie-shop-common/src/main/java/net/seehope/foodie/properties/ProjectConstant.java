package net.seehope.foodie.properties;

/*
 * 常量
 */
public class ProjectConstant {
	public final static String LOGIN_PAGE = "/authentication/require";

	/**
	 * 手机登录请求提交的表单的地址
	 */
	public final static String MOBILE_AUTHENTICATION_URL = "/authentication/mobile";

	/**
	 * 要求前端的验证码生成的请求名 如果是图片 那么应该是 img scr=/code/image 如果是 sms 应该是 /code/sms
	 */
	public final static String VALIDATE_CODE_GENERATOR_URL = "/code";

	/**
	 * 验证码在session中的key的名字的后缀
	 */
	public final static String CODE_IN_SESSION_SUFFIX = "_CODE_IN_SESSION";
	/**
	 * 前端传过来的验证码参数的名字
	 */
	public final static String IMAGE_CODE_NAME = "ImageCode";

}
