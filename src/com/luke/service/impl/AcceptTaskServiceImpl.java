package com.luke.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luke.dao.AcceptTaskMapper;
import com.luke.model.AcceptTask;
import com.luke.service.IAcceptTaskService;
import com.luke.util.ResultBean;
import com.luke.util.ResultBean.Result;

@Service("acceptTaskService")
public class AcceptTaskServiceImpl implements IAcceptTaskService{

	@Autowired
	private AcceptTaskMapper mapper;

	@Override
	public ResultBean insert(AcceptTask accepttask) {
		ResultBean bean = null;
		try {
			int row = mapper.insertSelective(accepttask);
			if(row>=1){
				bean = new ResultBean(Result.SUCCESS);
			}else {
				bean = new ResultBean(Result.FAIL);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			bean = new ResultBean(Result.EXCEPTION);
		}
		return bean;
	}

	@Override
	public List<Map> selectByUnionid(String unionid) {
		// TODO Auto-generated method stub
		List<Map> list = mapper.selectByUnionid(unionid);
		return list;
	}
	
}
