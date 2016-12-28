package cn.springmvc.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.utils.HttpUtils;

import cn.springmvc.model.feedback.FeedBack;
import cn.springmvc.service.FeedBackService;

/**
 * 
 * @author johnson
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/feedback")
public class FeedBackController {

	@Autowired
	private FeedBackService feedbackService;

	Logger logger = Logger.getLogger(FeedBackController.class);

	/**
	 * insert feedback
	 * 
	 * @param feedback
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public Map<String, Object> feedback(@RequestBody FeedBack feedback) {
		try {
			feedbackService.addFeedBack(feedback);
			return HttpUtils.generateResponse("0", "success", null);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("error occurred in FeedBackController >>>> " + e.getMessage());
			return HttpUtils.generateResponse("-1", "服务器内部错误", null);
		}
	}
}
