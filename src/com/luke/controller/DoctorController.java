package com.luke.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luke.model.UserDoctorInfo;
import com.luke.service.IDoctorService;
import com.luke.util.JSONUtils;
import com.luke.util.ResultBean;

@Controller
@RequestMapping("admin")
public class DoctorController {
	

	@Resource
	private IDoctorService doctorServiceImpl ;
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 查询所有医生信息
	 * @author: ltc
	 * @date: 2018-6-20-下午3:10:05
	 * @Company: LuKe
	 * @param:不需要参数
	 */
	@RequestMapping("/dct/queryDocInfo")
	@ResponseBody
	public void queryDocInfo(HttpServletResponse response,HttpServletRequest request)throws Exception{
		response.setHeader("Content_type", "text/html;charset=UTF-8");
		List<UserDoctorInfo> result = doctorServiceImpl.queryDocInfo();
		JSONUtils.printJSON(response, result);
	}
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 点击问问后，添加一条记录
	 * @author: ltc
	 * @date: 2018-6-20-下午4:42:41
	 * @Company: LuKe
	 * @param: userDtcId 医生id,userUnionId 用户id
	 */
	@RequestMapping("/dct/insertRecord")
	@ResponseBody
	public ResultBean insertRecord(HttpServletResponse response,HttpServletRequest request)throws Exception{
		response.setHeader("Content_type", "text/html;charset=UTF-8");
		String userDtcId = request.getParameter("userDtcId");
		String userUnionId =request.getParameter("userUnionId");
		ResultBean result = doctorServiceImpl.insertRecord(userDtcId,userUnionId);
		return result;
	}
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 点赞医生
	 * @author: ltc
	 * @date: 2018-6-25-下午4:03:14
	 * @Company: LuKe
	 * @param: userDtcId 医生id
	 */
	@RequestMapping("/dct/likeDoc")
	@ResponseBody
	public ResultBean likeDoc(HttpServletResponse response,HttpServletRequest request,String userDtcId)throws Exception{
		response.setHeader("Content_type", "text/html;charset=UTF-8");
		ResultBean result = doctorServiceImpl.likeDoc(userDtcId);
		return result;
	}
}
