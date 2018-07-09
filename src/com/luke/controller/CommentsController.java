package com.luke.controller;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luke.model.Comments;
import com.luke.model.User;
import com.luke.service.ICommentsService;
import com.luke.util.DecodeUTFUtil;
import com.luke.util.JSONUtils;
import com.luke.util.ResultBean;


@Controller
@RequestMapping("admin")
public class CommentsController {

	
	@Resource 
	ICommentsService CommentsService;
	/**
	 * 评论时要提醒用户
	 * 添加评论
	 * @param comments
	 * @throws UnsupportedEncodingException 
	 * @throws ParseException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws NoSuchMethodException 
	 * @throws IllegalArgumentException 
	 */
	@RequestMapping("comment/insert")
	@ResponseBody
	public Object insert(Comments comments,HttpServletRequest request) {
//		DecodeUTFUtil decodeUTFUtil = new DecodeUTFUtil();
		ResultBean bean = null;
		
		try {
//			decodeUTFUtil.ChangeDecode(comments);
			bean = CommentsService.insert(comments);
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		return bean;
	}
	
	/**
	 * 根据mid查询回复内容
	 * @param mid
	 * @param response
	 */
	@RequestMapping("comment/selectReply")
	@ResponseBody
	public void selectReply(Integer mid,HttpServletResponse response){
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		try {
			List list = CommentsService.selectReply(mid);
			
			JSONUtils.printJSON(response, list, "yyyy-MM-dd HH:mm:ss");
 		} catch (Exception e) {
			// TODO: handle exception
 			e.printStackTrace();
		}
		
	}
	/**
	 * 
	 * @param mid
	 * @param response
	 */
	@RequestMapping("comment/selectCommid")
	@ResponseBody
	public void selectCommid(Integer mid,HttpServletResponse response){
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		try {
			List list = CommentsService.selectCommid(mid);
			JSONUtils.printJSON(response, list, "yyyy-MM-dd HH:mm:ss");
 		} catch (Exception e) {
			// TODO: handle exception
 			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 查询用户签到的天数以及用户信息
	 * @author: ltc
	 * @date: 2018-5-30-上午11:53:53
	 * @Company: LuKe
	 */
	@RequestMapping(value="comment/userSignDay",method=RequestMethod.POST)
	@ResponseBody
	public void userSignDay(HttpServletResponse response,HttpServletRequest request,String unionid) throws Exception{
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		Map rs = CommentsService.userSignDay(unionid);
		JSONUtils.printJSON(response, rs, "yyyy-MM-dd HH:mm:ss");
	}
	
	

	/**
	 * 
	 * @Title: petMaker
	 * @Description: 签到
	 * @author: ltc
	 * @date: 2018-5-5-下午5:11:06
	 * @Company: LuKe
	 */	
	@RequestMapping(value="comment/signin",method=RequestMethod.POST)
	@ResponseBody
	public void signin(HttpServletResponse response,HttpServletRequest request,User user) throws Exception{
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		ResultBean rs = CommentsService.signin(user);
		JSONUtils.printJSON(response, rs, "yyyy-MM-dd HH:mm:ss");
	}
	
}
