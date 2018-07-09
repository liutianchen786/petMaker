package com.luke.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luke.dao.CircleMapper;
import com.luke.dao.UserCirclelikeRecordMapper;
import com.luke.model.UserCirclelikeRecord;
import com.luke.service.ICircleService;
import com.luke.util.ResultBean;

@Service("circleService")
public class CircleServiceImpl implements ICircleService{
	
	@Autowired
	private CircleMapper cMapper;
	
	@Autowired
	private UserCirclelikeRecordMapper uCirclelikeRecordMapper;
	
	public ResultBean insertCircleiId(UserCirclelikeRecord uclRecord){
		ResultBean bean = null;
		if(uclRecord.getIsLike().equals("0")){
			uclRecord.setIsLike("1");//点击关注还要给circleId的圈子关注人数+1 和今日关注人数+1
			cMapper.insertCircleLike(uclRecord);
			cMapper.updateCircleCount(uclRecord.getCircleId());
		}
		else{
			if(uclRecord.getIsLike().equals("1")){
				uclRecord.setIsLike("2");
			}
			else{
				uclRecord.setIsLike("1");
			}
			cMapper.updateCircleLike(uclRecord);
		}
		
		return bean;
	}



	@Override
	public List<Map>  selectDetailCircle(Integer circleid,String unionId) {
		List<Map> result = cMapper.selectDetailCircle(circleid,unionId);
		return result;
	}

	/**
	 * 
	 * @Description:圈子表和圈子关注表关联 
	 * @author: ltc
	 * @date: 2018-5-28
	 * @Company: LuKe
	 */
	@Override
	public List<Map> selectAllcircled(String unionid,String cname) {
		List<Map> result = cMapper.selectAllcircled(unionid,cname);
		return result;
	}


	@Override
	public List<Map> selectcircle(String unionid) {
		// TODO Auto-generated method stub
		List<Map> list = uCirclelikeRecordMapper.selectcircle(unionid);
		return list;
	}
}
