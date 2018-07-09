package com.luke.dao;

import java.util.List;

import com.luke.model.Replycomment;

public interface ReplycommentMapper {
    int deleteByPrimaryKey(Integer replyCommentid);

    int insert(Replycomment record);

    int insertSelective(Replycomment record);

    Replycomment selectByPrimaryKey(Integer replyCommentid);

    int updateByPrimaryKeySelective(Replycomment record);

    int updateByPrimaryKey(Replycomment record);
    
    @SuppressWarnings("rawtypes")
	List selectBycommid(Integer commid);
}