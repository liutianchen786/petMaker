package com.luke.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.luke.model.ChRegion;
import com.luke.model.User;
import com.luke.model.UserDileveryInfo;
import com.luke.service.IUserService;
import com.luke.util.DecodeUTFUtil;
import com.luke.util.JSONUtils;
import com.luke.util.ResultBean;

@Controller
@RequestMapping("admin")

public class UserController {
	
	@Resource
	private IUserService userService ;

	/**
	 * 完善用户资料
	 * @param user
	 * @param rsp
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("user/update")
	@ResponseBody
	public void updateUserInfo(User user,HttpServletResponse rsp,HttpServletRequest request) throws Exception{
		rsp.setHeader("Content-type", "text/html;charset=UTF-8"); 
		int upflag = Integer.valueOf(request.getParameter("upflag"));
		String unionid =new  String(request.getParameter("unionId").getBytes("iso8859-1"), "utf-8");
		user.setUnionid(unionid);
		ResultBean bean= userService.updateUserInfo(user,upflag);
		JSONUtils.printJSON(rsp, bean, "yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 背景图片
	 * @author: ltc
	 * @date: 2018-6-12-上午10:53:41
	 * @Company: LuKe
	 */
	@RequestMapping("user/changeBackGround")
	@ResponseBody
	public void changeBackGround(User user,HttpServletResponse rsp,HttpServletRequest request) throws Exception{
		rsp.setHeader("Content-type", "text/html;charset=UTF-8"); 
		ResultBean bean= userService.changeBackGround(user);
		JSONUtils.printJSON(rsp, bean, "yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 个人信息卡 和宠物卡信息//friendsUnionId 废弃
	 * @author: ltc
	 * @date: 2018-5-8-上午9:17:55
	 * @Company: LuKe
	 */
	@RequestMapping("user/selectPetAndPerson")
	@ResponseBody
	public void selectPetAndPerson (HttpServletResponse rsp,HttpServletRequest request) throws Exception{
		rsp.setHeader("Content-type", "text/html;charset=UTF-8");
		DecodeUTFUtil decodeUTFUtil = new DecodeUTFUtil();
		String unionid=decodeUTFUtil.ChangeString(request.getParameter("unionid"));
		String friendsUnionId=request.getParameter("friendsUnionId")!=null?new  String(request.getParameter("friendsUnionId").getBytes("iso8859-1"), "utf-8"):null;
		Map result  = userService.selectPetAndPerson(unionid,friendsUnionId);
		JSONUtils.printJSON(rsp, result, "yyyy-MM-dd HH:mm:ss");
		
	}
	
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 用户任务卡
	 * @author: ltc
	 * @date: 2018-5-8-上午9:17:55
	 * @Company: LuKe
	 */
	@RequestMapping("user/selectUserTask")
	@ResponseBody
	public void selectUserTask (HttpServletResponse rsp,HttpServletRequest request) throws Exception{
		rsp.setHeader("Content-type", "text/html;charset=UTF-8");
		String unionid =new  String(request.getParameter("unionid").getBytes("iso8859-1"), "utf-8");
		List<Map> result =userService.selectUserTask(unionid);
		JSONUtils.printJSON(rsp, result, "yyyy-MM-dd HH:mm:ss");
		
	}
	
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 查找个人信息
	 * @author: ltc
	 * @date: 2018-5-16-上午9:33:16
	 * @Company: LuKe
	 */
	@RequestMapping("user/select")
	@ResponseBody
	public void selectUserInfo(User user,HttpServletResponse rsp,HttpServletRequest request) throws Exception{
		rsp.setHeader("Content-type", "text/html;charset=UTF-8"); 
		String unionid =new  String(request.getParameter("unionid").getBytes("iso8859-1"), "utf-8");
		user= userService.selectUserInfo(unionid);
		JSONUtils.printJSON(rsp, user, "yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 查看 收货地址
	 * @author: ltc
	 * @date: 2018-5-16-下午5:33:35
	 * @Company: LuKe
	 */
	@RequestMapping("user/selectAddress")
	@ResponseBody
	public void selectAddress(HttpServletResponse rsp,HttpServletRequest request) throws Exception{
		rsp.setHeader("Content-type", "text/html;charset=UTF-8"); 
		String unionid =new  String(request.getParameter("unionid").getBytes("iso8859-1"), "utf-8");
		Integer deliveryAddressId = new Integer(request.getParameter("deliveryaddressid")!=null?Integer.valueOf(request.getParameter("deliveryaddressid")):-1);
		List<UserDileveryInfo> result= userService.selectAddress(unionid,deliveryAddressId);
		JSONUtils.printJSON(rsp, result, "yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 省市区三级联动
	 * @author: ltc
	 * @date: 2018-5-18-下午5:33:35
	 * @Company: LuKe
	 */
	@RequestMapping("user/selectChRegion")
	@ResponseBody
	public void selectChRegion(HttpServletResponse rsp,HttpServletRequest request) throws Exception{
		rsp.setHeader("Content-type", "text/html;charset=UTF-8"); 
		List<ChRegion> result = userService.selectChRegion();
		JSONUtils.printJSON(rsp, result, "yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 添加收货地址
	 * @author: ltc
	 * @date: 2018-5-17-下午3:06:00
	 * @Company: LuKe
	 */
	@RequestMapping("user/insertAddress")
	@ResponseBody
	public void insertAddress(UserDileveryInfo user,HttpServletResponse rsp,HttpServletRequest request) throws Exception{
		rsp.setHeader("Content-type", "text/html;charset=UTF-8"); 
		ResultBean bean= userService.insertAddress(user);
		JSONUtils.printJSON(rsp, bean, "yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 修改收货地址/删除地址
	 * @author: ltc
	 * @date: 2018-5-17-下午5:34:55
	 * @Company: LuKe
	 */
	@RequestMapping("user/updateAddress")
	@ResponseBody
	public void updateAddress(UserDileveryInfo user,HttpServletResponse rsp,HttpServletRequest request) throws Exception{
		rsp.setHeader("Content-type", "text/html;charset=UTF-8"); 
		ResultBean bean= userService.updateAddress(user);
		JSONUtils.printJSON(rsp, bean, "yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 设为默认地址
	 * @author: ltc
	 * @date: 2018-5-17-下午5:59:59
	 * @Company: LuKe
	 */
	@RequestMapping("user/SetDeafultAddress")
	@ResponseBody
	public void SetDeafultAddress(HttpServletResponse rsp,HttpServletRequest request) throws Exception{
		rsp.setHeader("Content-type", "text/html;charset=UTF-8"); 
		Integer deliveryAddressId = Integer.valueOf(request.getParameter("deliveryAddressId"));
		String unionid = request.getParameter("unionid");
		ResultBean bean= userService.SetDeafultAddress(deliveryAddressId,unionid);
		JSONUtils.printJSON(rsp, bean, "yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 开通/续费会员
	 * @author: ltc
	 * @date: 2018-5-19-上午11:43:43
	 * @Company: LuKe
	 */
	
	@RequestMapping(value="user/joinVip",method=RequestMethod.POST)
	@ResponseBody
	public void joinVip(User user,HttpServletResponse rsp,HttpServletRequest request,Integer month,String viptime) throws Exception{
//		rsp.setHeader("Content-type", "text/html;charset=UTF-8");
		rsp.setHeader("Access-Control-Allow-Origin", "*");
		ResultBean bean= userService.joinVip(user,month,viptime);
		JSONUtils.printJSON(rsp, bean, "yyyy-MM-dd HH:mm:ss");
	}
	
	
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 所有背景图片
	 * @author: ltc
	 * @date: 2018-6-11-下午8:09:19
	 * @Company: LuKe
	 */
	@RequestMapping(value="user/querybkgd",method=RequestMethod.POST)
	@ResponseBody
	public void querybkgd(User user,HttpServletResponse rsp,HttpServletRequest request,Integer month,String viptime) throws Exception{
//		rsp.setHeader("Content-type", "text/html;charset=UTF-8");
		List<Map<String, Object>> rs= userService.querybkgd();
		JSONUtils.printJSON(rsp, rs, "yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 更新照片墙
	 * @author: ltc
	 * @date: 2018-6-28-下午5:56:13
	 * @Company: LuKe
	 * @param:file unionId,phonePic
	 */
	@RequestMapping(value="user/updateUserPicphone",method=RequestMethod.POST)
	@ResponseBody
	public ResultBean updateUserPicphone(User user,HttpServletResponse rsp,HttpServletRequest request) throws Exception{
//		rsp.setHeader("Content-type", "text/html;charset=UTF-8");
		//更新user表
		String realPath = request.getSession().getServletContext().getRealPath("uploadimg");
		String deleUrl = request.getParameter("deleUrl")!=null?request.getParameter("deleUrl"):null;
		ResultBean rs= userService.updateUserPicphone(user,deleUrl,realPath);
		//上传照片
		return rs;
	}
	
}
