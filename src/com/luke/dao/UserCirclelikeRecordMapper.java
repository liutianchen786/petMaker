package com.luke.dao;

import java.util.List;
import java.util.Map;

import com.luke.model.UserCirclelikeRecord;

public interface UserCirclelikeRecordMapper {
    int deleteByPrimaryKey(String usercirclerecordid);

    int insert(UserCirclelikeRecord record);

    int insertSelective(UserCirclelikeRecord record);

    UserCirclelikeRecord selectByPrimaryKey(String usercirclerecordid);

    int updateByPrimaryKeySelective(UserCirclelikeRecord record);

    int updateByPrimaryKey(UserCirclelikeRecord record);
    
    //该接口调用放在ICircleService底下
    List<Map> selectcircle(String unionId);
}