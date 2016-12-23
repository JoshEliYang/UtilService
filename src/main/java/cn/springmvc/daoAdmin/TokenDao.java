package cn.springmvc.daoAdmin;

import cn.springmvc.model.admin.Admin;
import cn.springmvc.model.token.Token;

/**
 * 
 * @author johnson
 *
 */
public interface TokenDao {

	/**
	 * clear expired token
	 * 
	 * @throws Exception
	 */
	public void clearExpired() throws Exception;

	/**
	 * add token
	 * 
	 * @param token
	 * @throws Exception
	 */
	public void add(Token token) throws Exception;

	/**
	 * clear token by amdinId
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

	public void deleteUser(int adminId) throws Exception;

	public void deleteUserLevel(int adminId);
}
