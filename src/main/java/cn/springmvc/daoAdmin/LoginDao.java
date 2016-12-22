package cn.springmvc.daoAdmin;

import java.util.List;

import cn.springmvc.model.GSystem;
import cn.springmvc.model.admin.Admin;
import cn.springmvc.model.admin.PermissionsModel;
import cn.springmvc.model.admin.UserInfoModel;

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
	 * get systems by administrator's id
	 * 
	 * @param adminId
	 * @return
	 * @throws Exception
	 */
	public List<GSystem> getSys(int adminId) throws Exception;

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

	/**
	 * 
	 * 
	 * @param admin
	 * @return
	 * @throws Exception
	 */
	public List<PermissionsModel> permissionsContent() throws Exception;

	public List<Integer> getsysIds(int id);

	public void addUser(UserInfoModel rp);

	public void modefiedPWD(UserInfoModel rp);

	public void modefiedInfo(UserInfoModel rp);

	public void modefiedRole(UserInfoModel rp);

	public void modefiedPermissionsAdd(UserInfoModel rp);

	public void modefiedPermissionsRemove(UserInfoModel rp);

	//public int[] getSysId(int id);
}
