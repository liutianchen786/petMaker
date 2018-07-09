package com.luke.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luke.dao.PetInfoMapper;
import com.luke.dao.PetTypeMapper;
import com.luke.dao.PetVaccineMapper;
import com.luke.model.PetInfo;
import com.luke.model.PetType;
import com.luke.model.PetVaccineRecord;
import com.luke.service.IPetInfoService;
import com.luke.util.ResultBean;
import com.luke.util.ResultBean.Result;
@Service("petInfoService")
public class PetInfoServiceImpl implements IPetInfoService{

	@Autowired
	private PetInfoMapper petMapper;
	@Autowired
	private PetTypeMapper petTypeMapper;
	@Autowired
	private PetVaccineMapper petVaccineMapper;
	
	
	@Override
	public ResultBean insertPetInfo(PetInfo pet) {
//		DecodeUTFUtil decodeUTFUtil = new DecodeUTFUtil();
		ResultBean bean = null;
		int row =0;
		int x= petMapper.updateByPrimaryKeySelective(pet);//如果该用户存在宠物，不能再次新增。
		if(x>0){
			bean = new ResultBean(Result.EXCEPTION);
		}
		else{
			row=petMapper.insertSelective(pet);
		}
		try{
//			decodeUTFUtil.ChangeDecode(pet);
			if(row>=1){
				bean = new ResultBean(Result.SUCCESS);
			}else {
				bean = new ResultBean(Result.FAIL);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public Map selectPetInfo(String unionid) {
		
		Map result = petMapper.selectPetInfo(unionid);
		return result;
	}

	/**
	 * 猫和狗的三级联动
	 */
	@Override
	public List<PetType> selectOneType() {
		List<PetType> res= petTypeMapper.selectOneType();
		List<PetType> top = new LinkedList<PetType>();
		//父节点
		for(int index = 0 ; index<res.size(); index++ ){
			if(res.get(index).getPettypepid()==0||res.get(index).getPettypepid().equals(0)){
				top.add(res.get(index));
			}
		}
		for (PetType petType : top) {
			petType.setChildTypes(petTypeRecursion(petType.getPettypeid(), res));
		}
		return top;
	}
	
	
	private List<PetType> petTypeRecursion(Integer id, List<PetType> res){
		List<PetType> childlList = new LinkedList<PetType>();
		//子节点
		for(int i=0;i<res.size();i++){
			if(res.get(i).getPettypepid().equals(id)){
				childlList.add(res.get(i));
			}
		}
		//子节点的子节点的子节点*N
		for (PetType petType : childlList) {
			petType.setChildTypes(petTypeRecursion(petType.getPettypeid(), res));
		}
		
		if(childlList.size()==0){
			return null;
		}
		return childlList ;
	}

	@Override
	public List selectVaccine() {
		List result = petVaccineMapper.selectVaccine();
		return result;
	}

	@Override
	public ResultBean updatePetInfo(PetInfo pet) {
		int row=petMapper.updateByPrimaryKeySelective(pet);
		ResultBean bean = null;
		try{
			if(row>=1){
				bean = new ResultBean(Result.SUCCESS);
			}else {
				bean = new ResultBean(Result.FAIL);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	/**
	 * 
	 * @Description:查询疫苗状态
	 * @author: ltc
	 * @date: 2018-6-1
	 * @Company: LuKe
	 */
	@Override
	public List<Map> selectPetVaccineState(String unionid) {
		
		return petVaccineMapper.selectPetVaccineState(unionid);
	}

	/**
	 * 
	 * @Description:插入宠物疫苗状态
	 * @author: ltc
	 * @date: 2018-6-4
	 * @Company: LuKe
	 */
	@Override
	public ResultBean insertPetVaccineState(List<PetVaccineRecord> maps,String unionid) {
		
		
		ResultBean bean = new ResultBean(Result.FAIL);
		try{
			bean =new ResultBean(Result.SUCCESS);
			petVaccineMapper.insertPetVaccineState(maps,unionid);
		}
		catch (Exception e) {
			bean =new ResultBean(Result.EXCEPTION);
		}
		
		return bean;
	}

	@Override
	public ResultBean updatePetVaccineState(List<PetVaccineRecord> map,
			String unionid) {
		ResultBean bean = new ResultBean(Result.FAIL);
		try{
			bean =new ResultBean(Result.SUCCESS);
			petVaccineMapper.updatePetVaccineState(map,unionid);
		}
		catch (Exception e) {
			bean =new ResultBean(Result.EXCEPTION);
		}
		
		return bean;
	}
}
