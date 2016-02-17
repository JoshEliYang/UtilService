package cn.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.PriceTagDAO;
import cn.springmvc.model.PriceTag;
import cn.springmvc.service.PriceTagService;

@Service
public class PriceTagServiceImpl implements PriceTagService {
	
	@Autowired
	private PriceTagDAO priceTagDao;

	public List<PriceTag> selectPriceTagsByShopId(String shopId)
			throws Exception {
		return priceTagDao.selectPriceTagsByShopId(shopId);
	}

	public List<PriceTag> selectAllDeletePriceTags() throws Exception {
		return priceTagDao.selectAllDeletedPriceTags();
	}

}
