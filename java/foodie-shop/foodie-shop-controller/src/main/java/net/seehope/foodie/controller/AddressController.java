package net.seehope.foodie.controller;

import java.lang.reflect.InvocationTargetException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.seehope.foodie.common.JsonResult;
import net.seehope.foodie.pojo.vo.AddressBo;
import net.seehope.foodie.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@PostMapping("/add")
	public JsonResult addAddress(@Valid @RequestBody AddressBo bo)
			throws IllegalAccessException, InvocationTargetException {
		return JsonResult.isOk(addressService.addAddress(bo));
	}

	@PostMapping("/list")
	public JsonResult listAddress(@RequestParam(required = true) String userId)
			throws IllegalAccessException, InvocationTargetException {
		return JsonResult.isOk(addressService.listAddress(userId));
	}
}
