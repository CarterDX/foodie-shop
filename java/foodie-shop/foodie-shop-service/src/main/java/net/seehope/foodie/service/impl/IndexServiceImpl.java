package net.seehope.foodie.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.seehope.foodie.mapper.CarouselMapper;
import net.seehope.foodie.mapper.CategoryMapper;
import net.seehope.foodie.pojo.Carousel;
import net.seehope.foodie.pojo.Category;
import net.seehope.foodie.pojo.vo.CarouselVo;
import net.seehope.foodie.pojo.vo.CategoryVo;
import net.seehope.foodie.pojo.vo.RenderIndexInfoVo;
import net.seehope.foodie.service.IndexService;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private CarouselMapper carouselMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CarouselVo> renderCarousel() throws IllegalAccessException, InvocationTargetException {

        List<Carousel> pos = carouselMapper.selectAll();
        List<CarouselVo> vos = new ArrayList<>();
        for (Carousel carousel : pos) {
            vos.add(CarouselVo.toCarouselVo(carousel));
        }
        return vos;
    }

    @Override
    public List<Category> renderCategory() {
        Category category = new Category();
        category.setType(1);;

        return categoryMapper.select(category);
    }

    @Override
    public List<CategoryVo> renderSubCategory(String rootCatId) {
        return categoryMapper.querySubCatgoryLazyLoad(rootCatId);
    }

    @Override
    public RenderIndexInfoVo renderIndexInfo(String rootCatId) {
        return categoryMapper.queryIndexInfo(rootCatId);
    }

}
