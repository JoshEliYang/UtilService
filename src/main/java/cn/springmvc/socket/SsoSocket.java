package cn.springmvc.socket;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import cn.springmvc.socket.task.SsoTask;
import jxl.common.Logger;

/**
 * 
 * @author johnson
 *
 */
@ServerEndpoint(value = "/sso")
public class SsoSocket {

	static Logger logger = Logger.getLogger(SsoSocket.class);

	// 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
	private static int onlineCount = 0;

	// concurrent包的线程安全Set，用来存放每个客户端对应的ProgressSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
	private static CopyOnWriteArraySet<SsoSocket> webSocketSet = new CopyOnWriteArraySet<SsoSocket>();

	// 与某个客户端的连接会话，需要通过它来给客户端发送数据
	private Session session;

	public static synchronized int getOnlineCount() {
		return onlineCount;
	}

	public static synchronized void addOnlineCount() {
		SsoSocket.onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		SsoSocket.onlineCount--;
	}

	public void sendMessage(String message) throws IOException {
		this.session.getBasicRemote().sendText(message);
	}

	@OnOpen
	public void onOpen(Session session) {
		this.session = session;
		webSocketSet.add(this);
		addOnlineCount();
		logger.error("sso websocket connection established, now:" + getOnlineCount());
	}

	@OnClose
	public void onClose() {
		webSocketSet.remove(this); // 从set中删除
		subOnlineCount(); // 在线数减1
		logger.error("sso websocket closed, now:" + getOnlineCount());
	}

	@OnMessage
	public void onMessage(String message, Session session) {
		logger.error("sso websocket getted message: " + message);
		try {
			SsoTask task = SsoTask.getInstance();
			task.handleMessage(message);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("sso socket error >>>> " + e.getMessage());
		}
	}

	@OnError
	public void onError(Session session, Throwable error) {
		error.printStackTrace();
		logger.error("sso socket error >>>>" + error.getMessage());
	}

	/**
	 * broadcast to all client
	 * 
	 * @param msg
	 */
	public static synchronized void broadcast(String msg) {
		logger.error("broadcast :" + msg);
		Iterator<SsoSocket> socketIt = webSocketSet.iterator();
		while (socketIt.hasNext()) {
			SsoSocket item = socketIt.next();
			try {
				item.sendMessage(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
