package com.luke.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 
 * @Title: DecodeUTFUtil
 * @Description:利用反射解决编码问题 
 * @author: ltc
 * @date: 2018-5-10
 * @Company: LuKe
 */
public class DecodeUTFUtil {

/**
 * 
 * @Title: petMaker
 * @Description:  实体类方法
 * @author: ltc
 * @date: 2018-5-10-下午4:43:40
 * @Company: LuKe
 */
	public void  ChangeDecode(Object model)throws NoSuchMethodException,  
    IllegalAccessException, IllegalArgumentException,  InvocationTargetException, UnsupportedEncodingException {

        // 获取实体类的所有属性，返回Field数组  
        Field[] field = model.getClass().getDeclaredFields();  
        // 遍历所有属性  
        for (int j = 0; j < field.length; j++) {
        		//private 私有方法处理
        		field[j].setAccessible(true);  
                // 获取属性的名字  
                String name = field[j].getName();  
                // 将属性的首字符大写，方便构造get，set方法  
                name = name.substring(0, 1).toUpperCase() + name.substring(1);  
                // 获取属性的类型  
                String type = field[j].getGenericType().toString();  
                // 如果type是类类型，则前面包含"class "，后面跟类名  
				                if (type.equals("class java.lang.String")) {  
				                        Method m = model.getClass().getMethod("get" + name);  
				                        // 调用getter方法获取属性值  
				                        String value = (String) m.invoke(model);  
				                        if (value != null) {  
				                        		field[j].set(model,new String(value.getBytes("ISO-8859-1"),"UTF-8"));
				                        } 
				                }  
        	}  
	}	
	/**
	 * 
	 * @Title: petMaker
	 * @Description: string类型转换
	 * @author: ltc
	 * @date: 2018-5-10-下午4:43:56
	 * @Company: LuKe
	 */
	public String  ChangeString(String e) throws UnsupportedEncodingException{
		return new String(e.getBytes("ISO-8859-1"),"UTF-8");
	}
	
	
	
}