package com.luke.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luke.dao.UserFriendsRecordMapper;
import com.luke.model.UserFriendsRecord;
import com.luke.service.IUserFriendsRecordService;
import com.luke.util.ResultBean;
import com.luke.util.ResultBean.Result;

@Service("UserFriendsRecordService")
public class UserFriendsRecordServiceImpl implements IUserFriendsRecordService{

	@Autowired
	UserFriendsRecordMapper mapper;
	
	
	@Override
	public ResultBean insert(UserFriendsRecord userFriendsRecord) {
		// TODO Auto-generated method stub
		ResultBean bean = null;
		try {
			//如果flag =2,3是更新  如果flag =1 是新增
				
			if(userFriendsRecord.getFlag().equals("1")||userFriendsRecord.getFlag()=="1"){
				mapper.insert(userFriendsRecord);
			}
			else{
				mapper.updateFlag(userFriendsRecord);
			}
			bean = new ResultBean(Result.SUCCESS);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			bean = new ResultBean(Result.EXCEPTION);
		}
		return bean;
	}


	@Override
	public List selectFriendsNews(String unionid) {
		List<Map> list = mapper.selectFriendsNews(unionid);
		return list;
	}




	

}
