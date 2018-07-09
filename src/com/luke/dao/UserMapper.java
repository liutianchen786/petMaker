package com.luke.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.luke.model.ChRegion;
import com.luke.model.User;
import com.luke.model.UserDileveryInfo;
import com.luke.model.UserGoodsOrderRecord;

public interface UserMapper {

    int insert(User record);

    int insertSelective(User record);

    int updateByPrimaryKeySelective(User record);
    	
    int updateByPrimaryKey(User record);

	User selectByOpenId(@Param("openid")String openid);
	
	User selectByUnionidToMap(String unionid);
	

	Map selectPetAndPerson(@Param("unionId")String unionid, @Param("friendsUnionId")String friendsUnionId);

	List<UserDileveryInfo> selectAddress(@Param("unionid")String unionid,@Param("deliveryAddressId")Integer deliveryAddressId);

	int insertAddress(UserDileveryInfo user);

	int updateAddress(UserDileveryInfo user);

	int updateIsdeafult(@Param("deliveryAddressId")Integer deliveryAddressId,@Param("uninoId")String unionid);

	List<ChRegion> selectChRegion();

	void insertGoodsRecord(UserGoodsOrderRecord ugOrderRecord);

	List<Map<String, Object>> querybkgd();


}