package com.luke.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luke.dao.ReplycommentMapper;
import com.luke.model.Replycomment;
import com.luke.util.JSONUtils;
import com.luke.util.ResultBean;
import com.luke.util.ResultBean.Result;

@Controller
@RequestMapping("admin")
public class ReplyCommentController {

	@Autowired
	private ReplycommentMapper mapper;
	
	
	@RequestMapping("replycomment/insert")
	@ResponseBody
	public Object insert(Replycomment rComment) {
		ResultBean bean = null;
		try {
			int row = mapper.insertSelective(rComment);
			if(row > 0){
				bean = new ResultBean(Result.SUCCESS);
			}else {
				bean = new ResultBean(Result.FAIL);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			bean = new ResultBean(Result.EXCEPTION);
		}
		
		return bean;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("replycomment/selectbycommid")
	@ResponseBody
	public void selectBycommid(Integer commid,HttpServletResponse response){
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		try {
			List list = mapper.selectBycommid(commid);
			JSONUtils.printJSON(response, list, "yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
}
