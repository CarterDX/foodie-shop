package net.seehope.foodie.pojo.bo;

import javax.validation.constraints.Size;

public class UsersBo {

	private String confirmPassword;

	@Size(min = 2, max = 36, message = "用户名必须在2到36位之间")
	private String username;

	@Size(min = 6, max = 36, message = "密码必须在6到36位之间")
	private String password;

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
