package com.furniture.shopping.websocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.furniture.shopping.model.pojo.SysChat;
import com.furniture.shopping.model.pojo.SysChatAck;
import com.furniture.shopping.service.ChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@ServerEndpoint("/chat/{userNo}")
public class WebSocket {
    private final Logger log = LoggerFactory.getLogger(WebSocket.class);

    @Autowired
    private ChatService chatService;

    private static WebSocket webSocket;

    private static CopyOnWriteArrayList<Session> sessionPool = new CopyOnWriteArrayList<Session>();

    private static ConcurrentHashMap<String, Session> userSessionPool = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        webSocket = this;
        webSocket.chatService = this.chatService;
    }

    @OnOpen
    public void onOpen(Session session, @PathParam(value="userNo") String userNo) {
        try {
            sessionPool.add(session);
            userSessionPool.put(userNo, session);
            log.info("【websocket消息】有新的连接, 总数为: " + sessionPool.size());
        } catch (Exception e) {
            log.error("websocket建立连接报错: {}", e);
        }
    }

    @OnClose
    public void onClose(Session session, @PathParam(value="userNo") String userNo) {
        try {
            sessionPool.remove(session);
            userSessionPool.remove(userNo);
            log.info("【websocket消息】关闭连接, 总数为: " + sessionPool.size());
        } catch (Exception e) {
            log.error("websocket关闭连接报错: {}", e);
        }
    }

    @OnError
    public void onError(Session session, Throwable error, @PathParam(value="userNo") String userNo) {
        try {
            sessionPool.remove(session);
            userSessionPool.remove(userNo);
            log.info("【websocket消息】异常中断, 总数为: " + sessionPool.size());
        } catch (Exception e) {
            log.error("websocket异常中断报错: {}", e);
        }
    }

    @OnMessage
    public void onMessage(Session session, String msg, @PathParam(value="userNo") String userNo) {
        log.info("【websocket消息】接收数据, msg: " + msg);
        try {
            if ("ping".equals(msg) && session.isOpen()) {
                session.getBasicRemote().sendText("{\"type\": \"health\", \"msg\": \"pong\"}");
            } else {
                SysChat sysChat = JSONObject.parseObject(msg, SysChat.class);
                if (sysChat.getType().equals("sendMsg")) {
                    sysChat.setChatDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                    sysChat.setIsRead("0");
                    webSocket.chatService.insertChat(sysChat);

                    SysChatAck ack = new SysChatAck();
                    ack.setRespBody(sysChat);
                    ack.setType("sendMsgAck");
                    session.getBasicRemote().sendText(JSON.toJSONString(ack));

                    Session otherSession = userSessionPool.get(sysChat.getReceiver());
                    if (otherSession == null) {
                        return ;
                    } else {
                        SysChat sender = new SysChat();
                        sender.setSender(sysChat.getSender());
                        SysChatAck receiveMsgAck = new SysChatAck();
                        receiveMsgAck.setRespBody(sender);
                        receiveMsgAck.setType("receiveMsgAck");
                        otherSession.getBasicRemote().sendText(JSON.toJSONString(receiveMsgAck));
                    }
                } else if (sysChat.getType().equals("getChatList")) {
                    List<SysChat> chatList = webSocket.chatService.getChatList(sysChat.getReceiver());

                    SysChatAck ack = new SysChatAck();
                    ack.setRespBody(chatList);
                    ack.setType("getChatListAck");
                    session.getBasicRemote().sendText(JSON.toJSONString(ack));
                } else if(sysChat.getType().equals("getChatContentList")) {
                    List<SysChat> chatContentList =
                            webSocket.chatService.getChatContentList(sysChat.getSender(), sysChat.getReceiver());
                    SysChatAck ack = new SysChatAck();
                    ack.setRespBody(chatContentList);
                    ack.setType("getChatContentListAck");

                    Session userSession = userSessionPool.get(sysChat.getReceiver());
                    if (userSession != null) {
                        userSession.getBasicRemote().sendText(JSON.toJSONString(ack));
                    }
//                    session.getBasicRemote().sendText(JSON.toJSONString(ack));
                } else if (sysChat.getType().equals("setRead")) {
                    webSocket.chatService.setRead(sysChat.getSender(), sysChat.getReceiver());

                    SysChatAck ack = new SysChatAck();
                    ack.setRespBody("置已读成功");
                    ack.setType("setReadAck");
                    session.getBasicRemote().sendText(JSON.toJSONString(ack));
                }
            }
        } catch (Exception e) {
            log.error("websocket接收数据报错: {}", e);
        }
    }
}
