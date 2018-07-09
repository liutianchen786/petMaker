package com.luke.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.luke.model.UserDoctorInfo;

public interface UserDoctorInfoMapper {

	List<UserDoctorInfo> queryDocInfo();




	int updateDocInfo(@Param("userDtcId")String userDtcId,@Param("type")String type);


	int insertRecord(@Param("userDtcId")String userDtcId,@Param("userUnionId")String userUnionId);




	int updateDocInfo(UserDoctorInfo udInfo);

}
