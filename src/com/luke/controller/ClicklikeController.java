package com.luke.controller;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luke.model.Clicklike;
import com.luke.service.IClicklikeService;
import com.luke.util.JSONUtils;
import com.luke.util.ResultBean;
import com.luke.util.ResultBean.Result;

@Controller
@RequestMapping("admin")
public class ClicklikeController {

	@Resource 
	private IClicklikeService clicklikeService ;
	
	/**
	 * 点赞 需要提醒用户!websocket
	 * @Title: petMaker
	 * @Description: 
	 * @author: ltc
	 * @date: 2018-5-8-上午11:22:43
	 * @Company: LuKe
	 */
	@RequestMapping("clicklike/insert")
	@ResponseBody
	public Object insert(Clicklike clike,HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		ResultBean bean=null;
		try {
//			String ifclick = request.getParameter("ifclick");
//			int ic = Integer.parseInt(ifclick);
//			String mess = request.getParameter("mid");
//			int messid = Integer.parseInt(mess);
			bean = clicklikeService.insert(clike);
		
		} catch (Exception e) {
			e.printStackTrace();
			bean = new ResultBean(Result.EXCEPTION);
		}
		return bean;
	}
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 通知查询点赞个数 和 消息个数
	 * @author: ltc
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws NoSuchMethodException 
	 * @throws UnsupportedEncodingException 
	 * @throws IllegalArgumentException 
	 * @date: 2018-5-22-下午1:12:56
	 * @Company: LuKe
	 */
	@RequestMapping("clicklike/queryNotify")
	@ResponseBody
	public void queryNotify(HttpServletResponse response,HttpServletRequest request) throws IllegalArgumentException, UnsupportedEncodingException, NoSuchMethodException, IllegalAccessException, InvocationTargetException{
		response.setHeader("Content_type", "text/html;charset=UTF-8");
		String unionId = request.getParameter("unionId");
		Map list = clicklikeService.queryNotify(unionId);
		JSONUtils.printJSON(response, list, "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 查询是否点赞
	 * @param mid
	 * @param response
	 */
	@RequestMapping("clicklike/selectIfClick")
	@ResponseBody
	public void selectIfClick(Integer mid,HttpServletResponse response){
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		try {
			List list = clicklikeService.selectIfClick(mid);
			JSONUtils.printJSON(response, list, "yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Title petMaker
	 * @Description: 点赞/评论 通知
	 * @author: hqin
	 * @date 2018-6-29
	 * @Company: Luke
	 */
	@RequestMapping("clicklike/querynotice")
	@ResponseBody
	public void queryNotice(HttpServletResponse response,HttpServletRequest request){
		response.setHeader("Content_type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		String unionId = request.getParameter("unionId");
		List list = clicklikeService.queryNotice(unionId);
		JSONUtils.printJSON(response, list, "yyyy-MM-dd HH:mm:ss");
	}
	
}
