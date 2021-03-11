package net.seehope.foodie.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import net.seehope.foodie.pojo.Category;
import net.seehope.foodie.pojo.vo.CarouselVo;
import net.seehope.foodie.pojo.vo.CategoryVo;
import net.seehope.foodie.pojo.vo.RenderIndexInfoVo;

public interface IndexService {
    public List<CarouselVo> renderCarousel() throws IllegalAccessException, InvocationTargetException;

    public List<Category> renderCategory();

    public List<CategoryVo> renderSubCategory(String rootCatId);

    public RenderIndexInfoVo renderIndexInfo(String rootCatId);
}
