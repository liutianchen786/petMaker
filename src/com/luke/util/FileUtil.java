package com.luke.util;

import java.io.File;
import java.util.List;

import com.luke.util.ResultBean.Result;

public class FileUtil {

	
	/**
	 * 
	 * @Title: petMaker
	 * @Description: 删除服务器图片
	 * @author: ltc
	 * @date: 2018-6-29-下午5:30:50
	 * @Company: LuKe
	 */
	//https://www.lk818.com/petMaker/uploadimg/755c5472dfe74476834aa127cfcf290c.jpg,
	//https://www.lk818.com/petMaker/uploadimg/c3d86106f1e9493e8dc0be40db81cc2e.jpg
	public ResultBean FileDele(List<String> messImage,String realPath){
		ResultBean bean = new ResultBean(Result.SUCCESS);
		if(messImage!=null){
			for(String imageUrl:messImage){
				//截取uploadimg和.jpg中间的字符串
				String fileName=(imageUrl.substring(imageUrl.indexOf("uploadimg/") , imageUrl.length())).split("/")[1];
				File targetFile = new File(realPath,fileName);
				if(targetFile.exists()){
                    boolean isDelete = targetFile.delete();
                    if(!isDelete){
                    	bean = new ResultBean(Result.FAIL);
                    }
                }else{
                	bean = new ResultBean(Result.SUCCESS);
                }
			}
		}
		return bean;
	}
}
