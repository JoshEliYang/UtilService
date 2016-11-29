package cn.springmvc.service.impl.sso;

import org.springframework.stereotype.Service;

import com.springmvc.utils.MemcacheUtil;

import cn.springmvc.model.sso.Ticket;
import cn.springmvc.service.sso.SsoService;

/**
 * 
 * @author johnson
 *
 */
@Service
public class SsoServiceImpl implements SsoService {

	/**
	 * generate ticket
	 */
	public Ticket storeTicket(String target) throws Exception {
		Ticket ticket = new Ticket(target);
		MemcacheUtil memcache = MemcacheUtil.getInstance();
		memcache.setDat(ticket.getTicket(), ticket);
		return ticket;
	}

	/**
	 * verify ticket
	 */
	public boolean verifyTicket(Ticket ticket) throws Exception {
		MemcacheUtil memcache = MemcacheUtil.getInstance();
		Ticket res = memcache.getDat(ticket.getTicket(), Ticket.class);

		if (res == null)
			return false;
//		if (!ticket.getTarget().equalsIgnoreCase(res.getTarget()))
//			return false;

		memcache.delete(ticket.getTicket());
		return true;
	}

}
