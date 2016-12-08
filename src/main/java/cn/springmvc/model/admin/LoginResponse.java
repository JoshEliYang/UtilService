package cn.springmvc.model.admin;

/**
 * 
 * @author johnson
 *
 */
public class LoginResponse extends Admin {

	boolean isExist;
	String token;

	public LoginResponse() {
		super();
	}

	public LoginResponse(boolean isExist, Admin admin, String token) {
		if (admin != null) {
			this.setId(admin.getId());
			this.setName(admin.getName());
			this.setRealName(admin.getRealName());
			this.setPwd(admin.getPwd());
			this.setLevels(admin.getLevels());
		}
		this.setExist(isExist);
		this.setToken(token);
	}

	@Override
	public String toString() {
		return "LoginResponse [isExist=" + isExist + ", token=" + token + ", id=" + id + ", name=" + name
				+ ", realName=" + realName + ", pwd=" + pwd + ", levels=" + levels + "]";
	}

	public boolean isExist() {
		return isExist;
	}

	public void setExist(boolean isExist) {
		this.isExist = isExist;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
