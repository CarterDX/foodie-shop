package net.seehope.foodie.mapper;

import java.util.List;

import net.seehope.foodie.pojo.ItemsComments;
import net.seehope.foodie.pojo.bo.RenderCommentLevelBo;
import net.seehope.foodie.pojo.dto.CountDto;
import net.seehope.foodie.pojo.vo.CommentRecordVo;

/**
 * 通用 Mapper 代码生成器
 *
 * @author mapper-generator
 */
public interface ItemsCommentsMapper extends tk.mybatis.mapper.common.Mapper<ItemsComments> {
	List<CountDto> queryCommentsLevel(String itemsId);

	List<CommentRecordVo> renderCommentByItemIdAndLevel(RenderCommentLevelBo bo);
}
