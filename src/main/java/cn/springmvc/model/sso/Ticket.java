package cn.springmvc.model.sso;

import java.io.Serializable;

import com.springmvc.utils.MD5Util;

/**
 * 
 * @author johnson
 *
 */
public class Ticket implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String ticket;
	String target;

	public Ticket() {
		super();
	}

	public Ticket(String target) {
		this.ticket = MD5Util.string2MD5(String.valueOf(System.currentTimeMillis()));
		this.target = target;
	}

	@Override
	public String toString() {
		return "Ticket [ticket=" + ticket + ", target=" + target + "]";
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

}
