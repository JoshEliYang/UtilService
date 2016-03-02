package cn.springmvc.dao;

import java.util.List;

import cn.springmvc.model.SaleTopAnalysis;

public interface SaleTopAnalysisDAO {

	// 列出15年销售Top数据
	public List<SaleTopAnalysis> selectAllSaleTopData();
}
