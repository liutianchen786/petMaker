package com.luke.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.luke.model.User;

public interface UserTaskMapper {


	//插入用户任务表
    int insertTask(@Param("unionid")String unionid);

    int updateCompleteTsk(@Param("unionid")String unionid, @Param("taskTypeId")int taskTypeId);

	List<Map> selectUserTask(String unionid);

	void updateUserTask();

	void updateUserSign(String unionid, String taskName);

	void updateUserAndTask(User user);

	Map selectUserSignDay(@Param("unionid")String unionid);
}