package cn.springmvc.service;

import java.util.List;

import cn.springmvc.model.PriceTag;

public interface PriceTagService {
	
	public int insertPriceTag(PriceTag pt) throws Exception;
	
	public List<PriceTag> selectAllPriceTags() throws Exception;
	
	public int deletePriceTag(String id) throws Exception;
	
	public int updatePriceTag(PriceTag pt) throws Exception;
	
	public List<PriceTag> selectPriceTagsByParams(PriceTag pt) throws Exception;
	
	public PriceTag selectPriceTagById(String id) throws Exception;
	
	public List<PriceTag> selectPriceTagsByShopId(String shopId) throws Exception;

}
