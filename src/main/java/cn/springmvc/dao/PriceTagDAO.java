package cn.springmvc.dao;

import java.util.List;

import cn.springmvc.model.PriceTag;

public interface PriceTagDAO {

	public int insertPriceTag(PriceTag pt);
	
	public List<PriceTag> selectAllPriceTags();
	
	public int deletePriceTag(String id);
	
	public int updatePriceTag(PriceTag pt);
	
	public List<PriceTag> selectPriceTagsByParams(PriceTag pt);
	
	public PriceTag selectPriceTagsById(String id);
	
	public List<PriceTag> selectPriceTagsByShopId(String shopId);
}
