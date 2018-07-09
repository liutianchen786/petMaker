package com.luke.service;

import java.util.List;

import com.luke.model.UserFriendsRecord;
import com.luke.util.ResultBean;

public interface IUserFriendsRecordService {
	
	public ResultBean insert(UserFriendsRecord record);
	
	
	public List selectFriendsNews(String unionid);
}
