package com.luke.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luke.model.UserFriendsRecord;
import com.luke.service.IUserFriendsRecordService;
import com.luke.util.JSONUtils;
import com.luke.util.ResultBean;
import com.luke.util.ResultBean.Result;

@Controller
@RequestMapping("admin")
public class UserFriendsRecordController {

	@Resource
	private IUserFriendsRecordService UserFriendsRecordService;
	
	/**
	 * 添加好友
	 * @Title: petMaker
	 * @Description: 
	 * @author: hqin
	 * @date: 2018-5-7
	 * @Company: LuKe
	 */
	@RequestMapping("userfriendsRecord/insert")
	@ResponseBody
	public Object insert(UserFriendsRecord userFriendsRecord){
		ResultBean bean = null;
		try {
			bean = UserFriendsRecordService.insert(userFriendsRecord);					
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			bean = new ResultBean(Result.EXCEPTION);
		}
		return bean;
	}
	
	
	
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 查出用户的好友信息
	 * @author: hqin
	 * @date: 2018-5-16
	 * @Company: LuKe
	 */
	@RequestMapping("userfriendsRecord/selectFriendsNews")
	@ResponseBody
	public void selectFriendsNews(String unionid,HttpServletResponse response){
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		try {
			List list = UserFriendsRecordService.selectFriendsNews(unionid);
			JSONUtils.printJSON(response, list, "yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
