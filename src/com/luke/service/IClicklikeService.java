package com.luke.service;

import java.util.List;
import java.util.Map;

import com.luke.model.Clicklike;
import com.luke.util.ResultBean;

public interface IClicklikeService {
	
	//点赞
	public ResultBean insert(Clicklike clike);
	
	
	//是否点赞
	public List selectIfClick(Integer mid);

	//点赞个数
	public Map queryNotify(String unionId);
	
	//通知点赞或评论
	public List queryNotice(String unionId);
}
