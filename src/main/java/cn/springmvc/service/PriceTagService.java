package cn.springmvc.service;

import java.util.List;

import cn.springmvc.model.PriceTag;

public interface PriceTagService {
	
	public List<PriceTag> selectPriceTagsByShopId(String shopId) throws Exception;

	// 查询所有已删除价签
	public List<PriceTag> selectAllDeletePriceTags() throws Exception;
	
}
