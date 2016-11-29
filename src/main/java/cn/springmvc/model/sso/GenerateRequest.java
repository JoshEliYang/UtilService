package cn.springmvc.model.sso;

/**
 * 
 * @author johnson
 *
 */
public class GenerateRequest {
	String token;
	String target;

	@Override
	public String toString() {
		return "GenerateRequest [token=" + token + ", target=" + target + "]";
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

}
