package com.luke.dao;

import com.luke.model.USignrecord;

public interface USignrecordMapper {
    int deleteByPrimaryKey(Integer signid);

    int insert(USignrecord record);

    int insertSelective(USignrecord record);

    USignrecord selectByPrimaryKey(Integer signid);

    int updateByPrimaryKeySelective(USignrecord record);

    int updateByPrimaryKey(USignrecord record);
}