package com.luke.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.luke.model.Message;
import com.luke.service.IMessageService;
import com.luke.util.JSONUtils;
import com.luke.util.ResultBean;
import com.luke.util.ResultBean.Result;

@Controller
@RequestMapping("admin")
public class MessageController{
	private static  Logger logger = Logger.getLogger(MessageController.class);
	@Resource 
	private IMessageService MessageService;
	
	
	/**
	 * 将信息存进数据库
	 * @param message
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws ParseException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws NoSuchMethodException 
	 * @throws IllegalArgumentException 
	 */
	@RequestMapping("message/insert")
	@ResponseBody
	public Object insert(Message message,HttpServletRequest request)  {
//		DecodeUTFUtil decodeUTFUtil = new DecodeUTFUtil();
		ResultBean bean = null;
		try {
//			decodeUTFUtil.ChangeDecode(message);
			bean = MessageService.insert(message);
		} 
		catch (Exception e1) {
			e1.printStackTrace();
		} 
		return bean;
	}
	
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 每次查找2条message表数据 /个人用户中心：查找unionId下所有话题 /查找圈子话题 
	 * @param state 0广播动态  1圈子话题  2所有类型
	 * @author: ltc
	 * @date: 2018-5-5-下午5:06:26
	 * @Company: LuKe
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("message/selectAll")
	@ResponseBody
	public void findAll(HttpServletRequest request,HttpServletResponse response) throws Exception{
		response.setHeader("Content-type", "text/html;charset=UTF-8"); 
		try { 
			Integer pageNum =request.getParameter("pageNum")!=null?Integer.valueOf(request.getParameter("pageNum")):-1;
			Integer messState=request.getParameter("messState")!=null?Integer.valueOf(request.getParameter("messState")):0;
			Integer circleId= request.getParameter("circleId")!=null?Integer.valueOf(request.getParameter("circleId")):-1;
			Integer messid= request.getParameter("messid")!=null?Integer.valueOf(request.getParameter("messid")):-1;
			String unionId = request.getParameter("unionId");
			String masterUnionId = NullOrString(request.getParameter("masterUnionId"));//个人主页传 主人的ID
//			String messState = request.getParameter("messState");
			List<Map> list =MessageService.findAll(pageNum,unionId,masterUnionId,circleId,messid,messState);
			JSONUtils.printJSON(response, list,"yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 查找个人主页/圈子的话题
	 * @param state 0广播动态  1圈子话题  2所有类型
	 * @author: ltc
	 * @date: 2018-5-5-下午5:06:26
	 * @Company: LuKe
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("message/selectCircleOrCenter")
	@ResponseBody
	public void selectCircleOrCenter(HttpServletRequest request,HttpServletResponse response) throws Exception{
		response.setHeader("Content-type", "text/html;charset=UTF-8"); 
		try { 
			String unionId=request.getParameter("unionId");
			String masterUnionId = NullOrString(request.getParameter("masterUnionId"));//个人主页传 主人的ID
			String circleId = NullOrString(request.getParameter("circleId"));//圈子传圈子ID
			List<Map> list =MessageService.selectCircleOrCenter(unionId,masterUnionId,circleId);
			JSONUtils.printJSON(response, list,"yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("message/selectByKey")
	@ResponseBody
	public void selectByKey(Integer id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		response.setHeader("Content-type", "text/html;charset=UTF-8"); 
		try {
			List<Map> list = MessageService.selectByKey(id);
			JSONUtils.printJSON(response, list,"yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

/**
 * 
 * RequestMapping("message/selectByIfclick")
	@ResponseBody
	public Object selectByIfclick(){
		try {
			List list = mapper.selectByIfclick();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	不用的 接口
**/
	/**
	 * 删除一条记录
	 * @param id
	 * @return
	 */
	@RequestMapping("message/delete")
	@ResponseBody
	public Object delete(Integer messid,HttpServletRequest request,HttpServletResponse response,String messimage) throws Exception{
		ResultBean bean = null;
		try {
			JSONArray jsonArray = messimage.equals("null")?null:JSONArray.fromObject(messimage); 
			List<String> result = messimage.equals("null")?null:(List<String>) JSONArray.toList(jsonArray);
			String realPath = request.getSession().getServletContext().getRealPath("uploadimg");
			bean= MessageService.delete(messid,result,realPath);
		} catch (Exception e) {
			bean = new ResultBean(Result.EXCEPTION);
			e.printStackTrace();
		}
		return bean;
	}
	

	
	/**
	 * 图片上传
	 * 
	 * */
	@RequestMapping("upload")  
    @ResponseBody
    public Object upload(MultipartFile file,HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException{

		//创建存储图片的文件夹“uploadimg”
		try{
			String realPath = request.getSession().getServletContext().getRealPath("uploadimg");
			String image = MessageService.upload(file,realPath);
			return image;
		}
		catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
    }
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 查询我发表的
	 * @author: hqin
	 * @date: 2018-5-9
	 * @Company: LuKe
	 */
	@RequestMapping("message/selectPublished")
	@ResponseBody
	public void selectPublished(String unionid,HttpServletResponse response){
		response.setHeader("Content-type", "text/html;charset=UTF-8"); 
		try {
			List<Map> list = MessageService.selectPublished(unionid);
			JSONUtils.printJSON(response, list,"yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	/**
//	 * 删除message/修改message表里ZfFlag = 1 即可
//	 * @Title: petMaker
//	 * @Description: 
//	 * @author: hqin
//	 * @date: 2018-5-9
//	 * @Company: LuKe
//	 */
//	@RequestMapping("message/updateZfflag")
//	@ResponseBody
//	public Object updateZfflag(Integer messid){
//		ResultBean bean = null;
//		try {
//			bean = MessageService.updateZfflag(messid);
//		} catch (Exception e) {
//			// TODO: handle exception
//			bean = new ResultBean(Result.EXCEPTION);
//		}
//		return bean;
//	}
//	
	/**
	 * 
	 * @Title petMaker
	 * @Description:热门话题
	 * @author: hqin
	 * @date 2018-5-30
	 * @Company: Luke
	 */
	@RequestMapping("message/selectHot")
	@ResponseBody
	public void selectHot(HttpServletResponse response,String unionId){
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		try {
			List<Map<String,Object>> list = MessageService.selectHot(unionId);
			JSONUtils.printJSON(response, list,"yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 查找最新话题 (此人关注的圈子12小时内最新的话题)
	 * @author: ltc
	 * @date: 2018-6-6-上午9:45:42
	 * @Company: LuKe
	 */
	@RequestMapping("message/selectNews")
	@ResponseBody
	public void selectNews(HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		String unionId = request.getParameter("unionId");
		try {
			List<Map<String,Object>> list = MessageService.selectNews(unionId);
			JSONUtils.printJSON(response, list,"yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 点击一次给该条信息+1浏览量
	 * @author: ltc
	 * @date: 2018-6-6-上午9:45:42
	 * @Company: LuKe
	 */
	@RequestMapping("message/addCount")
	@ResponseBody
	public void addCount(HttpServletRequest request,HttpServletResponse response,Message message){
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		String unionId = request.getParameter("unionId");
		try {
			ResultBean bean = MessageService.addCount(message);
			JSONUtils.printJSON(response, bean,"yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private String NullOrString(String param){
		return param!=null?param:null;
	}
	
	/**
	 * 
	 * @Title petMaker
	 * @Description:点赞评论数、未读消息数
	 * @author: hqin
	 * @date 2018-6-29
	 * @Company: Luke
	 */
	@RequestMapping("message/querylikecomm")
	@ResponseBody
	public Object queryLikeCom(String unionId,HttpServletResponse response){
		try {
			List list = MessageService.queryLikeCom(unionId);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "fail"; 
		}
	}
	
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 近期浏览
	 * @author: ltc
	 * @date: 2018-7-6-下午4:32:15
	 * @Company: LuKe
	 */
	@RequestMapping("message/watchedHistory")
	@ResponseBody
	public void watchedHistory(HttpServletResponse response,HttpServletRequest request){
			String browseData = request.getParameter("history");
			List<Map> rs = MessageService.watchedHistory(browseData);
			JSONUtils.printJSON(response, rs);
			
	}
	
}
