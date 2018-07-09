package com.luke.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luke.model.GoodsTags;
import com.luke.service.IGoodsService;
import com.luke.util.JSONUtils;


@Controller
@RequestMapping("admin")
public class GoodsController {

	@Resource
	private IGoodsService goodsServiceImpl;
	
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 商品预览和商品详情
	 * @author: ltc
	 * @date: 2018-5-16-下午1:35:22
	 * @Company: LuKe
	 */
	@RequestMapping("goods/selectGoods")
	@ResponseBody
	public void selectGoods(HttpServletRequest request,HttpServletResponse rsp) throws Exception{
		rsp.setHeader("Content-type", "text/html;charset=UTF-8");
		String goodsTagsId=request.getParameter("goodsTagsId")!=null?String.valueOf(request.getParameter("goodsTagsId")):null;
		String goodsId = request.getParameter("goodsId")!=null?String.valueOf(request.getParameter("goodsId")):null;
		List<Map> result = goodsServiceImpl.selectGoods(goodsTagsId,goodsId);
		JSONUtils.printJSON(rsp, result, "yyyy-MM-dd HH:mm:ss");
		
	}
	
	
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 商品标签查找
	 * @author: ltc
	 * @date: 2018-5-16-下午5:13:43
	 * @Company: LuKe
	 */
	@RequestMapping("goods/selectAllTags")
	@ResponseBody
	public void selectAllTags(HttpServletRequest request,HttpServletResponse rsp) throws Exception{
		rsp.setHeader("Content-type", "text/html;charset=UTF-8");
		List<GoodsTags> result = goodsServiceImpl.selectAllTags();
		JSONUtils.printJSON(rsp, result, "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 插入兑换商品记录 
	 * @author: ltc
	 * @date: 2018-5-21-下午3:57:54
	 * @Company: LuKe
	 */
	@RequestMapping("goods/insertGoodsRecord")
	@ResponseBody
	public void insertGoodsRecord(HttpServletRequest request,HttpServletResponse rsp) throws Exception{
		rsp.setHeader("Content-type", "text/html;charset=UTF-8");
		List<GoodsTags> result = goodsServiceImpl.selectAllTags();
		JSONUtils.printJSON(rsp, result, "yyyy-MM-dd HH:mm:ss");
	}
	
	
	/**
	 * 
	 * @Title petMaker
	 * @Description: 查询会员记录
	 * @author: hqin
	 * @date 2018-6-14
	 * @Company: Luke
	 */
	@RequestMapping("goods/selectVip")
	@ResponseBody
	public void selectViP(HttpServletResponse response){
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		List<Map> list = goodsServiceImpl.selectViP();
		JSONUtils.printJSON(response, list,"yyyy-MM-dd HH:mm:ss");
	}
	
}
