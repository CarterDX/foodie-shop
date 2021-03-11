package net.seehope.foodie.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import net.seehope.foodie.common.JsonResult;
import net.seehope.foodie.pojo.bo.CreateOrdersBo;
import net.seehope.foodie.service.OrdersService;

@RestController
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	private OrdersService ordersService;

	@ApiOperation("")
	@PostMapping("/create")
	public JsonResult createOrders(@Valid @RequestBody CreateOrdersBo bo) {
		return JsonResult.isOk(ordersService.createOrders(bo));
	}

}
