package com.luke.service;

import java.util.List;
import java.util.Map;

import com.luke.model.AcceptTask;
import com.luke.util.ResultBean;

public interface IAcceptTaskService {
	
	public ResultBean insert(AcceptTask accepttask);
	
	public List<Map> selectByUnionid(String unionid);
}
