package com.luke.dao;

import com.luke.model.UserCircleRecord;

public interface UserCircleRecordMapper {
    int deleteByPrimaryKey(Integer userCircleRecordid);

    int insert(UserCircleRecord record);

    int insertSelective(UserCircleRecord record);

    UserCircleRecord selectByPrimaryKey(Integer userCircleRecordid);

    int updateByPrimaryKeySelective(UserCircleRecord record);

    int updateByPrimaryKey(UserCircleRecord record);
}