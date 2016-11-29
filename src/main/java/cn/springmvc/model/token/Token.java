package cn.springmvc.model.token;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author johnson
 *
 */
public class Token {
	int id;
	int adminId;
	String token;
	String createTime;
	String expiredTime;

	public Token() {
		super();
	}

	public Token(int adminId, String token, int keepDays) {
		this.adminId = adminId;
		this.token = token;
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		this.createTime = df.format(now);
		now.setDate(now.getDate() + keepDays);
		this.expiredTime = df.format(now);
	}

	@Override
	public String toString() {
		return "Token [id=" + id + ", adminId=" + adminId + ", token=" + token + ", createTime=" + createTime
				+ ", expiredTime=" + expiredTime + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getExpiredTime() {
		return expiredTime;
	}

	public void setExpiredTime(String expiredTime) {
		this.expiredTime = expiredTime;
	}

}
