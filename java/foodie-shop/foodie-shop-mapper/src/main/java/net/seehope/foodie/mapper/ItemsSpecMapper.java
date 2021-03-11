package net.seehope.foodie.mapper;

import net.seehope.foodie.pojo.ItemsSpec;

/**
 * 通用 Mapper 代码生成器
 *
 * @author mapper-generator
 */
public interface ItemsSpecMapper extends tk.mybatis.mapper.common.Mapper<ItemsSpec> {
	/**
	 * 乐观锁扣除库存，只有库存大于购买数时允许扣除库存
	 * 
	 * @param itemsSpecId
	 * @param count
	 */
	int decreaseStock(ItemsSpec itemsSpec);
}
