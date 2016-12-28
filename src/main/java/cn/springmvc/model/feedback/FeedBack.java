package cn.springmvc.model.feedback;

/**
 * 
 * @author johnson
 *
 */
public class FeedBack {
	int id;
	int userId;
	String topic;
	String contant;
	String date;
	String name;
	String realName;

	@Override
	public String toString() {
		return "FeedBack [id=" + id + ", userId=" + userId + ", topic=" + topic + ", contant=" + contant + ", date="
				+ date + ", name=" + name + ", realName=" + realName + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getContant() {
		return contant;
	}

	public void setContant(String contant) {
		this.contant = contant;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

}
