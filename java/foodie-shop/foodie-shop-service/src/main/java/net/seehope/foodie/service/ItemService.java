package net.seehope.foodie.service;

import java.util.List;

import net.seehope.foodie.pojo.bo.RenderCommentLevelBo;
import net.seehope.foodie.pojo.bo.SearchBo;
import net.seehope.foodie.pojo.vo.CountsVo;
import net.seehope.foodie.pojo.vo.ItemInfoVo;
import net.seehope.foodie.pojo.vo.PageGridResult;
import net.seehope.foodie.pojo.vo.ShopCartItemVo;

public interface ItemService {
	PageGridResult renderSearchItem(SearchBo bo);

	ItemInfoVo renderItemInfo(String itemId);

	CountsVo renderItemsCommentsLevel(String itemId);

	PageGridResult renderItemCommentByLevelAndItemId(RenderCommentLevelBo bo);

	List<ShopCartItemVo> renderShopCart(String itemSpecIds);

	public int decreaseItemSpecsStock(String itemsSpecId, int decreaseCount);
}
