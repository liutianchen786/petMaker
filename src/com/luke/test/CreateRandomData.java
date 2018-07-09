package com.luke.test;

import javax.servlet.http.HttpServletRequest;

import com.luke.util.DealUserImageToCircle;


/**
 * 
 * @Title: CreateRandomData
 * @Description:创建用户的原始数据
 * @author: ltc
 * @date: 2018-6-27
 * @Company: LuKe
 */

public  class CreateRandomData  {
	private Integer insertId=0;
	
	
	
	
	public void runStart(HttpServletRequest req) {
			//将用户头像和背景圆合并并且上传到服务器
			//用户头像地址 在服务器的petmaker uploadimg下面
			//"D:\\apache-tomcat-8.5.30-windows-x64\\apache-tomcat-8.5.30\\webapps\\petMaker\\uploadimg"
			String realPath = req.getSession().getServletContext().getRealPath("uploadimg");
			StringBuffer concatPath = new StringBuffer();
			DealUserImageToCircle duITCircle = new DealUserImageToCircle();
			for(int i=insertId;i<insertId+10;i++){
				String path=duITCircle.start("http://localhost:8080/images/randomData/headimage/"+insertId+".jpg"
						,"D:\\apache-tomcat-8.5.30-windows-x64\\apache-tomcat-8.5.30\\webapps\\petMaker\\uploadimg"
						,String.valueOf(insertId));
				concatPath.append(path).append(",");
			}
			concatPath.deleteCharAt(concatPath.length()-1);//多了一个,删除它
			//调用存储过程 对应
	}
}

