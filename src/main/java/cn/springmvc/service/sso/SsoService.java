package cn.springmvc.service.sso;

import cn.springmvc.model.sso.Ticket;

/**
 * 
 * @author johnson
 *
 */
public interface SsoService {

	/**
	 * generate ticket
	 * 
	 * @param target
	 * @return
	 * @throws Exception
	 */
	public Ticket storeTicket(String target) throws Exception;

	/**
	 * verify ticket
	 * 
	 * @param ticket
	 * @return
	 * @throws Exception
	 */
	public boolean verifyTicket(Ticket ticket) throws Exception;
}
