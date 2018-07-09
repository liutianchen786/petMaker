package com.luke.service;

import java.util.List;
import java.util.Map;

import com.luke.model.PetInfo;
import com.luke.model.PetType;
import com.luke.model.PetVaccineRecord;
import com.luke.util.ResultBean;

public interface IPetInfoService {
	
	
	public ResultBean insertPetInfo(PetInfo pet);

	public Map selectPetInfo(String unionid);

	public List<PetType> selectOneType();

	public List selectVaccine();

	public ResultBean updatePetInfo(PetInfo pet);

	public List<Map> selectPetVaccineState(String unionid);

	public ResultBean insertPetVaccineState(List<PetVaccineRecord> map,String unionid);

	public ResultBean updatePetVaccineState(List<PetVaccineRecord> map,
			String unionid);

}
