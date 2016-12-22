package cn.springmvc.model.admin;

import java.util.List;

/**
 * 
 * @author zj
 *
 */
public class PermissionsModel {
	int id;
	
	String name;
	
	String realName;
	
	String role;
	
	List<Integer> sysId;

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}



	public List<Integer> getSysId() {
		return sysId;
	}

	public void setSysId(List<Integer> sysId) {
		this.sysId = sysId;
	}

	

	@Override
	public String toString() {
		return "PermissionsModel [id=" + id + ", name=" + name + ", realName="
				+ realName + ", role=" + role + ", sysId=" + sysId + "]";
	}

}
