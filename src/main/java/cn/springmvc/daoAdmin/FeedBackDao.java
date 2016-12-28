package cn.springmvc.daoAdmin;

import java.util.List;

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

	public List<FeedBack> getfeedback() throws Exception;

	public void deletefeedback(FeedBack feedback) throws Exception;

	public void deletefeedbackAll() throws Exception;
}
