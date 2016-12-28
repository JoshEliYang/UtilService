package cn.springmvc.daoAdmin;

import cn.springmvc.model.feedback.FeedBack;

/**
 * 
 * @author johnson
 *
 */
public interface FeedBackDao {

	/**
	 * insert feedback into DB
	 * 
	 * @param feedback
	 * @throws Exception
	 */
	public void addFeedBack(FeedBack feedback) throws Exception;
}
