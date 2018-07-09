package com.luke.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JSONUtils {
	public static void printJSON(HttpServletResponse response,Object object) {
		response.setCharacterEncoding("UTF-8");
		try {
			Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
			String json=gson.toJson(object);
			//System.out.println(json);
			PrintWriter out=response.getWriter();
			out.print(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void printJSON(HttpServletResponse response,Object object,String partten) {
		try {
			Gson gson=new GsonBuilder().setDateFormat(partten).create();
			String json=gson.toJson(object);
			PrintWriter out=response.getWriter();
			out.print(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 尝试解决
	 * @param response
	 * @param object
	 */
	public static void ArrayprintJSON(HttpServletResponse response,Object object){
		
		JSONArray jsonarray = JSONArray.fromObject(object);
		response.setContentType("text/html;charset=UTF-8");
		try 
		{
		    response.getWriter().print(jsonarray);
		} 
		catch (IOException e) 
		{
		    e.printStackTrace();
		}
	}
}
