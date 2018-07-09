package com.luke.dao;

import com.luke.model.RedEnvelope;

public interface RedEnvelopeMapper {
    int deleteByPrimaryKey(Integer eid);

    int insert(RedEnvelope record);

    int insertSelective(RedEnvelope record);

    RedEnvelope selectByPrimaryKey(Integer eid);

    int updateByPrimaryKeySelective(RedEnvelope record);

    int updateByPrimaryKey(RedEnvelope record);
}