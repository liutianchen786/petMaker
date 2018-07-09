package com.luke.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.luke.model.UserChatRecord;

public interface UserChatRecordMapper {
    int deleteByPrimaryKey(Integer chatid);

    int insert(UserChatRecord record);

    int insertSelective(UserChatRecord record);

    UserChatRecord selectByPrimaryKey(Integer chatid);

    int updateByPrimaryKeySelective(UserChatRecord record);

    int updateByPrimaryKey(UserChatRecord record);
    
    List<Map> selectOneToOne(@Param("sendUnionId")String sendUnionid,@Param("toUnionId")String toUnionid);
    
    List<Map> selectChatMen(String sendUnionId);
    
    int updateChatState(@Param("sendUnionId")String sendUnionId,@Param("toUnionId")String toUnionId);
}