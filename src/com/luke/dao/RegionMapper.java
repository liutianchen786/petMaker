package com.luke.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.luke.model.Region;

public interface RegionMapper {
    int deleteByPrimaryKey(Integer regionid);

    int insert(Region record);

    int insertSelective(Region record);

    Region selectByPrimaryKey(Integer regionid);

    int updateByPrimaryKeySelective(Region record);

    int updateByPrimaryKey(Region record);
    
    int selectByUnionid(String openid);
    
    List<Region> selectNews();
    
    //查询用户附近十个信息
    @SuppressWarnings("rawtypes")
	List selectDistance(@Param("longitude") Double longitude,@Param("latitude") Double latitude,@Param("scale")Double scale);
    
    String selectAddress(String oid);
    
    int updateByUnionidSelective(Region region);
}