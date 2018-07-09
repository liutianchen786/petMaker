package com.luke.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luke.model.Region;
import com.luke.service.IRegionService;
import com.luke.util.JSONUtils;
import com.luke.util.ResultBean;
import com.luke.util.ResultBean.Result;
	

@Controller
@RequestMapping("admin")
public class RegionController {

	@Resource
	private IRegionService regionService;

	/**
	 * 
	 * @Title petMaker
	 * @Description: 添加位置信息
	 * @author: hqin
	 * @date 2018-5-24
	 * @Company: Luke
	 */
	@RequestMapping("region/insert")
	@ResponseBody
	public Object insert(Region region){
		ResultBean bean = null;
		try {
			bean = regionService.insert(region);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			bean = new ResultBean(Result.EXCEPTION);
		}
		return bean;
	}
	
	
	/**
	 * 
	 * @Title petMaker
	 * @Description: 查询用户的最新信息
	 * @author: hqin
	 * @date 2018-5-24
	 * @Company: Luke
	 */
	@RequestMapping("region/selectNews")
	@ResponseBody
	public void selectNews(HttpServletResponse response){
		response.setHeader("Content-type", "text/html;charset=UTF-8"); 
		try {
			List<Region> list = regionService.selectNews();
			JSONUtils.printJSON(response, list, "yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * @Title petMaker
	 * @Description: 查看当前用户附近的十个用户位置  
	 * @author: ltc
	 * @date: 2018年6月14日16:59:24 
	 * @Company: Luke
	 */
	@RequestMapping("region/queryNearByUser")
	@ResponseBody
	public void queryNearByUser(HttpServletResponse response,HttpServletRequest request,Region region,String url,String flag){
		response.setHeader("Content-type", "text/html;charset=UTF-8");
	
		try {
			List list = regionService.queryNearByUser(region,url,request.getSession().getServletContext().getRealPath("uploadimg"),flag);
			JSONUtils.printJSON(response, list, "yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
}
