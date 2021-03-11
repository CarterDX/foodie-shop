package net.seehope.foodie.controller;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.seehope.foodie.common.JsonResult;
import net.seehope.foodie.service.IndexService;

@Api("渲染商城首页的控制器")
@RestController
@RequestMapping("index")
public class IndexController {

    @Autowired
    private IndexService indexService;

    @ApiOperation("渲染首页的轮播图")
    @GetMapping("carousel")
    public JsonResult renderCarousel() throws IllegalAccessException, InvocationTargetException {
        return JsonResult.isOk(indexService.renderCarousel());
    }

    @ApiOperation("渲染根节点，也就是数据库中type=1的category")
    @GetMapping("cats")
    public JsonResult renderRootCat() {
        return JsonResult.isOk(indexService.renderCategory());
    }

    @ApiOperation("渲染首页根目录中的字目录列表当用户鼠标移到根目录中的时候，渲染子目录数据")
    @GetMapping("/subCat/{rootCatId:\\d+}")
    public JsonResult renderSubCat(@PathVariable String rootCatId) {
        return JsonResult.isOk(indexService.renderSubCategory(rootCatId));
    }

    @ApiOperation("渲染首页分类中商品列表  懒加载")
    @GetMapping("/sixNewItems/{rootCatId:\\d+}")
    public JsonResult renderSixNewItems(@PathVariable String rootCatId) {
        return JsonResult.isOk(indexService.renderIndexInfo(rootCatId));
    }
}
