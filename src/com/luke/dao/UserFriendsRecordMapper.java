package com.luke.dao;

import java.util.List;
import java.util.Map;

import com.luke.model.UserFriendsRecord;

public interface UserFriendsRecordMapper {
    int deleteByPrimaryKey(Integer userfriendsid);

    int insert(UserFriendsRecord record);

    int insertSelective(UserFriendsRecord record);


    int updateFlag(UserFriendsRecord userFriendsRecord);
    
    List<Map> selectFriendsNews(String unionid);
    
}