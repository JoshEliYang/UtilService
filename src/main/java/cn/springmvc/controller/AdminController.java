package cn.springmvc.controller;

import java.io.IOException;
import java.util.List;
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

import cn.springmvc.model.PriceTag;
import cn.springmvc.model.admin.Admin;
import cn.springmvc.model.admin.LoginRequest;
import cn.springmvc.model.admin.LoginResponse;
import cn.springmvc.model.admin.PermissionsModel;
import cn.springmvc.model.admin.PwdChangeData;
import cn.springmvc.model.admin.UserInfoModel;
import cn.springmvc.service.login.LoginService;
import cn.springmvc.service.login.TokenService;
import jxl.common.Logger;

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

	Logger logger = Logger.getLogger(AdminController.class);

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
	@ResponseBody
	@RequestMapping(value = "/getall/{sysName}", method = RequestMethod.GET)
	public Map<String, Object> getAllinSys(@PathVariable String sysName) {
		List<Admin> adminList = null;
		try {
			adminList = loginService.getAllinSys(sysName);
			return HttpUtils.generateResponse("0", "success", adminList);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("-1", "内部服务器错误", null);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/permissionsContent", method = RequestMethod.GET)
	public Map<String, Object> permissionsContent() {

		List<PermissionsModel> per;

		try {
			per = loginService.permissionsContent();
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("-1", "服务器内部错误", null);
		}
		return HttpUtils.generateResponse("0", "success", per);
	}

	/**
	 * deleteUser
	 * 
	 * @param adminId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteUser/{adminId}", method = RequestMethod.GET)
	public Map<String, Object> deleteUser(@PathVariable int adminId, HttpServletResponse res) {

		try {
			loginService.deleteUser(adminId);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("-1", "服务器内部错误", null);
		}
		return HttpUtils.generateResponse("0", "success", null);
	}

	@ResponseBody
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public Map<String, Object> addUser(@RequestBody UserInfoModel rp) {
		try {
			loginService.addUser(rp);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "请求失败", null);
		}

		return HttpUtils.generateResponse("0", "添加成功", null);
	}

	@ResponseBody
	@RequestMapping(value = "/modefiedPWD", method = RequestMethod.POST)
	public Map<String, Object> modefiedPWD(@RequestBody UserInfoModel rp) {
		try {
			loginService.modefiedPWD(rp);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "请求失败", null);
		}

		return HttpUtils.generateResponse("0", "修改成功", null);
	}

	@ResponseBody
	@RequestMapping(value = "/modefiedInfo", method = RequestMethod.POST)
	public Map<String, Object> modefiedInfo(@RequestBody UserInfoModel rp) {
		try {
			loginService.modefiedInfo(rp);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "请求失败", null);
		}

		return HttpUtils.generateResponse("0", "修改成功", null);
	}

	@ResponseBody
	@RequestMapping(value = "/modefiedRole", method = RequestMethod.POST)
	public Map<String, Object> modefiedRole(@RequestBody UserInfoModel rp) {
		try {
			loginService.modefiedRole(rp);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "请求失败", null);
		}

		return HttpUtils.generateResponse("0", "修改成功", null);
	}

	@ResponseBody
	@RequestMapping(value = "/modefiedPermissions", method = RequestMethod.POST)
	public Map<String, Object> modefiedPermissions(@RequestBody UserInfoModel rp) {
		try {
			loginService.modefiedPermissions(rp);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "请求失败", null);
		}

		return HttpUtils.generateResponse("0", "修改成功", null);
	}

}
