package cn.springmvc.model.admin;

/**
 * 
 * @author johnson
 *
 */
public class LoginRequest {
	String userName;
	String pwd;
	Boolean keepLong;

	public LoginRequest() {
		super();
	}

	public LoginRequest(String userName, String pwd) {
		this.userName = userName;
		this.pwd = pwd;
	}

	public LoginRequest(String userName, String pwd, boolean keepLong) {
		this(userName, pwd);
		this.keepLong = keepLong;
	}

	@Override
	public String toString() {
		return "LoginData [userName=" + userName + ", pwd=" + pwd + ", keepLong=" + keepLong + "]";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Boolean getKeepLong() {
		return keepLong;
	}

	public void setKeepLong(Boolean keepLong) {
		this.keepLong = keepLong;
	}

}
