package net.seehope.foodie.pojo.vo;

import java.util.ArrayList;
import java.util.List;

import net.seehope.foodie.pojo.Items;
import net.seehope.foodie.pojo.ItemsImg;
import net.seehope.foodie.pojo.ItemsParam;
import net.seehope.foodie.pojo.ItemsSpec;

public class ItemInfoVo {

    private Items item;
    private ItemsParam itemParams;
    private List<ItemsSpec> itemSpecList = new ArrayList<>();
    private List<ItemsImg> itemImgList = new ArrayList<>();

    public Items getItem() {
        return item;
    }

    public void setItem(Items item) {
        this.item = item;
    }

    public ItemsParam getItemParams() {
        return itemParams;
    }

    public void setItemParams(ItemsParam itemParams) {
        this.itemParams = itemParams;
    }

    public List<ItemsSpec> getItemSpecList() {
        return itemSpecList;
    }

    public void setItemSpecList(List<ItemsSpec> itemSpecList) {
        this.itemSpecList = itemSpecList;
    }

    public List<ItemsImg> getItemImgList() {
        return itemImgList;
    }

    public void setItemImgList(List<ItemsImg> itemImgList) {
        this.itemImgList = itemImgList;
    }

}
