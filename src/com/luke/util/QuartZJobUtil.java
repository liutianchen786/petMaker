package com.luke.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luke.dao.UserMapper;
import com.luke.dao.UserTaskMapper;

/**
 * 定时任务  定时更新签到表
 * @author ltc
 *
 */
@Service("JobService")
public class QuartZJobUtil {

	@Autowired
	private   UserMapper uMapper;
	@Autowired
	private   UserTaskMapper userTaskMapper;
	
	public   void execute()throws Exception{
		try{
			//定时更新任务表
			userTaskMapper.updateUserTask();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
