package com.luke.util;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.imageio.ImageIO;

public class  DealUserImageToCircle {
	//添加测试数据
//	public static void main(String[] args) {
//		DealUserImageToCircle circle  =new DealUserImageToCircle();
//		for(int i=1;i<21;i++){
//			circle.start("http://localhost:8080/images/randomData/avatarUrl/"+i+".png", 
//					"D:\\apache-tomcat-8.5.30-windows-x64\\apache-tomcat-8.5.30\\webapps\\images\\randomData\\a2",String.valueOf(i));
//		}
////		circle.start("http://localhost:8080/petMaker/uploadimg/1.png", "D:\\apache-tomcat-8.5.30-windows-x64\\apache-tomcat-8.5.30\\webapps\\petMaker\\uploadimg", "6a9e2de9-78ee-11e8-85e0-5254005c22c2");
//	}
//	
	/**
	 * 
	 * @Title: petMaker
	 * @Description: u头像地址 realPath是服务器真实路径(新头像存放的地址),unionid是图片的名称
	 * @author: ltc
	 * @date: 2018-7-2-下午5:39:33
	 * @Company: LuKe
	 */
	 public  String start(String u ,String realPath, String Unionid) {  
		 String imagePath = "";  
	        try {  
//	    		u = "https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIyFVlQJgP8zsv9oQAHozFeOZHicDD1EIg6GLOkAOh5UgTPTOTVTWeLAibS74wbNSalvgt5euLEakcQ/132";
	            // 是头像地址  
	            // 获取图片的流  
	             BufferedImage url =  getUrlByBufferedImage(u);  
	             BufferedImage backgroundImage = ImageIO.read(new FileInputStream(realPath+"/location.png"));  
//	          Image src = ImageIO.read(new File("C:/Users/Administrator/Desktop/Imag.png"));  
//	          BufferedImage url = (BufferedImage) src;  
	            // 处理图片将其压缩成正方形的小图  
	            BufferedImage convertImage = scaleByPercentage(url, 132, 132);  
	            // 裁剪成圆形 （传入的图像必须是正方形的 才会 圆形 如果是长方形的比例则会变成椭圆的）  
	            convertImage = convertCircular(convertImage);  
	            //合并两张图片
	            BufferedImage tag = synthetic(convertImage,backgroundImage); 
	            //圆角
	          //  BufferedImage image = makeRoundedCorner(convertImage,10);
	            // 生成的图片位置  
	            imagePath= returnPath(tag, realPath,Unionid);
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return imagePath;
	    }  
	 
	 //合成图片方法
	 public BufferedImage synthetic (BufferedImage convertImage,BufferedImage backgroundImage){
		 int bkwidth = backgroundImage.getWidth();
		 int bkheight = backgroundImage.getHeight();
		 int ciwidth = convertImage.getWidth();
		 int ciheight = convertImage.getHeight();
		 BufferedImage tag= new BufferedImage(bkwidth,bkheight,BufferedImage.TYPE_INT_ARGB);
		 Graphics2D g = tag.createGraphics();  
		 g.drawImage(backgroundImage, 0, 0, bkwidth,bkheight, null);
		 g.drawImage(convertImage, (bkwidth-ciwidth)/2, (bkheight-ciheight)/2-20, ciwidth,ciheight, null);
	     g.dispose();  
		 return tag;
	 }
	 
	 
	 //把图片上传到服务器上  返回路径
	 public String returnPath(BufferedImage image ,String realPath, String unionid) throws IOException{
		 String name = unionid +".png";
		 String imagePath = realPath+"/"+name;
 		ImageIO.write(image, imagePath.substring(imagePath.lastIndexOf(".") + 1), new File(imagePath));
		 return name;
	 }
	    /** 
	     * 缩小Image，此方法返回源图像按给定宽度、高度限制下缩放后的图像 
	     *  
	     * @param inputImage 
	     * @param maxWidth 
	     *            ：压缩后宽度 
	     * @param maxHeight 
	     *            ：压缩后高度 
	     * @throws java.io.IOException 
	     *             return 
	     */  
	     public static BufferedImage scaleByPercentage(BufferedImage inputImage, int newWidth, int newHeight) throws Exception {  
	        // 获取原始图像透明度类型  
	        int type = inputImage.getColorModel().getTransparency();  
	        int width = inputImage.getWidth();  
	        int height = inputImage.getHeight();  
	        // 开启抗锯齿  
	        RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);  
	        // 使用高质量压缩  
	        renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);  
	        BufferedImage img = new BufferedImage(newWidth, newHeight, type);  
	        Graphics2D graphics2d = img.createGraphics();  
	        graphics2d.setRenderingHints(renderingHints);  
	        graphics2d.drawImage(inputImage, 0, 0, newWidth, newHeight, 0, 0, width, height, null);  
	        graphics2d.dispose();  
	        return img;  
	    }  
	  
	    /** 
	     * 通过网络获取图片 
	     *  
	     * @param url 
	     * @return 
	     */  
	    public static BufferedImage getUrlByBufferedImage(String url) {  
	        try {  
	            URL urlObj = new URL(url);  
	            HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();  
	            // 连接超时  
	            conn.setDoInput(true);  
	            conn.setDoOutput(true);  
	            conn.setConnectTimeout(25000);  
	            // 读取超时 --服务器响应比较慢,增大时间  
	            conn.setReadTimeout(25000);  
	            conn.setRequestMethod("GET");  
	            conn.addRequestProperty("Accept-Language", "zh-cn");  
	            conn.addRequestProperty("Content-type", "image/jpeg");  
	            conn.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; .NET CLR 2.0.50727)");  
	            conn.connect();  
	            BufferedImage bufImg = ImageIO.read(conn.getInputStream());  
	            conn.disconnect();  
	            return bufImg;  
	        } catch (MalformedURLException e) {  
	            e.printStackTrace();  
	        } catch (ProtocolException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	        return null;  
	    }  
	 
	    /** 
	     * 传入的图像必须是正方形的 才会 圆形 如果是长方形的比例则会变成椭圆的 
	     *  
	     * @param url 
	     *            用户头像地址 
	     * @return 
	     * @throws IOException 
	     */  
	    public static BufferedImage convertCircular(BufferedImage bi1) throws IOException {  
	          
//	      BufferedImage bi1 = ImageIO.read(new File(url));  
	          
	        // 这种是黑色底的  
//	      BufferedImage bi2 = new BufferedImage(bi1.getWidth(), bi1.getHeight(), BufferedImage.TYPE_INT_RGB);  
	  
	        // 透明底的图片  
	        BufferedImage bi2 = new BufferedImage(bi1.getWidth(), bi1.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);  
	        Ellipse2D.Double shape = new Ellipse2D.Double(0, 0, bi1.getWidth(), bi1.getHeight());  
	        Graphics2D g2 = bi2.createGraphics();  
	        g2.setClip(shape);  
	        // 使用 setRenderingHint 设置抗锯齿  
	        g2.drawImage(bi1, 0, 0, null);  
	        // 设置颜色  
	        g2.setBackground(Color.green); 
	        //画边框
	        g2.dispose();  
	        return bi2;  
	    }  
	    
	    /** 
	     * 生成圆角图标 
	     * @author Master.Pan 
	     * @date 2016年5月11日 上午9:56:37 
	     * @param image 
	     * @param cornerRadius 圆角半径 
	     * @return 
	     */  
	    public static BufferedImage makeRoundedCorner(BufferedImage image, int cornerRadius) {  
	        int w = image.getWidth();  
	        int h = image.getHeight();  
	        BufferedImage output = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);  
	        Graphics2D g2 = output.createGraphics();  
	        g2.setComposite(AlphaComposite.Src);  
	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);  
	        g2.setColor(Color.WHITE);  
	        g2.fill(new RoundRectangle2D.Float(0, 0, w, h, cornerRadius, cornerRadius));  
	        g2.setComposite(AlphaComposite.SrcAtop);  
	        g2.drawImage(image, 0, 0, null);  
	        g2.dispose();  
	        return output;  
	    }  

}
