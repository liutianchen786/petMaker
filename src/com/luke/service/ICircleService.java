package com.luke.service;

import java.util.List;
import java.util.Map;

import com.luke.model.Circle;
import com.luke.model.UserCirclelikeRecord;
import com.luke.util.ResultBean;

public interface ICircleService {

	
	public ResultBean insertCircleiId(UserCirclelikeRecord uclRecord);
	
	
	public List<Map>  selectDetailCircle(Integer circleid,String unionId);
	
	public List<Map> selectAllcircled(String unionid,String cname);
	
	public List<Map> selectcircle(String unionid);
}
