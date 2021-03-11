package net.seehope.foodie.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import net.seehope.foodie.common.CommentLevel;
import net.seehope.foodie.mapper.ItemsCommentsMapper;
import net.seehope.foodie.mapper.ItemsImgMapper;
import net.seehope.foodie.mapper.ItemsMapper;
import net.seehope.foodie.mapper.ItemsParamMapper;
import net.seehope.foodie.mapper.ItemsSpecMapper;
import net.seehope.foodie.pojo.Items;
import net.seehope.foodie.pojo.ItemsImg;
import net.seehope.foodie.pojo.ItemsParam;
import net.seehope.foodie.pojo.ItemsSpec;
import net.seehope.foodie.pojo.bo.RenderCommentLevelBo;
import net.seehope.foodie.pojo.bo.SearchBo;
import net.seehope.foodie.pojo.dto.CountDto;
import net.seehope.foodie.pojo.vo.CommentRecordVo;
import net.seehope.foodie.pojo.vo.CountsVo;
import net.seehope.foodie.pojo.vo.ItemInfoVo;
import net.seehope.foodie.pojo.vo.PageGridResult;
import net.seehope.foodie.pojo.vo.ShopCartItemVo;
import net.seehope.foodie.service.ItemService;
import net.seehope.foodie.util.DesensitizationUtil;

@Service
public class ItemServiceImpl implements ItemService {

	private static final Logger log = LoggerFactory.getLogger(ItemServiceImpl.class);

	@Autowired
	private ItemsMapper itemsMapper;

	@Autowired
	private ItemsParamMapper itemsParamMapper;

	@Autowired
	private ItemsImgMapper itemsImgMapper;

	@Autowired
	private ItemsSpecMapper itemsSpecMapper;

	@Autowired
	private ItemsCommentsMapper itemsCommentsMapper;

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

	@Override
	public PageGridResult renderItemCommentByLevelAndItemId(RenderCommentLevelBo bo) {
		PageGridResult pageGridResult = new PageGridResult();
		PageHelper.startPage(bo.getPage(), bo.getPageSize());
		List<CommentRecordVo> vos = itemsCommentsMapper.renderCommentByItemIdAndLevel(bo);
		for (CommentRecordVo commentRecordVo : vos) {
			commentRecordVo.setNickname(DesensitizationUtil.commonDisplay(commentRecordVo.getNickname()));
		}
		pageGridResult.setRows(vos);
		return pageGridResult;
	}

	@Override
	public ItemInfoVo renderItemInfo(String itemId) {
		ItemInfoVo itemInfoVo = new ItemInfoVo();

		Items items = new Items();
		items.setId(itemId);

		ItemsParam itemsParam = new ItemsParam();
		itemsParam.setItemId(itemId);

		ItemsSpec itemsSpec = new ItemsSpec();
		itemsSpec.setItemId(itemId);

		ItemsImg itemsImg = new ItemsImg();
		itemsImg.setItemId(itemId);

		itemInfoVo.setItem(itemsMapper.selectOne(items));
		itemInfoVo.setItemParams(itemsParamMapper.selectOne(itemsParam));
		itemInfoVo.setItemSpecList(itemsSpecMapper.select(itemsSpec));
		itemInfoVo.setItemImgList(itemsImgMapper.select(itemsImg));

		return itemInfoVo;
	}

	@Override
	public CountsVo renderItemsCommentsLevel(String itemId) {
		CountsVo vo = new CountsVo();
		int totalCount = 0;
		List<CountDto> dto = itemsCommentsMapper.queryCommentsLevel(itemId);
		for (CountDto countDto : dto) {

			log.info(ReflectionToStringBuilder.toString(countDto, ToStringStyle.MULTI_LINE_STYLE));

			if (countDto.getCommentLevel() != null && countDto.getCommentLevel() == CommentLevel.GOOD.type) {
				vo.setGoodCounts(countDto.getNumber() + "");
				totalCount += countDto.getNumber();
			} else if (countDto.getCommentLevel() != null && countDto.getCommentLevel() == CommentLevel.MEDIUM.type) {
				vo.setNormalCounts(countDto.getNumber() + "");
				totalCount += countDto.getNumber();
			} else if (countDto.getCommentLevel() != null && countDto.getCommentLevel() == CommentLevel.BAD.type) {
				vo.setBadCounts(countDto.getNumber() + "");
				totalCount += countDto.getNumber();
			}
		}
		vo.setTotalCounts(totalCount + "");
		return vo;
	}

	@Override
	public List<ShopCartItemVo> renderShopCart(String itemSpecIds) {
		String[] ids = StringUtils.splitByWholeSeparatorPreserveAllTokens(itemSpecIds, ",");
		return itemsMapper.queryShopCartItemBySpecIds(ids);
	}

	@Transactional
	@Override
	public int decreaseItemSpecsStock(String itemsSpecId, int decreaseCount) {

		ItemsSpec itemsSpec = new ItemsSpec();
		itemsSpec.setStock(decreaseCount);
		itemsSpec.setId(itemsSpecId);

		return itemsSpecMapper.decreaseStock(itemsSpec);
	}

}
