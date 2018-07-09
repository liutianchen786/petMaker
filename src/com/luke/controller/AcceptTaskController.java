package com.luke.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luke.model.AcceptTask;
import com.luke.service.IAcceptTaskService;
import com.luke.util.JSONUtils;
import com.luke.util.ResultBean;
import com.luke.util.ResultBean.Result;

@Controller
@RequestMapping("admin")
public class AcceptTaskController {
	
	@Resource
	private IAcceptTaskService acceptTaskService;
	
	/**
	 * 接收任务入库
	 * @param accepttask
	 * @return
	 */
	@RequestMapping("accepttask/insert")
	@ResponseBody
	public Object insert(AcceptTask accepttask){
		ResultBean bean = null;
		try {
			bean = acceptTaskService.insert(accepttask);
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
	 * @Description: 查出用户接受的任务 
	 * @author: hqin
	 * @date: 2018-5-16
	 * @Company: LuKe
	 */
	@RequestMapping("accepttask/selectByUnionid")
	@ResponseBody
	public void selectByUnionid(String unionid,HttpServletResponse response){
		try {
			List<Map> list = acceptTaskService.selectByUnionid(unionid);
			JSONUtils.printJSON(response, list, "yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
