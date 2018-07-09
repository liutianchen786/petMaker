package com.luke.service.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luke.dao.ClicklikeMapper;
import com.luke.dao.MessageMapper;
import com.luke.model.Clicklike;
import com.luke.model.Message;
import com.luke.service.IClicklikeService;
import com.luke.util.ResultBean;
import com.luke.util.ResultBean.Result;

@Service("ClicklikeService")
public class ClicklikeServiceImpl implements IClicklikeService{

	
	@Autowired
	private ClicklikeMapper mapper;
	@Autowired
	private MessageMapper messageMapper;
	/**
	 * 点赞
	 */
	@Override
	public ResultBean insert(Clicklike clike) {
		ResultBean bean=null;
		try {
			clike.setClicktime(new Timestamp(System.currentTimeMillis()));
			int update = mapper.updaterow(clike);
			int row =0;//如果没有更新的
			if(update==0){
				 row = mapper.insertSelective(clike);
			}
			//如果是点赞，给信息+1 如果是取消点赞 给信息-1
			Message record = new Message();
			record.setMessid(clike.getMid());
			record.setClickcount(clike.getIfclick()==(byte)0?-1:1);
			messageMapper.updateCount(record);
			if(row>=1){
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


	/**
	 * 查询是否点赞
	 */
	@Override
	public List selectIfClick(Integer mid) {
		List list = mapper.selectIfClick(mid);
		return list;
	}

	/**
	 * 
	 * @Description:点赞评论详情和个数,查询完后记录操作表user_notify_record
	 * @author: ltc
	 * @date: 2018-5-22
	 * @Company: LuKe
	 */
	@Override
	public Map queryNotify(String unionId) {
		List<Map> result = mapper.queryClicklike(unionId); 
		List<Map> result2 = mapper.queryComments(unionId);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("clickLike", result);
		map.put("comments",result2);
 		//查询完成插入user_notify_record做记录
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp=new Timestamp(calendar.getTime().getTime());
		mapper.insertNotify(unionId,timestamp);
		return map;
	}


	@Override
	public List queryNotice(String unionId) {
		List<Map> result = mapper.queryNotice(unionId);
		//查询完成插入user_notify_record做记录
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp=new Timestamp(calendar.getTime().getTime());
		mapper.insertNotify(unionId,timestamp);
		return result;
	}
}

