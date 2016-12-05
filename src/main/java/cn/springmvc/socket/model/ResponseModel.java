package cn.springmvc.socket.model;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author johnson
 *
 */
public class ResponseModel {
	String code;
	String ticket;
	String msg;
	Object obj;

	public ResponseModel() {
		super();
	}

	public ResponseModel(String code, String ticket, String msg, Object obj) {
		this.code = code;
		this.ticket = ticket;
		this.msg = msg;
		this.obj = obj;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

}
