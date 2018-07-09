package com.luke.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import com.luke.model.Message;
import com.luke.util.ResultBean;

public interface IMessageService {

	
	public ResultBean insert (Message message);
	public List<Map> selectByKey(Integer id);
	public ResultBean delete(Integer id, List<String> result, String realPath);
	public String upload(MultipartFile file,String realPath);
	List<Map> findAll(Integer pageNum, String unionId, String masterUnionId,
			Integer circleId,Integer messid, Integer messState);
	
	public List<Map> selectPublished(String unionid);
	
//	public ResultBean updateZfflag(Integer messid);
	
	public List<Map<String, Object>> selectHot(String unionId);
	public List<Map<String, Object>> selectNews(String unionid);
	public ResultBean addCount(Message message);
	public List<Map> selectCircleOrCenter(String unionId, String masterUnionId,
			String circleId);
	
	public List<Map> queryLikeCom(String unionId);
	//近期缓存
	public List<Map> watchedHistory(String browseData);
}
