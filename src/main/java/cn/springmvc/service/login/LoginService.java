package cn.springmvc.service.login;

import cn.springmvc.model.admin.Admin;
import cn.springmvc.model.admin.LoginRequest;
import cn.springmvc.model.admin.LoginResponse;

/**
 * 
 * @author johnson
 *
 */
public interface LoginService {

	/**
	 * login
	 * 
	 * @return
	 * @throws Exception
	 */
	public LoginResponse login(LoginRequest loginDat) throws Exception;

	/**
	 * logout
	 * 
	 * @param adminId
	 * @throws Exception
	 */
	public void logOut(int adminId) throws Exception;

	/**
	 * change password
	 * 
	 * @param adminId
	 * @param pwd
	 * @return
	 * @throws Exception
	 */
	public int changePwd(int adminId, String pwd) throws Exception;

	/**
	 * change info
	 * 
	 * @param admin
	 * @return
	 * @throws Exception
	 */
	public int changeInfo(Admin admin) throws Exception;
}
