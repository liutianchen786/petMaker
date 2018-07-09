package com.luke.service;

import java.util.List;
import java.util.Map;

import com.luke.model.GoodsTags;

public interface IGoodsService {

	List<Map> selectGoods(String goodsTagsId, String goodsId);

	List<GoodsTags> selectAllTags();
	
	List<Map> selectViP();
}
