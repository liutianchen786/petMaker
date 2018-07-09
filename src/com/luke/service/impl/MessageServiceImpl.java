package com.luke.service.impl;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.luke.dao.ClicklikeMapper;
import com.luke.dao.MessageMapper;
import com.luke.model.Message;
import com.luke.service.IMessageService;
import com.luke.util.FileUtil;
import com.luke.util.ResultBean;
import com.luke.util.ResultBean.Result;


@Service("MessageService")
public class MessageServiceImpl implements IMessageService{

	@Autowired
	private MessageMapper mapper;
	
	@Autowired
	private ClicklikeMapper likeMapper;
	
	private Logger logger = Logger.getLogger(MessageServiceImpl.class);
	@Override
	public ResultBean insert(Message message) {
		ResultBean bean=null;
		/*String mString = null;
		
		try {
			mString = URLEncoder.encode(message.getMessdesc(), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("编码错误:"+e.getMessage());
			bean = new ResultBean(Result.FAIL);
		}
		message.setMessdesc(mString);*/
		int row = mapper.insertSelective(message);
		if(row>=1){
			bean = new ResultBean(Result.SUCCESS);
		}else {
			bean = new ResultBean(Result.FAIL);
		}
		return bean;
	}

	@Override
	public List<Map> findAll(Integer pageNum,String unionId,String masterUnionId,Integer circleId,Integer messid,Integer messState) {
		List<Map> list=  mapper.selectAll(pageNum==-1?-1:pageNum*10,10,unionId,masterUnionId,circleId,messid,messState);
		for (Map map : list) {
			map.put("messDesc", getDecodeUrl(map.get("messDesc").toString()));
		}
		return list;
	}

	private String getDecodeUrl(String msg){
		try {
			return URLDecoder.decode(msg, "UTF-8");
		} catch (Exception e) {
			return msg;
		}
	}
	
	@Override
	public List<Map> selectByKey(Integer id) {
		List<Map> list=  mapper.selectByKey(id);		
		return list;
	}

	/**
	 * 
	 * @Description:讲该message以及该message下的作废标记更改为1
	 * @author: ltc
	 * @date: 2018-6-5
	 * @Company: LuKe
	 */
	@Override
	public ResultBean delete(Integer id,List<String> messImage,String realPath) {
		ResultBean bean = null;
		FileUtil file = new FileUtil();
		bean = file.FileDele(messImage,realPath);//删除服务器图片
		int row = mapper.deleteByPrimaryKey(id);
		if(row>=1&&bean.getCode().equals("10000")){
			bean = new ResultBean(Result.SUCCESS);
		}else {
			bean = new ResultBean(Result.FAIL);
		}
		return bean;
	}
	
	

	@Override
	public String upload(MultipartFile file,String realPath)  {
		//获取上传的图片的名称
		String filename = file.getOriginalFilename();
//		System.out.println(filename);

    	//判断文件存不存在
    	File file1 = new File(realPath);     	
    	if (!file1.exists()) {  
			file1.mkdir();
		}
    	//取出文件后缀
    	String ext = FilenameUtils.getExtension(filename);
    	//用UUID生成随机数将.去掉
    	String image= UUID.randomUUID().toString()+"."+ext;
    	//将“-”去掉
    	image=image.replace("-", "");
		try {
			file.transferTo(new File(realPath,image));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
    	return image;
    	}

	@Override
	public List<Map> selectPublished(String unionid) {
		// TODO Auto-generated method stub
		List<Map> list = mapper.selectPublished(unionid);
		
		return list;
	}

//	@Override
//	public ResultBean updateZfflag(Integer messid) {
//		// TODO Auto-generated method stub
//		ResultBean bean = null;
//		int row = mapper.updateZfflag(messid);
//		if(row>=1){
//			bean = new ResultBean(Result.SUCCESS);
//		}else {
//			bean = new ResultBean(Result.FAIL);
//		}
//		return bean;
//	}

	@Override
	public List<Map<String,Object>>selectHot(String unionId) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> list = mapper.selectHot(unionId);
		return list;
	}

	/**
	 * 
	 * @Description:查找最新话题
	 * @author: ltc
	 * @date: 2018-6-6
	 * @Company: LuKe
	 */
	@Override
	public List<Map<String,Object>> selectNews(String unionid) {
		
		return  mapper.selectNews(unionid);
	}

	/**
	 * 
	 * @Description:添加阅读数量
	 * @author: ltc
	 * @date: 2018-6-7
	 * @Company: LuKe
	 */
	@Override
	public ResultBean addCount(Message message) {
		ResultBean bean=null;
		int row = mapper.updateCount(message);
		if(row>=1){
			bean = new ResultBean(Result.SUCCESS);
		}
		else{
			bean = new ResultBean(Result.FAIL);
		}
		return bean;
	}

	
	@Override
	public List<Map> selectCircleOrCenter(String unionId, String masterUnionId,
			String circleId) {
		return mapper.selectCircleOrCenter(unionId,masterUnionId,circleId);
	}

	@Override
	public List<Map> queryLikeCom(String unionId) {
		// TODO Auto-generated method stub
		return likeMapper.queryLikeCom(unionId);
	}

	/**
	 * 
	 * @Description:浏览记录
	 * @author: ltc
	 * @date: 2018-7-6
	 * @Company: LuKe
	 */
	@Override
	public List<Map> watchedHistory(String browseData) {
		return mapper.watchedHistory(browseData);
	}

}
