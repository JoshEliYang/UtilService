package cn.springmvc.service.impl.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.daoAdmin.TokenDao;
import cn.springmvc.model.admin.Admin;
import cn.springmvc.model.token.Token;
import cn.springmvc.service.login.LoginService;
import cn.springmvc.service.login.TokenService;

/**
 * 
 * @author johnson
 *
 */
@Service
public class TokenServiceImpl implements TokenService {

	@Autowired
	private TokenDao tokenDao;
	
	@Autowired
	private LoginService loginService;

	/**
	 * clear expired token
	 */
	public void clearExpired() throws Exception {
		tokenDao.clearExpired();
	}

	/**
	 * add new token
	 */
	public void add(int adminId, String token, boolean isKeepLong) throws Exception {
		clearExpired();
		clean(adminId);
		tokenDao.add(new Token(adminId, token, isKeepLong ? 30 : 1));
	}

	/**
	 * clean by adminId
	 */
	public void clean(int adminId) throws Exception {
		tokenDao.clean(adminId);
	}

	/**
	 * verify token
	 */
	public Admin verifyToken(String token) throws Exception {
		Admin admin = tokenDao.verifyToken(token);
		if (admin == null)
			return null;
		admin.setPwd(null);
		admin.systemsToLevels(loginService.getSys(admin.getId()));
		return admin;
	}

	public void deleteUser(int adminId) throws Exception {
		// TODO Auto-generated method stub
		tokenDao.deleteUserLevel(adminId);
		tokenDao.deleteUser(adminId);
		
	}

}
