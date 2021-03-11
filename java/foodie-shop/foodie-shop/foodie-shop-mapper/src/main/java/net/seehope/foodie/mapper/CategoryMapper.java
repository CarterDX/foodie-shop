package net.seehope.foodie.mapper;

import java.util.List;

import net.seehope.foodie.pojo.Category;
import net.seehope.foodie.pojo.vo.CategoryVo;
import net.seehope.foodie.pojo.vo.RenderIndexInfoVo;

/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
public interface CategoryMapper extends tk.mybatis.mapper.common.Mapper<Category> {

    public List<CategoryVo> querySubCatgoryLazyLoad(String rootCatId);

    public RenderIndexInfoVo queryIndexInfo(String rootCatId);
}
