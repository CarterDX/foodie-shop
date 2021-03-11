package net.seehope.foodie.pojo.bo;

import javax.validation.constraints.NotNull;

public class CreateOrdersBo {
	@NotNull(message = "请选择支付地址")
	private String addressId;

	@NotNull(message = "请选择支付方式")
	private Integer payMethod;

	@NotNull(message = "必须先登录")
	private String userId;

	private String leftMsg;
	private String itemSpecIds;

	public String getItemSpecIds() {
		return itemSpecIds;
	}

	public void setItemSpecIds(String itemSpecIds) {
		this.itemSpecIds = itemSpecIds;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public Integer getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(Integer payMethod) {
		this.payMethod = payMethod;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLeftMsg() {
		return leftMsg;
	}

	public void setLeftMsg(String leftMsg) {
		this.leftMsg = leftMsg;
	}

}
