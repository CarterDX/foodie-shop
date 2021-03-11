package net.seehope.foodie.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import net.seehope.foodie.mapper.ItemsMapper;
import net.seehope.foodie.pojo.bo.SearchBo;
import net.seehope.foodie.pojo.vo.PageGridResult;
import net.seehope.foodie.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public PageGridResult renderSearchItem(SearchBo bo) {
        String sort = bo.getSort();
        if (StringUtils.equals(sort, "k") || StringUtils.equals(sort, "c") || StringUtils.equals(sort, "p")) {
            PageHelper.startPage(bo.getPage(), bo.getPageSize());
            PageGridResult pageGridResult = new PageGridResult();
            pageGridResult.setRows(itemsMapper.queryItemVoLikeName(bo));
            pageGridResult.setPage(bo.getPage());
            return pageGridResult;

        } else {
            throw new RuntimeException("sort 参数异常 无当前排序依据");
        }

    }

}
