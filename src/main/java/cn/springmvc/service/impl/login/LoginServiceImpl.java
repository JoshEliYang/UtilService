package cn.springmvc.service.impl.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.utils.MD5Util;

import cn.springmvc.daoAdmin.LoginDao;
import cn.springmvc.model.admin.Admin;
import cn.springmvc.model.admin.LoginRequest;
import cn.springmvc.model.admin.LoginResponse;
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
		}
		return new LoginResponse(isExist, admin, timeStemp);
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

}
