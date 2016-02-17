package cn.springmvc.dao;

import java.util.List;

import cn.springmvc.model.PriceTag;

public interface PriceTagDAO {
	
	public List<PriceTag> selectPriceTagsByShopId(String shopId);
}
