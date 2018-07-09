package com.luke.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.luke.model.GoodsTags;


public interface GoodsInfoMapper {

	List<Map> selectGoods(@Param("goodsTagsId") String goodsTagsId,@Param("goodsId") String goodsId);

	List<GoodsTags> selectAllTags();
	
	List<Map> selectViP();
}