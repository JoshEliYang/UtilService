package cn.springmvc.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.utils.HttpUtils;

import cn.springmvc.model.admin.Admin;
import cn.springmvc.model.admin.LoginRequest;
import cn.springmvc.model.admin.LoginResponse;
import cn.springmvc.model.admin.PwdChangeData;
import cn.springmvc.service.login.LoginService;
import cn.springmvc.service.login.TokenService;

/**
 * Administrator controller
 * 
 * @author johnson
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private TokenService tokenService;

	/**
	 * log in
	 * 
	 * @param logDat
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Map<String, Object> login(@RequestBody LoginRequest loginDat, HttpServletResponse res) throws IOException {

		LoginResponse result = null;
		try {
			result = loginService.login(loginDat);
			if (result.isExist()) {
				tokenService.add(result.getId(), result.getToken(), loginDat.getKeepLong());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("-1", "服务器内部错误", null);
		}
		return HttpUtils.generateResponse("0", "success", result);
	}

	/**
	 * verify token
	 * 
	 * @param token
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/{token}", method = RequestMethod.GET)
	public Map<String, Object> tokenVerify(@PathVariable String token, HttpServletResponse res) {
		Admin admin = null;
		try {
			admin = tokenService.verifyToken(token);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("-1", "服务器内部错误", null);
		}
		LoginResponse resAdmin = (admin != null) ? new LoginResponse(true, admin, token)
				: new LoginResponse(false, null, null);
		return HttpUtils.generateResponse("0", "success", resAdmin);
	}

	/**
	 * logout
	 * 
	 * @param adminId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/logout/{adminId}", method = RequestMethod.GET)
	public Map<String, Object> logout(@PathVariable int adminId, HttpServletResponse res) {

		try {
			loginService.logOut(adminId);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("-1", "服务器内部错误", null);
		}
		return HttpUtils.generateResponse("0", "success", null);
	}

	/**
	 * modify administrator information
	 * 
	 * @param admin
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT)
	public Map<String, Object> modify(@RequestBody Admin admin) {
		try {
			loginService.changeInfo(admin);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("-1", "服务器内部错误", null);
		}
		return HttpUtils.generateResponse("0", "success", null);
	}

	/**
	 * change password
	 * 
	 * @param pwdData
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.PATCH)
	public Map<String, Object> changePwd(@RequestBody PwdChangeData pwdData) {
		LoginResponse adminInfo = null;
		try {
			adminInfo = loginService.login(new LoginRequest(pwdData.getUserName(), pwdData.getOrigin()));
			if (adminInfo.isExist()) {
				if (loginService.changePwd(adminInfo.getId(), pwdData.getNewPWD()) == 0) {
					return HttpUtils.generateResponse("-3", "没有修改", null);
				}
			} else {
				return HttpUtils.generateResponse("-2", "原始密码错误", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("-1", "内部服务器错误", null);
		}
		return HttpUtils.generateResponse("0", "success", null);
	}

	/**
	 * add administrator
	 * 
	 * @param admin
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public Map<String, Object> addAdmin(@RequestBody Admin admin) {
		return null;
	}

	/**
	 * get all administrator
	 * 
	 * @return
	 */
	public Map<String, Object> getAll() {
		return null;
	}
}
