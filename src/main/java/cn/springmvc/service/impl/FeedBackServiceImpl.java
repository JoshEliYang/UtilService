package cn.springmvc.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.daoAdmin.FeedBackDao;
import cn.springmvc.model.feedback.FeedBack;
import cn.springmvc.service.FeedBackService;

/**
 * 
 * @author johnson
 *
 */
@Service
public class FeedBackServiceImpl implements FeedBackService {
	@Autowired
	private FeedBackDao feedbackDao;

	/**
	 * insert feedback into DB
	 */
	public void addFeedBack(FeedBack feedback) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		feedback.setDate(df.format(new Date()));
		feedbackDao.addFeedBack(feedback);
	}

}
