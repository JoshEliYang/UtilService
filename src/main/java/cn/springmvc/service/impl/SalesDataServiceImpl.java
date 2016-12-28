package cn.springmvc.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.springmvc.utils.MemcacheUtil;

import cn.springmvc.dao.DailySalesDAO;
import cn.springmvc.model.DailySalesAnalysis;
import cn.springmvc.service.SalesDataService;

@Service
public class SalesDataServiceImpl implements SalesDataService {

	@Autowired
	public DailySalesDAO dao;

	Logger logger = Logger.getLogger(SalesDataServiceImpl.class);

	public List<DailySalesAnalysis> selectSalesData() throws Exception {
		/**
		 * 先从redis中找
		 */
		// RedisUtil redis = RedisUtil.getRedis();
		// String res = redis.getdat("AllSalesData");

		MemcacheUtil memcache = MemcacheUtil.getInstance();
		String res = memcache.getDat("AllSalesData2015", String.class);

		List<DailySalesAnalysis> resList = null;
		if (res != null) {
			// 从redis中取数据
			resList = JSON.parseArray(res, DailySalesAnalysis.class);

			// redis.destroy();
			memcache.destory();
			return resList;
		}
		logger.error("get memcache null (get AllSalesData)");
		return resList;
	}

	@SuppressWarnings("null")
	public List<DailySalesAnalysis> selectAllSalesData2016() throws Exception {
		MemcacheUtil memcache = MemcacheUtil.getInstance();
		int salesDataNum = Integer.parseInt(memcache.getDat("AllSalesData2016_num", String.class));
		int count = 100;
		List<DailySalesAnalysis> resList = null;
		for(int i = 0; salesDataNum > i * count; i ++){
			String resData = memcache.getDat("AllSalesData2016_" + i * count + "_" + count, String.class);
			resList.add((DailySalesAnalysis) JSON.parseArray(resData, DailySalesAnalysis.class));
			
		}
		logger.error("AllSalesData2016" + resList);
//		if (resList != null) {
//			logger.error("Sales Data Num----" + salesDataNum);
//			logger.error("res List----" + resList);
//			return resList;
//		}
		logger.error("get memcache null (get AllSalesData2016)");
		return resList;
	}

}
