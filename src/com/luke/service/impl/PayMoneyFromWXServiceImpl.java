package com.luke.service.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.PUT;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.luke.service.IPayMoneyFromWXService;
import com.luke.util.FormatBizQueryParaMap;
import com.luke.util.HttpRequest;


@Service("payMoneyFromWXService")
public class PayMoneyFromWXServiceImpl implements IPayMoneyFromWXService{
	private static Logger logger = Logger.getLogger(PayMoneyFromWXServiceImpl.class);  
	//url 调用微信统一下单接口
	private final static String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	//微信分配的小程序ID
	private final static String appid = "wxd5fa2a6a8bfb5c89";
	//微信支付分配的商户号
	private final static String mch_id = "1500650811";
	//web端和微信端该参数都是统一的，为大写的”WEB“
	private final static String device_info = "WEB";
	//异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
	private final static String notify_url = "www.lk818.com";
	//小程序取值如下：JSAPI，详细说明见
	private final static	String trade_type	="JSAPI";
	//注：key为商户平台设置的密钥key
	private final static String key = "lukewangluoopop20170822636151111";

	
	
	@Override
	public Map pay(String openid, BigDecimal money,String body,String spbill_create_ip) {
		//商品简单描述，该字段请按照规范传递，具体请见参数规定
		//随机字符串，长度要求在32位以内。推荐随机数生成算法
		String nonce_str = UUID.randomUUID().toString().replaceAll("-", "").substring(0,32);
		//商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*且在同一个商户号下唯一。详见商户订单号
		String out_trade_no =UUID.randomUUID().toString().replaceAll("-", "").substring(0,32);
		//订单总金额，单位为分，详见支付金额
//		String total_fee = String.valueOf(money.multiply(new BigDecimal(Float.toString(100.00f))).floatValue());
		Map<String, String> map  = new HashMap<String, String>();
		map.put("appid",appid);
		map.put("openid",openid);
		map.put("nonce_str",nonce_str);
		map.put("out_trade_no",out_trade_no);
		map.put("total_fee",money.toString());
		map.put("mch_id",mch_id);
		map.put("device_info",device_info);
		map.put("notify_url",notify_url);
		map.put("trade_type",trade_type);
		map.put("spbill_create_ip",spbill_create_ip);
		map.put("body",body);
		try {
			//通过签名算法计算得出的签名值，详见签名生成算法
			String sign=getPayCustomSign(map,key);
			map.put("sign",sign);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			
			String xml= ArrayToXml(map);
			String result=HttpRequest.sendPost(url, xml);//返回success携带参数进行二次签名
			Map<String, String> resMap = new HashMap<String, String>();
			Map<String, String> returnMap = new HashMap<String, String>();
			resMap = xmlToMap(result);
								returnMap.put("appId",  appid);
								returnMap.put("timeStamp",  String.valueOf(Calendar.getInstance().getTimeInMillis()));
								returnMap.put("nonceStr", resMap.get("nonce_str"));
								returnMap.put("signType",	"MD5");
								returnMap.put("package", "prepay_id="+resMap.get("prepay_id"));
								String sign=getPayCustomSign(returnMap, key);
								returnMap.put("paySign",sign);
			resMap.put("timeStamp",  String.valueOf(Calendar.getInstance().getTimeInMillis()));
			String paySign=getPayCustomSign(resMap, key);
			resMap.put("paySign",paySign);
			return returnMap;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new HashMap<String,String>();
	}
	

	
    /**
     * XML格式字符串转换为Map
     *
     * @param strXML XML字符串
     * @return XML数据转换后的Map
     * @throws Exception
     */
    public static Map<String, String> xmlToMap(String strXML){
    	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    	String FEATURE = null;
    	Map<String, String> data = new HashMap<String, String>();
        try {
    		FEATURE = "http://apache.org/xml/features/disallow-doctype-decl";
			dbf.setFeature(FEATURE, true);
			FEATURE = "http://xml.org/sax/features/external-general-entities";
			dbf.setFeature(FEATURE, false);
			FEATURE = "http://xml.org/sax/features/external-parameter-entities";
			dbf.setFeature(FEATURE, false);
			FEATURE = "http://apache.org/xml/features/nonvalidating/load-external-dtd";
			dbf.setFeature(FEATURE, false);
			dbf.setXIncludeAware(false);
			dbf.setExpandEntityReferences(false);
			DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            InputStream stream = new ByteArrayInputStream(strXML.getBytes("UTF-8"));
            org.w3c.dom.Document doc = documentBuilder.parse(stream);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getDocumentElement().getChildNodes();
            for (int idx = 0; idx < nodeList.getLength(); ++idx) {
                Node node = nodeList.item(idx);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    org.w3c.dom.Element element = (org.w3c.dom.Element) node;
                    data.put(element.getNodeName(), element.getTextContent());
                }
            }
            try {
                stream.close();
            } catch (Exception ex) {
            	logger.error("Exception  stream is not close" );
            }
        } 
        catch (ParserConfigurationException e) {
        	// This should catch a failed setFeature feature
        	logger.info("ParserConfigurationException was thrown. The feature '" +
        	FEATURE + "' is probably not supported by your XML processor.");
        	}
          catch (SAXException e) {
        	// On Apache, this should be thrown when disallowing DOCTYPE
        	logger.warn("A DOCTYPE was passed into the XML document");
        	}
          catch (IOException e) {
        	// XXE that points to a file that doesn't exist
        	logger.error("IOException occurred, XXE may still possible: " + e.getMessage());
        }
        return data;
    }
	//转为XML格式
    public static String ArrayToXml(Map<String, String> arr) {
        String xml = "<xml>";
        Iterator<Entry<String, String>> iter = arr.entrySet().iterator();
        while (iter.hasNext()) {
            Entry<String, String> entry = iter.next();
            String key = entry.getKey();
            String val = entry.getValue();
            if (IsNumeric(val)) {
                xml += "<" + key + ">" + val + "</" + key + ">";
            } else
                xml += "<" + key + "><![CDATA[" + val + "]]></" + key + ">";
        }
        xml += "</xml>";
        return xml;
    }

    public static boolean IsNumeric(String str) {
        if (str.matches("\\d *")) {
            return true;
        } else {
            return false;
        }
    }
    
	/**
     * 获取支付所需签名
     * @param ticket
     * @param timeStamp
     * @param card_id
     * @param code
     * @return
     * @throws Exception
     */
    public static String getPayCustomSign(Map<String, String> bizObj,String key) throws Exception {
        String bizString = FormatBizQueryParaMap.FormatBizQueryParaMap(bizObj, false);
        return sign(bizString, key);
    }
    //支付所需签名处调用此方法
    public static String sign(String content, String key)
            throws Exception{
        String signStr = "";
        signStr = content + "&key=" + key;
        return MD5(signStr).toUpperCase();
    }
	public final static String MD5(String key) {
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        try {
            byte[] btInput = key.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }
	
}
