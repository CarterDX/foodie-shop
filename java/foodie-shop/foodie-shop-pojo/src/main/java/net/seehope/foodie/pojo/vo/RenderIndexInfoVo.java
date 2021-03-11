package net.seehope.foodie.pojo.vo;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;

@ApiModel("渲染首页的商品根分类，以及分类中的6个商品")
public class RenderIndexInfoVo {
    private String rootCatName;
    private String slogan;
    private String bgColor;
    private String catImage;

    private List<SimpleItemVo> simpleItemList = new ArrayList<>();

    public String getRootCatName() {
        return rootCatName;
    }

    public void setRootCatName(String rootCatName) {
        this.rootCatName = rootCatName;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public String getCatImage() {
        return catImage;
    }

    public void setCatImage(String catImage) {
        this.catImage = catImage;
    }

    public List<SimpleItemVo> getSimpleItemList() {
        return simpleItemList;
    }

    public void setSimpleItemList(List<SimpleItemVo> simpleItemList) {
        this.simpleItemList = simpleItemList;
    }

}
