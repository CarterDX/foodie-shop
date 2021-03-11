package net.seehope.foodie.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.n3r.idworker.Sid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.seehope.foodie.mapper.UserAddressMapper;
import net.seehope.foodie.pojo.UserAddress;
import net.seehope.foodie.pojo.vo.AddressBo;
import net.seehope.foodie.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private Sid sid;

	private static final Logger log = LoggerFactory.getLogger(AddressServiceImpl.class);

	@Autowired
	private UserAddressMapper addressMapper;

	@Transactional
	@Override
	public int addAddress(AddressBo bo) throws IllegalAccessException, InvocationTargetException {
		UserAddress userAddress = bo.toUserAddress();
		UserAddress defaultAddress = new UserAddress();
		defaultAddress.setUserId(bo.getUserId());
		defaultAddress.setIsDefault(1);
		defaultAddress = addressMapper.selectOne(defaultAddress);

		if (defaultAddress != null) {
			userAddress.setIsDefault(0);
		} else {
			userAddress.setIsDefault(1);
		}

		userAddress.setCreatedTime(new Date());
		userAddress.setUpdatedTime(new Date());
		userAddress.setId(sid.nextShort());

		log.info(ReflectionToStringBuilder.toString(userAddress, ToStringStyle.MULTI_LINE_STYLE));

		return addressMapper.insert(userAddress);
	}

	@Override
	public List<AddressBo> listAddress(String userId) throws IllegalAccessException, InvocationTargetException {

		UserAddress address = new UserAddress();
		address.setUserId(userId);

		List<AddressBo> addressBoList = new ArrayList<AddressBo>();

		List<UserAddress> userAddressList = addressMapper.select(address);
		for (UserAddress userAddress : userAddressList) {
			AddressBo bo = new AddressBo();
			BeanUtils.copyProperties(bo, userAddress);
			addressBoList.add(bo);
		}
		return addressBoList;
	}

}
