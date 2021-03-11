package net.seehope.foodie.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.seehope.foodie.common.YesOrNo;
import net.seehope.foodie.mapper.ItemsImgMapper;
import net.seehope.foodie.mapper.ItemsMapper;
import net.seehope.foodie.mapper.ItemsSpecMapper;
import net.seehope.foodie.mapper.OrderItemsMapper;
import net.seehope.foodie.mapper.OrderStatusMapper;
import net.seehope.foodie.mapper.OrdersMapper;
import net.seehope.foodie.mapper.UserAddressMapper;
import net.seehope.foodie.pojo.Items;
import net.seehope.foodie.pojo.ItemsImg;
import net.seehope.foodie.pojo.ItemsSpec;
import net.seehope.foodie.pojo.OrderItems;
import net.seehope.foodie.pojo.OrderStatus;
import net.seehope.foodie.pojo.Orders;
import net.seehope.foodie.pojo.UserAddress;
import net.seehope.foodie.pojo.bo.CreateOrdersBo;
import net.seehope.foodie.service.ItemService;
import net.seehope.foodie.service.OrdersService;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private Sid sid;

	@Autowired
	private ItemsMapper itemsMapper;
	@Autowired
	private ItemsImgMapper itemsImgMapper;
	@Autowired
	private ItemsSpecMapper ItemsSpecMapper;
	@Autowired
	private OrdersMapper ordersMapper;
	@Autowired
	private OrderStatusMapper orderStatusMapper;
	@Autowired
	private OrderItemsMapper orderItemsMapper;
	@Autowired
	private UserAddressMapper userAddressMapper;

	@Autowired
	private ItemService itemService;

	@Transactional
	@Override
	public String createOrders(CreateOrdersBo bo) {

		UserAddress userAddress = new UserAddress();
		userAddress.setId(bo.getAddressId());
		userAddress.setUserId(bo.getUserId());
		UserAddress orderAddress = userAddressMapper.selectOne(userAddress);
		if (orderAddress == null) {
			throw new RuntimeException("请选择正确的用户地址");
		}

		String orderId = sid.nextShort();

		// TODO 邮费，目前统一设置为10，后期会根据第三方接口查询邮费价格
		int postAmount = 1000;
		int realPayAmount = 0;

		Orders orders = new Orders();
		orders.setId(orderId);
		orders.setUserId(bo.getUserId());
		orders.setExtand(bo.getLeftMsg());
		orders.setIsComment(YesOrNo.NO.type);
		orders.setIsDelete(YesOrNo.NO.type);
		orders.setPayMethod(bo.getPayMethod());
		orders.setCreatedTime(new Date());
		orders.setUpdatedTime(new Date());

		orders.setReceiverAddress(orderAddress.getProvince() + orderAddress.getCity() + orderAddress.getDistrict());
		orders.setReceiverMobile(orderAddress.getMobile());
		orders.setReceiverName(orderAddress.getReceiver());

		String[] specIds = StringUtils.splitByWholeSeparatorPreserveAllTokens(bo.getItemSpecIds(), ",");
		List<String> ids = new ArrayList<String>(Arrays.asList(specIds));
		Example example = new Example(ItemsSpec.class);
		Criteria criteria = example.createCriteria();
		criteria.andIn("id", ids);
		List<ItemsSpec> itemsSpecs = ItemsSpecMapper.selectByExample(example);
		for (ItemsSpec itemsSpec : itemsSpecs) {
			int buyCount = 1;

			OrderItems orderItems = new OrderItems();
			orderItems.setBuyCounts(buyCount);
			orderItems.setId(sid.nextShort());
			orderItems.setItemId(itemsSpec.getItemId());

			Items items = new Items();
			items.setId(itemsSpec.getItemId());
			Items specItem = itemsMapper.selectOne(items);
			orderItems.setItemName(specItem.getItemName());

			ItemsImg itemsImg = new ItemsImg();
			itemsImg.setItemId(itemsSpec.getItemId());
			itemsImg.setIsMain(YesOrNo.YES.type);
			ItemsImg specImg = itemsImgMapper.selectOne(itemsImg);
			orderItems.setItemImg(specImg.getUrl());

			orderItems.setItemSpecId(itemsSpec.getId());
			orderItems.setItemSpecName(itemsSpec.getName());
			orderItems.setOrderId(orderId);
			orderItems.setPrice(itemsSpec.getPriceDiscount());

			// 下订单最后一步应该扣除库存 暂时使用乐观锁的方式解决超卖问题
			int result = itemService.decreaseItemSpecsStock(itemsSpec.getId(), buyCount);
			if (result != 1) {
				throw new RuntimeException("商品库存不足" + specItem.getItemName() + itemsSpec.getName());
			}

			orderItemsMapper.insert(orderItems);

			realPayAmount += (buyCount * itemsSpec.getPriceDiscount());
		}

		orders.setRealPayAmount(realPayAmount);
		orders.setPostAmount(postAmount);
		orders.setTotalAmount(realPayAmount + postAmount);

		ordersMapper.insert(orders);

		OrderStatus orderStatus = new OrderStatus();
		orderStatus.setCreatedTime(new Date());
		orderStatus.setOrderId(orderId);
		orderStatus.setOrderStatus(net.seehope.foodie.common.OrderStatus.WAITTING.type);

		orderStatusMapper.insert(orderStatus);

		return orderId;
	}

}
