package com.luke.dao;

import java.util.List;
import java.util.Map;

import com.luke.model.AcceptTask;

public interface AcceptTaskMapper {
    int deleteByPrimaryKey(Integer aid);

    int insert(AcceptTask record);

    int insertSelective(AcceptTask record);

    AcceptTask selectByPrimaryKey(Integer aid);

    int updateByPrimaryKeySelective(AcceptTask record);

    int updateByPrimaryKey(AcceptTask record);
    
    List<Map> selectByUnionid(String unionid);
}