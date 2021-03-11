package net.seehope.foodie.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import net.seehope.foodie.pojo.vo.AddressBo;

public interface AddressService {
	int addAddress(AddressBo bo) throws IllegalAccessException, InvocationTargetException;

	List<AddressBo> listAddress(String userId) throws IllegalAccessException, InvocationTargetException;
}
