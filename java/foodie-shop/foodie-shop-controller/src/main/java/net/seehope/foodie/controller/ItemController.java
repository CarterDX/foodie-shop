package net.seehope.foodie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.seehope.foodie.common.JsonResult;
import net.seehope.foodie.pojo.bo.RenderCommentLevelBo;
import net.seehope.foodie.pojo.bo.SearchBo;
import net.seehope.foodie.service.ItemService;

@Api("商品相关方法API")
@RestController
@RequestMapping("items")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@GetMapping("search")
	public JsonResult renderSearchItem(SearchBo bo) {
		return JsonResult.isOk(itemService.renderSearchItem(bo));
	}

	@ApiOperation("渲染商品详情页面，包含四个对象，items本身，itemsparm itemimglist itemspeclist")
	@GetMapping("/info/{itemId}")
	public JsonResult renderItemInfo(@PathVariable String itemId) {
		return JsonResult.isOk(itemService.renderItemInfo(itemId));
	}

	@ApiOperation("渲染商品评论数量，好评为1，中评为2，差评为3")
	@GetMapping("/commentLevel")
	public JsonResult renderItemsCommentsLevel(String itemId) {
		return JsonResult.isOk(itemService.renderItemsCommentsLevel(itemId));
	}

	@ApiOperation("通过商品ID以及级别渲染商品评论")
	@GetMapping("/comments")
	public JsonResult renderItemsCommentsByLevelAndItemId(RenderCommentLevelBo bo) {
		return JsonResult.isOk(itemService.renderItemCommentByLevelAndItemId(bo));
	}

	@ApiOperation("渲染购物车中的商品")
	@GetMapping("/refresh")
	public JsonResult renderShopCartItems(String itemSpecIds) {
		return JsonResult.isOk(itemService.renderShopCart(itemSpecIds));
	}
}
