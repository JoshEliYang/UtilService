package cn.springmvc.model.admin;

/**
 * 
 * @author johnson
 *
 */
public class PwdChangeData {
	String userName;
	String origin;
	String newPWD;

	@Override
	public String toString() {
		return "PwdChangeData [userName=" + userName + ", origin=" + origin + ", newPWD=" + newPWD + "]";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getNewPWD() {
		return newPWD;
	}

	public void setNewPWD(String newPWD) {
		this.newPWD = newPWD;
	}

}
