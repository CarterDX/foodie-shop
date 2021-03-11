package net.seehope.foodie.pojo.vo;

import java.lang.reflect.InvocationTargetException;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.beanutils.BeanUtils;

import net.seehope.foodie.pojo.UserAddress;

public class AddressBo {
	@Pattern(regexp = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$", message = "请输入正确的手机号")
	private String mobile;
	@NotNull(message = "详细地址不能为空")
	private String detail;
	@NotNull(message = "行政区不能为空")
	private String district;
	@NotNull(message = "城市不能为空")
	private String city;
	@NotNull(message = "省份不能为空")
	private String province;
	@NotNull(message = "收件人不能为空")
	private String receiver;
	@NotNull(message = "用户当前未登录")
	private String userId;
	
	
	private String id;

	/*
	 * public static UserAddress toUserAddress(AddressBo bo) throws
	 * IllegalAccessException, InvocationTargetException { UserAddress userAddress =
	 * new UserAddress(); BeanUtils.copyProperties(userAddress, bo); return
	 * userAddress; }
	 */

	public UserAddress toUserAddress() throws IllegalAccessException, InvocationTargetException {
		UserAddress userAddress = new UserAddress();
		BeanUtils.copyProperties(userAddress, this);
		return userAddress;
	}

	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
