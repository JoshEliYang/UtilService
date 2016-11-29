package cn.springmvc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.utils.HttpUtils;

import cn.springmvc.model.admin.Admin;
import cn.springmvc.model.sso.GenerateRequest;
import cn.springmvc.model.sso.Ticket;
import cn.springmvc.service.login.TokenService;
import cn.springmvc.service.sso.SsoService;

/**
 * 
 * @author johnson
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/sso")
public class SsoController {

	@Autowired
	private TokenService tokenService;

	@Autowired
	private SsoService ssoService;

	/**
	 * generate ticket
	 * 
	 * @param reqDat
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/generate", method = RequestMethod.POST)
	public Map<String, Object> generateTicket(@RequestBody GenerateRequest reqDat) {
		Ticket ticket = null;
		try {
			Admin admin = tokenService.verifyToken(reqDat.getToken());
			if (admin == null) {
				return HttpUtils.generateResponse("101", "尚未登录或登录超时", null);
			}
			ticket = ssoService.storeTicket(reqDat.getTarget());
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("-1", "服务器内部错误", null);
		}
		return HttpUtils.generateResponse("0", "success", ticket.getTicket());
	}

	/**
	 * verify ticket
	 * 
	 * @param ticket
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/verify",method = RequestMethod.POST)
	public Map<String, Object> verifyTicket(@RequestBody Ticket ticket) {
		Ticket newTicket = null;
		try {
			boolean isValid = ssoService.verifyTicket(ticket);
			if (!isValid) {
				return HttpUtils.generateResponse("101", "尚未登录或登录超时", null);
			}
			newTicket = ssoService.storeTicket(ticket.getTarget());
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("-1", "服务器内部错误", null);
		}
		return HttpUtils.generateResponse("0", "success", newTicket.getTicket());
	}
}
