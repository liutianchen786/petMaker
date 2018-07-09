package com.luke.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luke.model.ReleaseTask;
import com.luke.service.IReleaseTaskService;
import com.luke.util.JSONUtils;
import com.luke.util.ResultBean;
import com.luke.util.ResultBean.Result;

@Controller
@RequestMapping("admin")
public class ReleaseTaskController {
	
	@Resource
	private IReleaseTaskService releaseTaskService;
	
	/**
	 * 将任务存进库里
	 * @param releasetask
	 * @return
	 */
	@RequestMapping("releasetask/insert")
	@ResponseBody
	public Object insert(ReleaseTask releasetask){
		ResultBean bean = null;
		try {
			bean = releaseTaskService.insert(releasetask);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			bean = new ResultBean(Result.EXCEPTION);
		}
		return bean;
	}
	
	/**
	 * 查询任务
	 * @param response
	 */
	@RequestMapping("releasetask/selectall")
	@ResponseBody
	public void selectAll(HttpServletResponse response){
		try {
			List<Map> list = releaseTaskService.selectAll();
			JSONUtils.printJSON(response, list, "yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
