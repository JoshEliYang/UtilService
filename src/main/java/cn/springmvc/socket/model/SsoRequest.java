package cn.springmvc.socket.model;

/**
 * 
 * @author johnson
 *
 */
public class SsoRequest {
	String method;
	String ticket;
	String name;
	String pwd;
	String token;
	boolean keepLong;

	@Override
	public String toString() {
		return "SsoRequest [method=" + method + ", ticket=" + ticket + ", name=" + name + ", pwd=" + pwd + ", token="
				+ token + ", keepLong=" + keepLong + "]";
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isKeepLong() {
		return keepLong;
	}

	public void setKeepLong(boolean keepLong) {
		this.keepLong = keepLong;
	}

}
