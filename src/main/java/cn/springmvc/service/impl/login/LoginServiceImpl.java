package cn.springmvc.service.impl.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.utils.MD5Util;

import cn.springmvc.daoAdmin.LoginDao;
import cn.springmvc.model.GSystem;
import cn.springmvc.model.admin.Admin;
import cn.springmvc.model.admin.LoginRequest;
import cn.springmvc.model.admin.LoginResponse;
import cn.springmvc.model.admin.PermissionsModel;
import cn.springmvc.model.admin.UserInfoModel;
import cn.springmvc.service.login.LoginService;
import cn.springmvc.service.login.TokenService;

/**
 * 
 * @author johnson
 *
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;

	@Autowired
	private TokenService tokenService;

	/**
	 * get all users in specific system
	 */
	public List<Admin> getAllinSys(String sysName) throws Exception {
		List<Admin> adminList = loginDao.getAllinSys(sysName);
		Admin admin = null;
		for (int i = 0; i < adminList.size(); i++) {
			admin = adminList.get(i);
			admin.setPwd(null);
			admin.systemsToLevels(getSys(admin.getId()));
		}
		return adminList;
	}

	/**
	 * login
	 */
	public LoginResponse login(LoginRequest loginDat) throws Exception {
		String timeStemp = null;
		Admin admin = null;
		boolean isExist = false;

		List<Admin> admins = loginDao.userVerify(loginDat.getUserName(), loginDat.getPwd());
		if (admins.size() > 0) {
			admin = admins.get(0);
			admin.setPwd(null);
			isExist = true;
			timeStemp = MD5Util.string2MD5(String.valueOf(System.currentTimeMillis()));
			admin.systemsToLevels(getSys(admin.getId()));
		}
		return new LoginResponse(isExist, admin, timeStemp);
	}

	/**
	 * get system list
	 */
	public List<GSystem> getSys(int adminId) throws Exception {
		return loginDao.getSys(adminId);
	}

	/**
	 * logout
	 */
	public void logOut(int adminId) throws Exception {
		tokenService.clean(adminId);
	}

	/**
	 * change password
	 */
	public int changePwd(int adminId, String pwd) throws Exception {
		return loginDao.changePwd(adminId, pwd);
	}

	/**
	 * change info
	 */
	public int changeInfo(Admin admin) throws Exception {
		return loginDao.changeInfo(admin);
	}

	public List<PermissionsModel> permissionsContent() throws Exception {
		List<PermissionsModel> per = loginDao.permissionsContent();
		for (int i = 0; i < per.size(); i++) {
			List<Integer> sysIds = loginDao.getsysIds(per.get(i).getId());
			per.get(i).setSysId(sysIds);
		}

		return per;
	}

	public void deleteUser(int adminId) throws Exception {
		tokenService.deleteUser(adminId);

	}

	public void addUser(UserInfoModel rp) throws Exception {
		loginDao.addUser(rp);

	}

	public void modefiedPWD(UserInfoModel rp) throws Exception {
		loginDao.modefiedPWD(rp);

	}

	public void modefiedInfo(UserInfoModel rp) throws Exception {
		loginDao.modefiedInfo(rp);

	}

	public void modefiedRole(UserInfoModel rp) throws Exception {
		loginDao.modefiedRole(rp);

	}

	public void modefiedPermissions(UserInfoModel rp) throws Exception {
		if (rp.getFlag() == 0) {
			loginDao.modefiedPermissionsRemove(rp);
		} else {
			loginDao.modefiedPermissionsAdd(rp);
		}

	}

}
