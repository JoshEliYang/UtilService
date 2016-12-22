package cn.springmvc.service.login;

import java.util.List;

import cn.springmvc.model.GSystem;
import cn.springmvc.model.admin.Admin;
import cn.springmvc.model.admin.LoginRequest;
import cn.springmvc.model.admin.LoginResponse;
import cn.springmvc.model.admin.PermissionsModel;
import cn.springmvc.model.admin.UserInfoModel;

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
	 * get system list
	 * 
	 * @param adminId
	 * @return
	 * @throws Exception
	 */
	public List<GSystem> getSys(int adminId) throws Exception;

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

	public List<PermissionsModel> permissionsContent() throws Exception;

	public void deleteUser(int adminId) throws Exception;

	public void addUser(UserInfoModel rp) throws Exception;

	public void modefiedPWD(UserInfoModel rp) throws Exception;

	public void modefiedInfo(UserInfoModel rp) throws Exception;

	public void modefiedRole(UserInfoModel rp) throws Exception;

	public void modefiedPermissions(UserInfoModel rp) throws Exception;
}
