package com.crawler.ws.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.crawler.storage.dto.DanMuDTO;
import com.crawler.storage.dto.RomeType;
import com.crawler.storage.service.BaseInterface;
@Component
public class SpringWSServer extends TextWebSocketHandler {
	@Autowired
	BaseInterface douyuservice;

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionEstablished(session);
		 System.out.println("建立连接");	 	
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		// TODO Auto-generated method stub
		super.handleMessage(session, message);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionClosed(session, status);
		 System.out.println("连接关闭");	 	
	}
	
	@Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception
    {       
        //System.out.println(message.getPayload());
        TextMessage msg=new TextMessage(message.getPayload());
        String messagestr=msg.getPayload();
       
        //System.out.println("接受消息:["+messagestr+"]");	 	
    	
    	JSONObject jm = JSON.parseObject(messagestr);
    	//JSON.parseObject(message, clazz)
		DanMuDTO user = new DanMuDTO();
		user.setId(jm.getString("id"));
		user.setContent(filterEmoji(jm.getString("content")));
		user.setRomeid(jm.getString("romeid"));
		user.setRomename(jm.getString("romeid"));
		user.setUserid(jm.getString("userid"));
		user.setUsername(jm.getString("username"));
		user.setWebsite(jm.getString("website"));
		user.setRomeurl(jm.getString("romeurl"));
		user.setRometype(RomeType.getEnum(jm.getString("rometype")));
		
		
		
		douyuservice.insertRecord(user);

    }
	
	
	/**
	  * 将emoji表情替换成空串
	  *  
	  * @param source
	  * @return 过滤后的字符串
	  */
	 public static String filterEmoji(String source) {
	  if (source != null && source.length() > 0) {
	   return source.replaceAll("[\ud800\udc00-\udbff\udfff\ud800-\udfff]", "");
	  } else {
	   return source;
	  }
	 }

}
