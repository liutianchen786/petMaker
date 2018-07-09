package com.luke.controller;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luke.model.User;
import com.luke.service.ILoginService;

@org.springframework.stereotype.Controller
@RequestMapping("admin")
public class LoginController {
	
	@Resource
	private ILoginService loginService;
	
	/**
	 * 解密用户敏感数据
	 * 
	 * @param encryptedData
	 * @param iv
	 * @param code_key
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@ResponseBody
	@RequestMapping(value = "/decodeUserInfo", method = RequestMethod.POST)
	public Map<String,Object> decodeUserInfo(HttpServletRequest request, String encryptedData,
			String iv, String code,User user) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		Map<String,Object> resultmap = loginService.userLogin(encryptedData,iv,code,user);		
		return resultmap;
	}
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 控制广播页面是否加载 过审
	 * @author: ltc
	 * @date: 2018-7-2-上午11:49:20
	 * @Company: LuKe
	 */
	@ResponseBody
	@RequestMapping(value = "/isLoadClassfy", method = RequestMethod.POST)
	public boolean isLoadClassfy() {
		return true;
	}

}
