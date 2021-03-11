package net.seehope.foodie.pojo.vo;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import net.seehope.foodie.pojo.Category;

@ApiModel("在查询首页 跟分类下的子分类中应用的视图对象 二级以及三级分类对象")
public class CategoryVo extends Category {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private List<Category> subCatList = new ArrayList<>();

    public List<Category> getSubCatList() {
        return subCatList;
    }

    public void setSubCatList(List<Category> subCatList) {
        this.subCatList = subCatList;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
