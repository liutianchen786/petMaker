package com.luke.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luke.dao.RegionMapper;
import com.luke.model.Region;
import com.luke.service.IRegionService;
import com.luke.util.DealUserImageToCircle;
import com.luke.util.ResultBean;
import com.luke.util.ResultBean.Result;

@Service("RegionService")
public class RegionServiceImpl implements IRegionService{
	
	@Autowired
	private RegionMapper mapper;

	@Override
	public ResultBean insert(Region region) {
		ResultBean bean = null;
		int row = mapper.insertSelective(region);
		if(row>=1){
			bean = new ResultBean(Result.SUCCESS);
		}else {
			bean = new ResultBean(Result.FAIL);
		}
		return bean;
	}

	@Override
	public List selectNews() {
		// TODO Auto-generated method stub
		List<Region> list = mapper.selectNews();
		return list;
	}

	
	/**
	 * 
	 * @Description:用户首次登陆 在服务器上合并头像，再次登陆直接更新位置
	 * @author: ltc
	 * @date: 2018-6-14
	 * @Company: LuKe
	 */
	@Override
	public List queryNearByUser(Region region,String url,String realPath,String flag) {
		//更新定位表，如果有该用户信息 就更新 否则就新增  如果flag=1代表是地图移动位置，这个时候不需要给用户更新
		if(flag.equals("0")){
			int row = mapper.updateByUnionidSelective(region);
			if(row<1){
				DealUserImageToCircle duCircle  = new DealUserImageToCircle();
				String path = duCircle.start(url, realPath,region.getUnionid());
				region.setAvaCirImage(path);
				mapper.insertSelective(region);
			}			
		}
		//查找方圆5公里的用户
		List list = mapper.selectDistance(region.getLongitude(), region.getLatitude(),region.getScale());
		return list;
	}
	
	
}
