package com.luke.service;

import java.util.List;

import com.luke.model.UserChatRecord;
import com.luke.util.ResultBean;


public interface IUserChatRecordService {
	
	public ResultBean insert(UserChatRecord ucRecord);
	
	public List selectOneToOne(String sendUnionId,String toUnionId);
	
	public List selectChatMen(String sendUnionId);
	
	public ResultBean updateChatState(String sendUnionId,String toUnionId);
}
