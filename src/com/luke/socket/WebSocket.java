package com.luke.socket;

import java.io.IOException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;
import com.luke.model.Messge;
import com.luke.model.Vo;

@ServerEndpoint("/ws/socket")
public class WebSocket {

	// 统计在线人数
	private static int onlineCount = 0;

	// concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
	private static CopyOnWriteArraySet<WebSocket> sessions = new CopyOnWriteArraySet<WebSocket>();

	// 是用来记录有多少websocket有多少session在运行
	// private static List<Session> sessions = new ArrayList<Session>();

	// 用来记录有多少个用户使用该websocket通道
	private static List<String> usernames = new ArrayList<String>();

	// 用来记录用户名和该session进行绑定
	private static Map<String, Session> map = new HashMap<String, Session>();

	private String username;
	private Gson gson = new Gson();

	private Session session;

	/**
	 * 
	 * @Title: whiteblack Maven Webapp
	 * @Description: 连接建立成功调用该方法
	 * @author: hqin
	 * @date: 2018-5-16
	 * @Company: LuKe
	 */
	@OnOpen
	public void onOpen(Session session) {
		this.session = session;
		sessions.add(this);// 加入set中

		// sessions.add(session);
		String str = session.getQueryString();
		username = str.split("=")[1];
		try {
			username = URLDecoder.decode(username, "utf-8");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// 将用户添加进list里
		usernames.add(username);
		// 用户和session进行绑定
//		System.out.println("username===="+username);
//		System.out.println("session===="+session);
		map.put(username, session);
//		System.out.println("欢迎" + username + ":进入聊天室");
		Messge msg = new Messge();
		msg.setContent("欢迎" + username + ":进入聊天室");
		msg.setUsernames(usernames);
		// broadSend(sessions, msg.toJson());
		addOnlineCount();// 在线数+1
//		System.out.println("新连接加入！当前在线人数为：" + getOnlineCount());

	}

	/**
	 * 
	 * @Title: whiteblack Maven Webapp
	 * @Description: 连接关闭调用方法
	 * @author: hqin
	 * @date: 2018-5-16
	 * @Company: LuKe
	 */
	@OnClose
	public void onClose(Session session) {
//		System.out.println(session.getId() + "已经关闭");
		String str = session.getQueryString();
		username = str.split("=")[1];
		try {
			username = URLDecoder.decode(username, "utf-8");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		usernames.remove(username);
		sessions.remove(this);
		Messge msg = new Messge();
		msg.setExit(username + ":已离开");
		msg.setUsernames(usernames);
		subOnlineCount();
//		System.out.println("一连接关闭：当前人数为：" + getOnlineCount());

	}

	/**
	 * 
	 * @Title: whiteblack Maven Webapp
	 * @Description: 收到客户端消息后调用的方法
	 * @author: hqin
	 * @throws EncodeException
	 * @throws ParseException
	 * @throws IOException
	 * @date: 2018-5-16
	 * @Company: LuKe
	 */
	@OnMessage
	public void onMessage(String msg, Session session) throws EncodeException,
			ParseException, IOException {
//		System.out.println("收到客户端信息：" + msg);
		Vo v = gson.fromJson(msg, Vo.class);
//		System.out.println(v.toString());
		if (v.getType() == 2) {
			Messge messge = new Messge();
			messge.setUsernames(usernames);
			messge.setContent(v.getMsg(), username);
			broadSend(messge.getContent());
		} else {
			Messge message = new Messge();
			String toUsername = v.getToUser();
			Session to_Session = map.get(toUsername);
			Session from_Session = map.get(username);
			message.setContent(v.getMsg(), v.getFromUser(), toUsername);
			try {
				// 发送给对方
//				if (to_Session == null) {
//					sessions.remove(to_Session);
//				}else {
//					to_Session.getBasicRemote().sendText(message.toJson());
//				}
				if(sessions.size() != 0){
					for(WebSocket webSocket : sessions){
						if(webSocket.session==to_Session){
							to_Session.getBasicRemote().sendText(message.getContent());
						}
					}
				}
				// 发送给自己
				from_Session.getBasicRemote().sendText(message.getContent());
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

	}

	// 实现群聊
	// public void broadSend(List<Session> ss, String msg) {
	// for (Session session : ss) {
	// try {
	// session.getBasicRemote().sendText(msg);
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	// }
	public void broadSend(String msg) {
		if (sessions.size() != 0) {
			for (WebSocket socket : sessions) {
				try {
					synchronized (socket) {
						socket.session.getBasicRemote().sendText(msg);						
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void oneToOne() {

	}

	// /**
	// *
	// * @Title: whiteblack Maven Webapp
	// * @Description: 评论/点赞通知
	// * @author: hqin
	// * @date: 2018-5-16
	// * @Company: LuKe
	// */
	// public static void remind(String unionid) {
	// System.out.println("收到客户端的unionid" + unionid);
	// for (WebSocket socket : webSockets) {
	// try {
	// synchronized (socket) {
	// socket.sendMessage(unionid);
	// }
	// } catch (Exception e) {
	// // TODO: handle exception
	// System.out.println("错误：向客户端发送消息失败");
	// webSockets.remove(socket);
	// try {
	// socket.session.close();
	// } catch (Exception e2) {
	// // TODO: handle exception
	// e2.printStackTrace();
	// }
	// }
	// }
	// }

	/**
	 * 
	 * @Title: whiteblack Maven Webapp
	 * @Description: 发生错误调用
	 * @author: hqin
	 * @date: 2018-5-16
	 * @Company: LuKe
	 */
	@OnError
	public void onError(Session session, Throwable error) {
//		System.out.println("发生错误！");
		error.printStackTrace();
	}



	/**
	 * 
	 * @Title: whiteblack Maven Webapp
	 * @Description: 在线人数
	 * @author: hqin
	 * @date: 2018-5-16
	 * @Company: LuKe
	 */
	public static synchronized int getOnlineCount() {
		return onlineCount;
	}

	/**
	 * 
	 * @Title: whiteblack Maven Webapp
	 * @Description: 在线+1
	 * @author: hqin
	 * @date: 2018-5-16
	 * @Company: LuKe
	 */
	public static synchronized void addOnlineCount() {
		WebSocket.onlineCount++;
	}

	/**
	 * 
	 * @Title: whiteblack Maven Webapp
	 * @Description: 在线-1
	 * @author: hqin
	 * @date: 2018-5-16
	 * @Company: LuKe
	 */
	public static synchronized void subOnlineCount() {
		WebSocket.onlineCount--;
	}
	
	

}
