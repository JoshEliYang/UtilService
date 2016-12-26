package cn.springmvc.model.admin;

/**
 * 
 * @author zj
 *
 */
public class UserInfoModel {
	String name;

	String realName;

	String pwd;

	int id;

	String role = "user";

	int sysId;

	int flag;

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getSysId() {
		return sysId;
	}

	public void setSysId(int sysId) {
		this.sysId = sysId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UserInfoModel [name=" + name + ", realName=" + realName + ", pwd=" + pwd + ", id=" + id + ", role="
				+ role + ", sysId=" + sysId + ", flag=" + flag + "]";
	}

}
