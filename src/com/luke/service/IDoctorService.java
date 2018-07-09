package com.luke.service;

import java.util.List;

import com.luke.model.UserDoctorInfo;
import com.luke.util.ResultBean;

public interface IDoctorService {

	List<UserDoctorInfo> queryDocInfo();


	ResultBean likeDoc(String userDtcId);

	ResultBean insertRecord(String userDtcId, String userUnionId);

}
