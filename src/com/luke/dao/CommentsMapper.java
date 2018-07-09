package com.luke.dao;

import java.util.List;

import com.luke.model.Comments;

public interface CommentsMapper {
    int deleteByPrimaryKey(Integer commid);

    int insert(Comments record);

    int insertSelective(Comments record);

    Comments selectByPrimaryKey(Integer commid);

    int updateByPrimaryKeySelective(Comments record);

    int updateByPrimaryKey(Comments record);
    ;
    List selectReplyContat (Integer mid);
    List selectByMid(Integer commid);
    
    List selectreply(Integer mid);
    
    List selectCommid(Integer mid);
    
    List selectPid(Integer pid);
}