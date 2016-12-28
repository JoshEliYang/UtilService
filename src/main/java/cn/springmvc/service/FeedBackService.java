package cn.springmvc.service;

import cn.springmvc.model.feedback.FeedBack;

/**
 * 
 * @author johnson
 *
 */
public interface FeedBackService {

	/**
	 * insert feedback into DB
	 * 
	 * @param feedback
	 * @throws Exception
	 */
	public void addFeedBack(FeedBack feedback) throws Exception;
}
