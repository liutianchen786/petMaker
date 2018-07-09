package com.luke.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.luke.model.Message;

public interface MessageMapper {
    int deleteByPrimaryKey(@Param("messid")Integer messid);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer messid);

    int updateCount(Message record);

	List<Map> selectAll(@Param("pageNum")Integer pageNum,@Param("pageNum2")Integer pageNum2,
			@Param("unionId")String unionId,@Param("masterUnionId")String masterUnionId,
			@Param("circleId")Integer circleId,@Param("messid")Integer messid,@Param("messState")Integer messState);
    
    @SuppressWarnings("rawtypes")
	List<Map> selectByKey(Integer id);
    
    List selectByIfclick();
    
    List<Map> selectPublished(String unionid);
    
//    int updateZfflag(Integer messid);

    List<Map<String, Object>> selectHot(@Param("unionId")String unionId);

	List<Map<String, Object>> selectNews(@Param("unionId")String unionId);

	List<Map> selectCircleOrCenter(@Param("unionId")String unionId, @Param("masterUnionId")String masterUnionId,
			@Param("circleId")String circleId);

	List<Map> watchedHistory(@Param("browseData")String browseData);
}