package com.luke.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.luke.model.Circle;
import com.luke.model.UserCirclelikeRecord;

public interface CircleMapper {
    
    void insertCircleLike(UserCirclelikeRecord uclrecord);
    
   List<Map> selectDetailCircle(@Param("circleId")Integer circleid,@Param("unionId")String unionId);
    
    void updateCircleCount(@Param("circleid")Integer circleid);

    List<Map> selectAllcircled(@Param("unionid")String  unionid,@Param("cname") String cname);
    
    List<Map> selectcircle(String unionid);

	void updateCircleLike(UserCirclelikeRecord uclRecord);
}