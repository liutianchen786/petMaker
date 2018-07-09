package com.luke.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luke.model.Circle;
import com.luke.model.UserCirclelikeRecord;
import com.luke.service.ICircleService;
import com.luke.util.JSONUtils;
import com.luke.util.ResultBean;



@Controller
@RequestMapping("admin")
public class CircleController {

//	private final static Boolean RESULTYPE_TRUE  = true;
//	private final static Boolean RESULTYPE_False = false;

	@Resource
	private ICircleService circleService ;
	
	
	/**
	 * @author ltc
	 * @param cname circleId
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException
	 * @查询圈子和此人是否关注 
	 */
	@RequestMapping(value="circle/selectAllcircled",method=RequestMethod.POST)
	@ResponseBody
	public void selectAllcircled(HttpServletRequest request,HttpServletResponse response,String cname) throws UnsupportedEncodingException{
 		response.setHeader("Content-type", "text/html;charset=UTF-8");
		String unionid =new  String(request.getParameter("unionid").getBytes("iso8859-1"), "utf-8");
		List<Map> result= circleService.selectAllcircled(unionid,cname);
		JSONUtils.printJSON(response, result, "yyyy-MM-dd HH:mm:ss");
		
	}
	/**
	 * @author ltc
	 * @param cname circleId
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException
	 * @圈子的详细查询
	 */
	@RequestMapping(value="circle/selectDetailCircle",method=RequestMethod.POST)
	@ResponseBody
	public void selectByPrimaryKey(HttpServletRequest request,HttpServletResponse response,String unionId) throws UnsupportedEncodingException{
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		Integer circleid = new  Integer(request.getParameter("circleid"));
		List<Map>  result = circleService.selectDetailCircle(circleid,unionId);
		JSONUtils.printJSON(response, result, "yyyy-MM-dd HH:mm:ss");	
	}
		
	/**
	 * @author ltc
	 * @param userId circleId
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException
	 * @圈子点击关注 
	 */
	@RequestMapping(value="circle/insertCircleiId",method=RequestMethod.POST)
	@ResponseBody
	public void insertCircleiId(HttpServletRequest request,HttpServletResponse response,UserCirclelikeRecord ucl) throws UnsupportedEncodingException{
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		ResultBean result = circleService.insertCircleiId(ucl);
		JSONUtils.printJSON(response, result, "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 查询我的关注，某个圈子有多少条新记录
	 * @Title: petMaker
	 * @Description: 
	 * @author: hqin
	 * @date: 2018-5-8
	 * @Company: LuKe
	 */
	@RequestMapping("circle/selectcircle")
	@ResponseBody
	public void selectcircle(String unionid,HttpServletResponse response){
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		List<Map> list = circleService.selectcircle(unionid);
		JSONUtils.printJSON(response, list, "yyyy-MM-dd HH:mm:ss");
	}
		
}
