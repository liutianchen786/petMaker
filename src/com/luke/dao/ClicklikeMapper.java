package com.luke.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.luke.model.Clicklike;

public interface ClicklikeMapper {


    int insertSelective(Clicklike record);

    
    List selectIfClick(Integer mid);


	List<Map> queryClicklike(@Param("unionId")String unionId);
	List<Map> queryComments(@Param("unionId")String unionId);

	void insertNotify(@Param("unionId")String unionId,@Param("ExitTime")Timestamp ExitTime);


	int updaterow(Clicklike clike);
	
	List<Map> queryNotice(String unionId);
	
	List<Map> queryLikeCom(@Param("unionId")String unionId);
}