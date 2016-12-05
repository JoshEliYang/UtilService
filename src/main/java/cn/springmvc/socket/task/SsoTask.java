package cn.springmvc.socket.task;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.springmvc.utils.MemcacheUtil;

import cn.springmvc.model.admin.Admin;
import cn.springmvc.model.admin.LoginRequest;
import cn.springmvc.model.admin.LoginResponse;
import cn.springmvc.service.impl.login.LoginServiceImpl;
import cn.springmvc.service.impl.login.TokenServiceImpl;
import cn.springmvc.service.login.LoginService;
import cn.springmvc.service.login.TokenService;
import cn.springmvc.socket.SsoSocket;
import cn.springmvc.socket.model.ResponseModel;
import cn.springmvc.socket.model.SsoRequest;

/**
 * 
 * @author johnson
 *
 */
public class SsoTask {

	private LoginService loginService;

	private TokenService tokenService;

	public SsoTask() {
		super();
		ApplicationContext ac = new ClassPathXmlApplicationContext("conf/spring-mvc.xml");
		AutowireCapableBeanFactory factory = ac.getAutowireCapableBeanFactory();
		loginService = factory.createBean(LoginServiceImpl.class);
		tokenService = factory.createBean(TokenServiceImpl.class);
	}

	public static SsoTask getInstance() {
		return new SsoTask();
	}

	/**
	 * handle message
	 * 
	 * @param message
	 * @throws IOException
	 */
	public void handleMessage(String message) throws IOException {
		SsoRequest model = JSON.parseObject(message, SsoRequest.class);

		if ("request".equalsIgnoreCase(model.getMethod())) {
			setTimestamp(model.getTicket());
		} else if ("validate".equalsIgnoreCase(model.getMethod())) {
			/*
			 * valid userName and password
			 */
			if (getTimestamp(model.getTicket()) != null) {
				try {
					LoginResponse result = loginService.login(new LoginRequest(model.getName(), model.getPwd(), true));
					if (result.isExist()) {
						tokenService.add(result.getId(), result.getToken(), model.isKeepLong());
					}
					SsoSocket.broadcast((new ResponseModel("0", model.getTicket(), "success", result)).toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				SsoSocket.broadcast((new ResponseModel("-1", model.getTicket(), "登录信息丢失", null)).toString());
			}
		} else if ("validateToken".equalsIgnoreCase(model.getMethod())) {
			/*
			 * valid token
			 */
			System.out.println(model.toString());
			Admin admin = null;
			try {
				admin = tokenService.verifyToken(model.getToken());
			} catch (Exception e) {
				e.printStackTrace();
			}
			LoginResponse result = (admin != null) ? new LoginResponse(true, admin, model.getToken())
					: new LoginResponse(false, null, null);
			SsoSocket.broadcast((new ResponseModel("0", model.getTicket(), "success", result)).toString());
		}
	}

	/**
	 * set time-stamp into cache
	 * 
	 * @param timestamp
	 * @throws IOException
	 */
	private void setTimestamp(String timestamp) throws IOException {
		MemcacheUtil memcache = MemcacheUtil.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		memcache.setDat(timestamp, df.format(new Date()));
	}

	/**
	 * get time-stamp from cache
	 * 
	 * @param timestamp
	 * @return
	 * @throws IOException
	 */
	private String getTimestamp(String timestamp) throws IOException {
		MemcacheUtil memcache = MemcacheUtil.getInstance();
		return memcache.getDat(timestamp, String.class);
	}

}
