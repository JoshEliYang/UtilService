package cn.springmvc.service;

import java.util.List;

import cn.springmvc.model.DailySalesAnalysis;

public interface SalesDataService {

	// 列出15年值钱的销售数据
	public List<DailySalesAnalysis> selectSalesData() throws Exception;
	
	// 列出16年值钱的销售数据
	public List<DailySalesAnalysis> selectAllSalesData2016() throws Exception;
}
