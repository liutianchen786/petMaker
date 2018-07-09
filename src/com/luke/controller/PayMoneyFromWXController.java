package com.luke.controller;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luke.service.IPayMoneyFromWXService;
import com.luke.util.FormatBizQueryParaMap;
import com.luke.util.JSONUtils;

@Controller
@RequestMapping("admin")
public class PayMoneyFromWXController {

	@Autowired  IPayMoneyFromWXService payMoneyFromWXService;
	
	
	
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 请求调用支付接口 
	 * @author: ltc
	 * @date: 2018-5-23-下午2:07:44
	 * @Company: LuKe
	 */
	@RequestMapping("/pay/vip")
	@ResponseBody
	public void vip (HttpServletRequest request , HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");
		String body = request.getParameter("body");
		String openid =request.getParameter("openid");
		response.setHeader("Access-Control-Allow-Origin", "*");//解决跨域问题
		BigDecimal total_fee = new BigDecimal(request.getParameter("total_fee").toString());
//		String body ="lk-vip";
//		String openid ="oQLi84qE7M9kY6fLMNaxaZ_sha-s";
//		BigDecimal total_fee=new BigDecimal(3000);
		//	APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
		String  spbill_create_ip = FormatBizQueryParaMap.getIpAddr(request);
//		System.out.println(spbill_create_ip);
//		String  spbill_create_ip ="192.168.0.111";
		Map map = payMoneyFromWXService.pay(openid,total_fee,body,spbill_create_ip);
		JSONUtils.printJSON(response, map);
	}
	
	
}
