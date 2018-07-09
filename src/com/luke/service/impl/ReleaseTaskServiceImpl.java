package com.luke.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luke.dao.ReleaseTaskMapper;
import com.luke.model.ReleaseTask;
import com.luke.service.IReleaseTaskService;
import com.luke.util.ResultBean;
import com.luke.util.ResultBean.Result;

@Service("releaseTaskService")
public class ReleaseTaskServiceImpl implements IReleaseTaskService {

	@Autowired
	private ReleaseTaskMapper mapper;
	
	@Override
	public ResultBean insert(ReleaseTask releasetask) {
		ResultBean bean = null;
		try {
			int row  = mapper.insertSelective(releasetask);
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
	public List<Map> selectAll() {
		// TODO Auto-generated method stub
		List<Map> list = mapper.selectAll();
		return list;
	}

}
