package com.luke.dao;

import java.util.List;
import java.util.Map;

import com.luke.model.PetInfo;

public interface PetInfoMapper {


    int insertSelective(PetInfo record);

    int updateByPrimaryKeySelective(PetInfo record);

    Map selectPetInfo(String unionid);

}