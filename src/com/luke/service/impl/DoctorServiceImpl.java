package com.luke.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luke.dao.UserDoctorInfoMapper;
import com.luke.model.UserDoctorInfo;
import com.luke.service.IDoctorService;
import com.luke.util.ResultBean;
import com.luke.util.ResultBean.Result;

@Service("doctorServiceImpl")
public class DoctorServiceImpl implements IDoctorService{

	@Autowired
	private UserDoctorInfoMapper dmapper;
	
	@Override
	public List<UserDoctorInfo> queryDocInfo() {
		return dmapper.queryDocInfo();
	}
	
	/**
	 * 
	 * @Description:新增用户访问记录
	 * @author: ltc
	 * @date: 2018-6-25
	 * @Company: LuKe
	 */
	@Override
	public ResultBean insertRecord(String userDtcId,String userUnionId) {
		ResultBean bean = new ResultBean(Result.FAIL);
		dmapper.updateDocInfo(userDtcId,"userAmount");//给医生信息更新访问数
			try{
				int row =dmapper.insertRecord(userDtcId,userUnionId);//插入记录   ！！！！是否要插入重复记录呢 
				if(row>=1){
					bean = new ResultBean(Result.SUCCESS);
				}
			}catch(Exception e){
				bean = new ResultBean(Result.EXCEPTION);
			}
		return bean;
	}

	@Override
	public ResultBean likeDoc(String userDtcId) {
		ResultBean bean = new ResultBean(Result.FAIL);
		try{
			int row=dmapper.updateDocInfo(userDtcId,"userLikeAmount");//给医生信息更新点赞数
			if(row>=1){
				bean = new ResultBean(Result.SUCCESS);
			}
		}
		catch (Exception e) {
			bean = new ResultBean(Result.EXCEPTION);
		}
		return bean;
	}
}
 