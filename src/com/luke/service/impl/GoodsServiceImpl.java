package com.luke.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luke.dao.GoodsInfoMapper;
import com.luke.model.GoodsTags;
import com.luke.service.IGoodsService;


@Service("goodsServiceImpl")
public class GoodsServiceImpl implements IGoodsService{

	@Autowired
	private GoodsInfoMapper goodsInfoMapper;
	
	@Override
	public List<Map> selectGoods(String goodsTagsId,String goodsId) {
		return goodsInfoMapper.selectGoods(goodsTagsId,goodsId);
	}

	@Override
	public List<GoodsTags> selectAllTags() {
		return goodsInfoMapper.selectAllTags();
	}

	@Override
	public List<Map> selectViP() {
		
		return goodsInfoMapper.selectViP();
	}

}
