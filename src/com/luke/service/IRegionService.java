package com.luke.service;

import java.util.List;

import com.luke.model.Region;
import com.luke.util.ResultBean;

public interface IRegionService {

	public ResultBean insert(Region region);
	
	public List<Region> selectNews();
	

	public List queryNearByUser(Region region, String url, String string, String flag);
}
