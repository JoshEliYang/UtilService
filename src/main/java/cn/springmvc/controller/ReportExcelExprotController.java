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

import cn.springmvc.model.DailySalesAnalysis;
import cn.springmvc.model.LastYearTrafficAnalysis;
import cn.springmvc.model.SaleTopAnalysis;
import cn.springmvc.model.ThisYearTrafficAnalysis;
import cn.springmvc.service.LastYearTrafficAnalysisService;
import cn.springmvc.service.SaleTopAnalysisService;
import cn.springmvc.service.SalesDataService;
import cn.springmvc.service.ThisYearTrafficAnalysisService;

import com.alibaba.fastjson.JSON;
import com.springmvc.utils.ExcelUtils;

@Scope("prototype")
@Controller
@RequestMapping("/reportexport")
public class ReportExcelExprotController {

	@Autowired
	private LastYearTrafficAnalysisService lastYearTrafficAnalysisService;
	
	@Autowired
	private ThisYearTrafficAnalysisService thisYearTrafficAnalysisService;

	@Autowired
	public SalesDataService salesDataService;
	
	@Autowired
	public SaleTopAnalysisService saleTopAnalysisService;
	
	/**
	 * @author Josh Yang
	 * @description 所有去年流量
	 * @date 2016-3-1
	 * @return JSON
	 */
	@ResponseBody
	@RequestMapping(value = "/last_year_traffic", method = RequestMethod.GET)
	public void exportLastYearTrafficReportExcel(HttpServletRequest request, 
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
	
	/**
	 * @author Josh Yang
	 * @description 所有今年流量
	 * @date 2016-3-1
	 * @return JSON
	 */
	@ResponseBody
	@RequestMapping(value = "/this_year_traffic", method = RequestMethod.GET)
	public void exportThisYearTrafficReportExcel(HttpServletRequest request, 
			HttpServletResponse response) {

		PrintWriter writer = null;
		List<ThisYearTrafficAnalysis> reports = null;
		JSON json = null;
		Map<String, Object> responseMap = null;
		try {
			writer = response.getWriter();
			responseMap = new HashMap<String, Object>();

			reports = thisYearTrafficAnalysisService.selectAllTrafficAnalysisData();
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
					this.getLeadToFiledPublicQuestionBank(), "16年流量分析", response);
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
	
	/**
	 * @author Josh Yang
	 * @description 15年销售分析
	 * @date 2016-3-1
	 * @return JSON
	 */
	@ResponseBody
	@RequestMapping(value = "/sales", method = RequestMethod.GET)
	public void exportAllSalesDataExcel(HttpServletRequest request, 
			HttpServletResponse response) {

		PrintWriter writer = null;
		List<DailySalesAnalysis> reports = null;
		JSON json = null;
		Map<String, Object> responseMap = null;
		try {
			writer = response.getWriter();
			responseMap = new HashMap<String, Object>();

			reports = salesDataService.selectSalesData();
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
					this.getLeadToFiledPublicQuestionBankSales(), "15销售日常分析", response);
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
	
	/**
	 * @author Josh Yang
	 * @description 15年销售分析
	 * @date 2016-3-1
	 * @return JSON
	 */
	@ResponseBody
	@RequestMapping(value = "/top", method = RequestMethod.GET)
	public void exportAllSalesTopDataExcel(HttpServletRequest request, 
			HttpServletResponse response) {

		PrintWriter writer = null;
		List<SaleTopAnalysis> reports = null;
		JSON json = null;
		Map<String, Object> responseMap = null;
		try {
			writer = response.getWriter();
			responseMap = new HashMap<String, Object>();

			reports = saleTopAnalysisService.selectAllSaleTopData();
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
					this.getLeadToFiledPublicQuestionBankSales(), "15销售TOP分析", response);
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

	private LinkedHashMap<String, String> getLeadToFiledPublicQuestionBank() {
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

	private LinkedHashMap<String, String> getLeadToFiledPublicQuestionBankSales() {
		LinkedHashMap<String, String> superClassMap = new LinkedHashMap<String, String>();
		superClassMap.put("order_CREATE_DATE", "日期");
		superClassMap.put("dayWeek", "星期");
		superClassMap.put("client_TYPENAME", "订单");
		superClassMap.put("store_TYPENAME", "店铺类型");
		superClassMap.put("store_NAME", "店铺名称");
		superClassMap.put("order_NUMBER", "订单数");
		superClassMap.put("order_PRICE", "客单价");
		superClassMap.put("orderamount", "订单金额");
		superClassMap.put("allyh", "优惠金额");
		superClassMap.put("payment_AMOUNT", "支付金额");
		
		return superClassMap;
	}
	
//    "client_TYPENAME": "微站",
//    "order_CREATE_DATE": "2015年",
//    "store_TYPENAME": "直营店",
//    "store_NAME": "绿地自营",
//    "cargo_NAME": "蓝雪加拿大龙虾（生）500-600g*2 ",
//    "payamount": "450.00",
//    "saleCount": "3",
//    "saleamount": "450.00",
//    "totalRate": "5.40",
//    "jinbuCount": "100%",
//    "goods_class_name": "海鲜水产",
//    "purchaseAmount": "444.60",
//    "ratePercent": "1.20%",
//    "jinbuAmount": "100%"
	private LinkedHashMap<String, String> getLeadToFiledPublicQuestionBankTop() {
		LinkedHashMap<String, String> superClassMap = new LinkedHashMap<String, String>();
		superClassMap.put("order_CREATE_DATE", "日期");
		superClassMap.put("dayWeek", "星期");
		superClassMap.put("client_TYPENAME", "订单");
		superClassMap.put("store_TYPENAME", "店铺类型");
		superClassMap.put("store_NAME", "店铺名称");
		superClassMap.put("order_NUMBER", "订单数");
		superClassMap.put("order_PRICE", "客单价");
		superClassMap.put("orderamount", "订单金额");
		superClassMap.put("allyh", "优惠金额");
		superClassMap.put("payment_AMOUNT", "支付金额");
		
		return superClassMap;
	}
}
