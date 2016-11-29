package cn.springmvc.service.login;

import cn.springmvc.model.admin.Admin;

/**
 * 
 * @author johnson
 *
 */
public interface TokenService {

	/**
	 * clear expired tokens
	 * 
	 * @throws Exception
	 */
	public void clearExpired() throws Exception;

	/**
	 * add a new token
	 * 
	 * @param token
	 * @throws Exception
	 */
	public void add(int adminId, String token, boolean isKeepLong) throws Exception;

	/**
	 * clean token by adminId
	 * 
	 * @param adminId
	 * @throws Exception
	 */
	public void clean(int adminId) throws Exception;

	/**
	 * verify token
	 * 
	 * @param token
	 * @return administrator
	 * @throws Exception
	 */
	public Admin verifyToken(String token) throws Exception;

}
