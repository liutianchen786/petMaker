package com.luke.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

/**
 * 
 * @Title: GetEachDir
 * @Description:获取路径下所有图片,修改成132*132
 * @author: ltc
 * @date: 2018-7-2
 * @Company: LuKe
 */
public class GetEachDir {
	 public static void main(String[] args) {
	        // 遍历文件的路径
		 	String path = "D:\\apache-tomcat-8.5.30-windows-x64\\apache-tomcat-8.5.30\\webapps\\images\\randomData\\headimage";
		 	// 上传文件的路径
		 	String returnPath = "D:\\apache-tomcat-8.5.30-windows-x64\\apache-tomcat-8.5.30\\webapps\\images\\randomData\\avatarUrl";
	        File mFile = new File(path);
	        DealUserImageToCircle circle  = new DealUserImageToCircle();
	        int i=20;
	        if (mFile.exists() && mFile.isDirectory()) {
	            List<File> mlist = new ArrayList<File>();
	            //开始遍历文件
	            getAllFile(mFile, mlist);
	            // 已经获取了所有图片
	            for (File file2 : mlist) {
	                try {
						BufferedImage bufferedImage = ImageIO.read(new FileInputStream(file2.getAbsolutePath()));
						BufferedImage convertImage = circle.scaleByPercentage(bufferedImage, 132, 132);
						circle.returnPath(convertImage,returnPath,String.valueOf(++i));
					} catch (Exception e) {
						e.printStackTrace();
					}  
	            }
	        }
	    }

	    private static void getAllFile(File mFile, List<File> mlist) {
	        // 1.获取子目录
	        File[] files = mFile.listFiles();
	        // 2.判断files是否是空的 否则程序崩溃
	        if (files != null) {

	            for (File file : files) {
	                if (file.isDirectory()) {
	                    getAllFile(file, mlist);//调用递归的方式
	                } else {
	                    // 4. 添加到集合中去
	                    String fileName = file.getName();
	                    if (fileName.endsWith(".jpg") || fileName.endsWith(".png")
	                            || fileName.endsWith(".gif")) {
	                        mlist.add(file);//如果是这几种图片格式就添加进去
	                    }
	                }
	            }
	        }
	    }

}

