package net.seehope.foodie.mapper;

import java.util.List;

import net.seehope.foodie.pojo.Items;
import net.seehope.foodie.pojo.bo.SearchBo;
import net.seehope.foodie.pojo.vo.SearchItemVo;

/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
public interface ItemsMapper extends tk.mybatis.mapper.common.Mapper<Items> {
    public List<SearchItemVo> queryItemVoLikeName(SearchBo bo);
}
