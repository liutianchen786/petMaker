package com.luke.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.luke.model.PetVaccine;
import com.luke.model.PetVaccineRecord;

public interface PetVaccineMapper {

    int insertSelective(PetVaccine record);

	List selectVaccine();

	List<Map> selectPetVaccineState(String unionid);

	void insertPetVaccineState(@Param("list")List<PetVaccineRecord> list, @Param("unionid") String unionid);

	void updatePetVaccineState(@Param("list")List<PetVaccineRecord> list, @Param("unionid") String unionid);
}