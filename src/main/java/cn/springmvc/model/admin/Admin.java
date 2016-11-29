package cn.springmvc.model.admin;

/**
 * 
 * @author johnson
 *
 */
public class Admin {
	int id;
	String name;
	String realName;
	String pwd;

	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", realName=" + realName + ", pwd=" + pwd + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}
