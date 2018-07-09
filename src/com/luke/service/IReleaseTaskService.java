package com.luke.service;

import java.util.List;
import java.util.Map;

import com.luke.model.ReleaseTask;
import com.luke.util.ResultBean;

public interface IReleaseTaskService {
	
	public ResultBean insert(ReleaseTask releasetask);
	
	public List<Map> selectAll();
}
