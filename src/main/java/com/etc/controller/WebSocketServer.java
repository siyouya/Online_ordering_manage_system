package com.etc.controller;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * writer: holien
 * Time: 2017-08-01 13:00
 * Intent: webSocket服务器
 */
@ServerEndpoint("/webSocket/chat/{roomName}/{username}")
public class WebSocketServer {

    // 使用map来收集session，key为roomName，value为同一个房间的用户集合
    // concurrentMap的key不存在时报错，不是返回null
    private static final Map<String, Set<Session>> rooms = new ConcurrentHashMap();
    private static final Map<String, String> userNameList = new ConcurrentHashMap();
    @OnOpen
    public void connect(@PathParam("roomName") String roomName,@PathParam("username") String username, Session session) throws Exception {
        // 将session按照房间名来存储，将各个房间的用户隔离
        if (!rooms.containsKey(roomName)) {
            // 创建房间不存在时，创建房间
            Set<Session> room = new HashSet<Session>();
            // 添加用户
            room.add(session);

            rooms.put(roomName, room);
        } else {
            // 房间已存在，直接添加用户到相应的房间
            rooms.get(roomName).add(session);
        }
        System.err.println("username"+username);
        System.out.println("a client has connected!");
    }

    @OnClose
    public void disConnect(@PathParam("roomName") String roomName,@PathParam("userName") String userName, Session session) {
        rooms.get(roomName).remove(session);
        System.out.println("a client has disconnected!");
    }

    @OnMessage
    public void receiveMsg(@PathParam("roomName") String roomName,@PathParam("username") String username,
                           String msg, Session session) throws Exception {
        // 此处应该有html过滤
        //msg = username + ":" + msg;
        System.out.println(msg);
        // 接收到信息后进行广播
        broadcast(roomName, msg);
     //   keepSession(roomName,username);
    }

    // 按照房间名进行广播
    public static void broadcast(String roomName, String msg) throws Exception {
        for (Session session : rooms.get(roomName)) {
            session.getBasicRemote().sendText(msg);
        }
    }

    //判断userNameList相等遍历所在的房间号码,用session传值保存
    public static void keepSession(String roomName, String username)throws Exception{
        //获取房间号中的用户名

        //   Map<String, String> userNameList = new ConcurrentHashMap();
        //session中[1,session[xh,cxy,jh]];
        //session中[2,session[xh,cxy]];
        //session中[3,session[xh]];
        //想要实现[xh,session[1,2,3]]
        //[cxy,session[1,2]]
        //[jh,session[3]]
        //userNamelist=[xh,cxy,jh,xq,hym]
        for (Session session : rooms.get(roomName)) {
            System.out.println(session.getId());
            session.getBasicRemote();

            session.getBasicRemote().sendText(username);
        }



    }


}