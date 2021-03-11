package net.seehope.foodie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import net.seehope.foodie.common.JsonResult;
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
}
