package cn.springmvc.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.springmvc.utils.MemcacheUtil;

import cn.springmvc.dao.LastYearTrafficAnalysisDAO;
import cn.springmvc.model.LastYearTrafficAnalysis;
import cn.springmvc.model.ThisYearTrafficAnalysis;
import cn.springmvc.service.LastYearTrafficAnalysisService;

@Service
public class LastYearTrafficAnalysisServiceImpl implements LastYearTrafficAnalysisService {
	@Autowired
	public LastYearTrafficAnalysisDAO trafficAnalysisDao;

	Logger logger = Logger.getLogger(LastYearTrafficAnalysisServiceImpl.class);

	public List<ThisYearTrafficAnalysis> selectAllTrafficAnalysisData() throws Exception {
		/**
		 * 先从redis中找
		 */
		// RedisUtil redis = RedisUtil.getRedis();
		// String res = redis.getdat("AllTrafficAnalysisData");

		MemcacheUtil memcache = MemcacheUtil.getInstance();
		String res = memcache.getDat("TrafficAnalysis2015", String.class);

		List<ThisYearTrafficAnalysis> resList = null;
		if (res != null) {
			// 从redis中取数据
			resList = JSON.parseArray(res, ThisYearTrafficAnalysis.class);

			// redis.destroy();
			memcache.destory();
			return resList;
		}
		logger.error("memcache get null (get AllTrafficAnalysisData)");

		/**
		 * redis找不到
		 */
		//resList = trafficAnalysisDao.selectAllTrafficAnalysis();
		//String outStr = JSON.toJSONString(resList);
		// redis.setdat("AllTrafficAnalysisData", outStr);
		//memcache.setDat("TrafficAnalysis2015", outStr);

		// redis.destroy();
		//memcache.destory();
		return resList;
	}

}
