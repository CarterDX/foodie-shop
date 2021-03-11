package net.seehope.foodie.pojo.vo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.seehope.foodie.pojo.Carousel;

public class CarouselVo {

    private String id;
    private String imageUrl;
    private String backgroundColor;
    private String itemId;
    private String catId;
    private Integer type;
    private Integer sort;
    private Integer isShow;

    public CarouselVo() {}

    public static CarouselVo toCarouselVo(Carousel carousel) throws IllegalAccessException, InvocationTargetException {
        CarouselVo vo = new CarouselVo();
        BeanUtils.copyProperties(vo, carousel);
        return vo;
    }

    public CarouselVo(String id, String imageUrl, String backgroundColor, String itemId, String catId, Integer type,
        Integer sort, Integer isShow) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.backgroundColor = backgroundColor;
        this.itemId = itemId;
        this.catId = catId;
        this.type = type;
        this.sort = sort;
        this.isShow = isShow;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

}
