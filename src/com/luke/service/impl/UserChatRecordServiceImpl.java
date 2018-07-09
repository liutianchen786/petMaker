package com.luke.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luke.dao.UserChatRecordMapper;
import com.luke.model.UserChatRecord;
import com.luke.service.IUserChatRecordService;
import com.luke.util.ResultBean;
import com.luke.util.ResultBean.Result;

import common.Logger;

@Service("UserChatRecordService")
public class UserChatRecordServiceImpl implements IUserChatRecordService{

	@Autowired
	private UserChatRecordMapper mapper;
	private static Logger logger = Logger.getLogger(UserChatRecordServiceImpl.class);	
	@Override
	public ResultBean insert(UserChatRecord ucRecord) {
		ResultBean bean = null;
		int row = mapper.insertSelective(ucRecord);
		if(row>=1){
			bean = new ResultBean(Result.SUCCESS);
		}else {
			bean = new ResultBean(Result.FAIL);
		}
		
		return bean;
	}

	
	@Override
	public List selectOneToOne(String sendUnionId, String toUnionId) {
		// TODO Auto-generated method stub
		List<Map> list = mapper.selectOneToOne(sendUnionId, toUnionId);
		for (Map map : list) {
			try {
				String content = URLDecoder.decode(map.get("content").toString(),"utf-8");
				map.put("content", content);
				logger.warn(content);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	

	@Override
	public List selectChatMen(String sendUnionId) {
		// TODO Auto-generated method stub
		List<Map> list = mapper.selectChatMen(sendUnionId);
		return list;
	}


	@Override
	public ResultBean updateChatState(String sendUnionId, String toUnionId) {
		ResultBean bean = null;
		int row = mapper.updateChatState(sendUnionId, toUnionId);
		if(row>=1){
			bean = new ResultBean(Result.SUCCESS);
		}else {
			bean = new ResultBean(Result.FAIL);
		}
		return bean;
	}

}
