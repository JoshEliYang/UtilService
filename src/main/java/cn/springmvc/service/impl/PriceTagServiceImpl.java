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

	public int insertPriceTag(PriceTag pt) throws Exception{
		try{
			priceTagDao.insertPriceTag(pt);
		} catch (Exception ex) {
			ex.printStackTrace();
			return -1;
		}
		return 0;
	}

	public List<PriceTag> selectAllPriceTags() throws Exception{
		return priceTagDao.selectAllPriceTags();
	}

	public int deletePriceTag(String id) throws Exception{
		try {
			PriceTag pt = priceTagDao.selectPriceTagsById(id);
			if (pt == null) {
				return -1;
			}
			priceTagDao.deletePriceTag(id);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return 0;
	}

	public int updatePriceTag(PriceTag pt) throws Exception{
		try {
			int id = pt.getId();
			PriceTag priceTag = priceTagDao.selectPriceTagsById(String.valueOf(id));
			if (priceTag == null) {
				return -1;
			}
			
			priceTagDao.updatePriceTag(pt);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		
		return 0;
	}

	public List<PriceTag> selectPriceTagsByParams(PriceTag pt) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	public PriceTag selectPriceTagById(String id) throws Exception {
		return priceTagDao.selectPriceTagsById(id);
	}

	public List<PriceTag> selectPriceTagsByShopId(String shopId)
			throws Exception {
		return priceTagDao.selectPriceTagsByShopId(shopId);
	}

}
