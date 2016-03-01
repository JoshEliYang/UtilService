package cn.springmvc.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springmvc.model.LastYearTrafficAnalysis;
import cn.springmvc.service.LastYearTrafficAnalysisService;
import cn.springmvc.service.PriceTagService;

import com.alibaba.fastjson.JSON;
import com.springmvc.utils.ExcelUtils;

@Scope("prototype")
@Controller
@RequestMapping("/reportexport")
public class ReportExcelExprotController {

	@Autowired
	private PriceTagService priceTagService;
	
	@Autowired
	private LastYearTrafficAnalysisService lastYearTrafficAnalysisService;

	/**
	 * @author Josh Yang
	 * @description 获得所有价签
	 * @date 2015-12-28
	 * @return JSON
	 */
	@ResponseBody
	@RequestMapping(value = "/last_year_traffic", method = RequestMethod.GET)
	public void exportPriceTagsExcel(HttpServletRequest request, 
			HttpServletResponse response) {

		PrintWriter writer = null;
		List<LastYearTrafficAnalysis> reports = null;
		JSON json = null;
		Map<String, Object> responseMap = null;
		try {
			writer = response.getWriter();
			responseMap = new HashMap<String, Object>();

			reports = lastYearTrafficAnalysisService.selectAllTrafficAnalysisData();
			if (reports == null || reports.isEmpty()) {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/json; charset=utf-8");
				responseMap.put("code", 0);
				responseMap.put("data", null);
				responseMap.put("msg", "无数据");
				json = (JSON) JSON.toJSON(responseMap);
				writer.println(json.toJSONString());
				return;
			}

			ExcelUtils.listToExcel(reports,
					this.getLeadToFiledPublicQuestionBank(), "15年流量分析", response);
		} catch (Exception e) {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			responseMap.put("code", -1);
			responseMap.put("data", null);
			responseMap.put("msg", "服务器内部错误");
			json = (JSON) JSON.toJSON(responseMap);
			writer.println(json.toJSONString());
		}
	}

	public LinkedHashMap<String, String> getLeadToFiledPublicQuestionBank() {
		LinkedHashMap<String, String> superClassMap = new LinkedHashMap<String, String>();
		superClassMap.put("ORDER_CREATE_DATE", "日期");
		superClassMap.put("dayWeek", "星期");
		superClassMap.put("CLIENT_TYPENAME", "订单");
		superClassMap.put("STORE_TYPENAME", "店铺类型");
		superClassMap.put("STORE_NAME", "店铺名称");
		superClassMap.put("ALLORDER", "订单量");
		superClassMap.put("PAYORDER", "支付订单数");
		superClassMap.put("ORDER_PAYMENT_RATE", "支付订单率");

		return superClassMap;
	}
}
