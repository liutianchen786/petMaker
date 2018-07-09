package com.luke.dao;

import java.util.List;
import java.util.Map;

import com.luke.model.ReleaseTask;

public interface ReleaseTaskMapper {
    int deleteByPrimaryKey(Integer aid);

    int insert(ReleaseTask record);

    int insertSelective(ReleaseTask record);

    ReleaseTask selectByPrimaryKey(Integer aid);

    int updateByPrimaryKeySelective(ReleaseTask record);

    int updateByPrimaryKey(ReleaseTask record);
    
    List<Map> selectAll();
}