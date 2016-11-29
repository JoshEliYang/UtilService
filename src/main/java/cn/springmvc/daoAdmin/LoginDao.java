package cn.springmvc.daoAdmin;

import java.util.List;

import cn.springmvc.model.admin.Admin;

/**
 * 
 * @author johnson
 *
 */
public interface LoginDao {

	/**
	 * user verify
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Admin> userVerify(String userName, String pwd) throws Exception;

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
