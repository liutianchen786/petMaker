package com.luke.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.luke.model.PetInfo;
import com.luke.model.PetType;
import com.luke.model.PetVaccineRecord;
import com.luke.service.IPetInfoService;
import com.luke.util.JSONUtils;
import com.luke.util.ResultBean;



@Controller
@RequestMapping("admin")
public class PetInfoController {
	
	@Resource
	private IPetInfoService petInfoService;
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 宠物新增
	 * @author: ltc
	 * @date: 2018-5-9-上午9:48:27
	 * @Company: LuKe
	 */
	@RequestMapping(value="pet/insertPetInfo",method=RequestMethod.POST)
	public void insertPetInfo(PetInfo pet,HttpServletRequest request,HttpServletResponse response)throws Exception{
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		ResultBean result= petInfoService.insertPetInfo(pet);
		JSONUtils.printJSON(response, result, "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 查找宠物类型（redis缓存） 三级联动
	 * @author: ltc
	 * @date: 2018-5-9-下午2:44:22
	 * @Company: LuKe
	 * @petTypePid 第一级传0 
	 */
	
	@RequestMapping("pet/selectPetType")
	public void selectPetType(HttpServletRequest request,HttpServletResponse response)throws Exception{
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		List<PetType> result = petInfoService.selectOneType();
		JSONUtils.printJSON(response, result, "yyyy-MM-dd HH:mm:ss");
		
	}
	
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 查询接种疫苗类型
	 * @author: ltc
	 * @date: 2018-5-11-上午11:58:17
	 * @Company: LuKe
	 */
	
	@RequestMapping("pet/selectVaccine")
	public void selectVaccine(HttpServletRequest request,HttpServletResponse response)throws Exception{
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		List result = petInfoService.selectVaccine();
		JSONUtils.printJSON(response, result, "yyyy-MM-dd HH:mm:ss");
		
	}
	
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 宠物查询详细信息
	 * @author: ltc
	 * @date: 2018-5-9-下午1:41:01
	 * @Company: LuKe
	 */
	@RequestMapping("pet/selectPetInfo")
	public void selectPetInfo(HttpServletRequest request,HttpServletResponse response)throws Exception{
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		String unionid = request.getParameter("unionid");
		Map result = petInfoService.selectPetInfo(unionid);
		JSONUtils.printJSON(response, result, "yyyy-MM-dd HH:mm:ss");
		
	}
	/**
	 * 
	 * @Title: petMaker
	 * @Description:  修改宠物信息
	 * @author: ltc
	 * @date: 2018-5-15-下午3:19:04
	 * @Company: LuKe
	 */
	@RequestMapping("pet/updatePetInfo")
	public void updatePetInfo(PetInfo pet,HttpServletRequest request,HttpServletResponse response)throws Exception{
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		ResultBean result= petInfoService.updatePetInfo(pet);
		JSONUtils.printJSON(response, result, "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 查询该宠物的疫苗状态
	 * @author: ltc
	 * @date: 2018-6-1-下午4:54:29
	 * @Company: LuKe
	 */
	@RequestMapping("pet/selectPetVaccineState")
	public void selectPetVaccineState(HttpServletRequest request,HttpServletResponse response)throws Exception{
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		String unionid = request.getParameter("unionid");
		List<Map> result = petInfoService.selectPetVaccineState(unionid);
		JSONUtils.printJSON(response, result, "yyyy-MM-dd HH:mm:ss");
		
	}
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 添加宠物的疫苗状态
	 * @author: ltc
	 * @date: 2018-6-4-上午11:53:46
	 * @Company: LuKe
	 */
	@RequestMapping("pet/insertPetVaccineState")
	public void insertPetVaccineState(HttpServletRequest request,HttpServletResponse response)throws Exception{
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		Gson gson = new Gson();
		String  resultForm =request.getParameter("fromList");
		List<PetVaccineRecord> map = gson.fromJson(resultForm, new TypeToken<List<PetVaccineRecord>>(){}.getType());  
		String unionid = request.getParameter("unionid");
		ResultBean bean = petInfoService.insertPetVaccineState(map,unionid);
		JSONUtils.printJSON(response, bean, "yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 修改疫苗状态
	 * @author: ltc
	 * @date: 2018-6-4-下午6:13:31
	 * @Company: LuKe
	 */
	@RequestMapping("pet/updatePetVaccineState")
	public void updatePetVaccineState(HttpServletRequest request,HttpServletResponse response)throws Exception{
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		Gson gson = new Gson();
		String  resultForm =request.getParameter("fromList");
		List<PetVaccineRecord> map = gson.fromJson(resultForm, new TypeToken<List<PetVaccineRecord>>(){}.getType());  
		String unionid = request.getParameter("unionid");
		ResultBean bean = petInfoService.updatePetVaccineState(map,unionid);
		JSONUtils.printJSON(response, bean, "yyyy-MM-dd HH:mm:ss");
	}
}
