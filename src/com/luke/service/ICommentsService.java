package com.luke.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import com.luke.model.Comments;
import com.luke.model.User;
import com.luke.util.ResultBean;

public interface ICommentsService{
	
	public ResultBean insert(Comments comments);
	
	public List<Map> selectReply(Integer mid) ;
	public ResultBean signin(User user);
	
	public List selectCommid(Integer mid);

	public Map userSignDay(String unionid);
	
}
