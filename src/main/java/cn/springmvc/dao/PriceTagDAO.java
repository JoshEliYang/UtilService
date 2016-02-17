package cn.springmvc.dao;

import java.util.List;

import cn.springmvc.model.PriceTag;

public interface PriceTagDAO {
	
	public List<PriceTag> selectPriceTagsByShopId(String shopId);
	
	// 获得所有已删除价签
	public List<PriceTag> selectAllDeletedPriceTags();
}
