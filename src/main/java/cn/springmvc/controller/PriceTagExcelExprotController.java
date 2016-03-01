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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springmvc.model.PriceTag;
import cn.springmvc.service.PriceTagService;

import com.alibaba.fastjson.JSON;
import com.springmvc.utils.ExcelUtils;

@Scope("prototype")
@Controller
@RequestMapping("/excelexport")
public class PriceTagExcelExprotController {

	@Autowired
	private PriceTagService priceTagService;

	/**
	 * @author Josh Yang
	 * @description 获得所有价签
	 * @date 2015-12-28
	 * @return JSON
	 */
	@ResponseBody
	@RequestMapping(value = "/pricetag/{shopId}", method = RequestMethod.GET)
	public void exportPriceTagsExcel(@PathVariable String shopId,
			HttpServletRequest request, HttpServletResponse response) {

		PrintWriter writer = null;
		List<PriceTag> tags = null;
		JSON json = null;
		Map<String, Object> responseMap = null;
		try {
			writer = response.getWriter();
			responseMap = new HashMap<String, Object>();

			tags = priceTagService.selectPriceTagsByShopId(shopId);
			if (tags == null || tags.isEmpty()) {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/json; charset=utf-8");
				responseMap.put("code", 0);
				responseMap.put("data", null);
				responseMap.put("msg", "无数据");
				json = (JSON) JSON.toJSON(responseMap);
				writer.println(json.toJSONString());
				return;
			}

			ExcelUtils.listToExcel(tags,
					this.getLeadToFiledPublicQuestionBank(), shopId, response);
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
	 * @description 获得所有价签
	 * @date 2015-12-28
	 * @return JSON
	 */
	@ResponseBody
	@RequestMapping(value = "/pricetag/deleted", method = RequestMethod.GET)
	public void exportDeletedPriceTagsExcel(HttpServletRequest request,
			HttpServletResponse response) {

		PrintWriter writer = null;
		List<PriceTag> tags = null;
		JSON json = null;
		Map<String, Object> responseMap = null;
		try {
			writer = response.getWriter();
			responseMap = new HashMap<String, Object>();

			tags = priceTagService.selectAllDeletePriceTags();
			if (tags == null || tags.isEmpty()) {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/json; charset=utf-8");
				responseMap.put("code", 0);
				responseMap.put("data", null);
				responseMap.put("msg", "无数据");
				json = (JSON) JSON.toJSON(responseMap);
				writer.println(json.toJSONString());
				return;
			}

			ExcelUtils.listToExcel(tags,
					this.getLeadToFiledPublicQuestionBank(), "已删除价签", response);
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
		superClassMap.put("id", "id");
		superClassMap.put("type", "显示类型");
		superClassMap.put("shopId", "店铺id");
		superClassMap.put("goodsNo", "商品编码");
		superClassMap.put("goodsName", "商品名");
		superClassMap.put("unit", "单位");
		superClassMap.put("specifications", "规格");
		superClassMap.put("goodsOrigin", "产地");
		superClassMap.put("salesPrice", "售价");
		superClassMap.put("propmPrice", "促销价");
		superClassMap.put("marketPrice", "市场价");
		superClassMap.put("qrCode", "二维码");
		superClassMap.put("visible", "显示");

		return superClassMap;
	}
}
