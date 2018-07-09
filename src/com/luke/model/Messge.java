package com.luke.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import org.apache.commons.collections4.map.HashedMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Messge implements Serializable{
	/**
	 * 1
	 */
	private static final long serialVersionUID = -625809221208944505L;
	private List<String> usernames;  
    private String content;  
    private String username;  
    private String welcome;  
    private String exit;  
    
    
    
    public String getUsername() {  
        return username;  
    }  
    public void setUsername(String username) {  
        this.username = username;  
    }  
    public String getWelcome() {  
        return welcome;  
    }  
    public void setWelcome(String welcome) {  
        this.welcome = welcome;  
    }  
    public String getExit() {  
        return exit;  
    }  
    public void setExit(String exit) {  
        this.exit = exit;  
    }  
    public List<String> getUsernames() {  
        return usernames;  
    }  
    public void setUsernames(List<String> usernames) {  
        this.usernames = usernames;  
    }  
    public String getContent() {  
        return content;  
    }  
    public void setContent(String content) {  
        this.content = content;  
    }  
    public void setContent(String msg,String username) {  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        Date date = new Date();  
        date.getTime();  
        String dateStr = sdf.format(date);  
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", "2");
        map.put("msg", msg);
        JSONObject jsonObject = JSONObject.fromObject(map);
        String content = jsonObject.toString();
        this.content = content;  
    }  
      
    public void setContent(String msg, String username, String toUsername) {  
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");  
        Date date = new Date();  
        date.getTime();
        String dateStr = sdf.format(date);
//      String content = "'date':"+dateStr+",'username':"+username+",'toUsername':"+toUsername+",'msg':"+msg+"";
        
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", "1");
        map.put("date", dateStr);
        map.put("username", username);
        map.put("toUsername", toUsername);
        map.put("msg", msg);
        JSONObject jsonObject = JSONObject.fromObject(map);
//        String content =  dateStr +","+ username +","+ toUsername +","+ msg;
        String content = jsonObject.toString();
        this.content = content;
    }  
    
    public String toJson(){  
    	Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		return gson.toJson(this);
    }
}
