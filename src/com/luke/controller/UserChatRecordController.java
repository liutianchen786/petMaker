package com.luke.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luke.model.UserChatRecord;
import com.luke.service.IUserChatRecordService;
import com.luke.util.JSONUtils;
import com.luke.util.ResultBean;
import com.luke.util.ResultBean.Result;

@Controller
@RequestMapping("admin")
public class UserChatRecordController {
	
	@Resource
	private IUserChatRecordService userChatRecordService;
	
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 记录聊天信息
	 * @author: hqin
	 * @date: 2018-5-16
	 * @Company: LuKe
	 */
	@RequestMapping("userchatrecord/insert")
	@ResponseBody
	public Object insert(UserChatRecord ucRecord){
		ResultBean bean = null;
		ucRecord.setChatTime(new Date(System.currentTimeMillis()));
		try {
			//DecodeUTFUtil decodeUTFUtil = new DecodeUTFUtil();
			//decodeUTFUtil.ChangeDecode(ucRecord);
			bean = userChatRecordService.insert(ucRecord);
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
	 * @Description: 查询两个人的聊天信息
	 * @author: hqin
	 * @date: 2018-5-16
	 * @Company: LuKe
	 */
	@RequestMapping("userchatrecord/selectonetoone")
	@ResponseBody
	public void selectOnetoOne(HttpServletResponse response,HttpServletRequest res){
		response.setHeader("Content-type", "text/html;charset=UTF-8"); 
		try {
			String sendUnionId= res.getParameter("sendUnionId");
			String toUnionId = res.getParameter("toUnionId");
			List<Map> list = userChatRecordService.selectOneToOne(sendUnionId, toUnionId);
			JSONUtils.printJSON(response, list, "yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询聊天人
	 * @param response
	 * @param request
	 */
	@RequestMapping("userchatrecord/selectchatmen")
	@ResponseBody
	public void selectChatMen(HttpServletResponse response,HttpServletRequest request){
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		try {
			String sendUnionId = request.getParameter("sendUnionId");
			List<Map> list = userChatRecordService.selectChatMen(sendUnionId);
			JSONUtils.printJSON(response, list, "yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	
	/**
	 * 
	 * @Title petMaker
	 * @Description: 进入聊天页面，已读为1
	 * @author: hqin
	 * @date 2018-6-27
	 * @Company: Luke
	 */
	@RequestMapping("userchatrecord/updatechatsstate")
	@ResponseBody
	public Object updateChatState(String sendUnionId,String toUnionId){
		ResultBean bean = null;
		try {
			bean = userChatRecordService.updateChatState(sendUnionId, toUnionId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			bean = new ResultBean(Result.EXCEPTION);
		}
		
		return bean;
	}
	
}
