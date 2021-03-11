package net.seehope.foodie.service;

import net.seehope.foodie.pojo.bo.SearchBo;
import net.seehope.foodie.pojo.vo.PageGridResult;

public interface ItemService {
    public PageGridResult renderSearchItem(SearchBo bo);
}
