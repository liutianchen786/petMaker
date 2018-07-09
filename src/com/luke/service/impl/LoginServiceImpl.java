package com.luke.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luke.dao.UserMapper;
import com.luke.dao.UserTaskMapper;
import com.luke.model.User;
import com.luke.service.ILoginService;
import com.luke.util.AesCbcUtil;
import com.luke.util.HttpRequest;
import com.sun.org.apache.commons.logging.Log;
import com.sun.org.apache.commons.logging.LogFactory;


@Service("loginService")
public class LoginServiceImpl implements ILoginService{
	@Autowired
	private UserMapper mapper;

	@Autowired
	private UserTaskMapper taskMapper;
	private Log Logger = LogFactory.getLog(LoginServiceImpl.class);
	@Override
	public Map<String,Object> userLogin(String encryptedData, String iv, String code, User user) {
		String sex = null;
		Map<String,Object> map = new HashMap<String,Object>();
		// 登录凭证不能为空
		if (code == null || code.length() == 0) {
			map.put("status", 0);
			map.put("msg", "code 不能为空");
			return map;
		}
		// 小程序唯一标识 (在微信小程序管理后台获取)
		String wxspAppid = "wxd5fa2a6a8bfb5c89";
		// 小程序的 app secret (在微信小程序管理后台获取)
		String wxspSecret = "72527b632af433f59a6b6b9f2aed7565";
		// 授权（必填）
		String grant_type = "authorization_code";
		String grant_type1 = "client_credential";

		// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid
		// 请求参数
		String params = "appid=" + wxspAppid + "&secret=" + wxspSecret
				+ "&js_code=" + code + "&grant_type=" + grant_type;
		String tokenparams = "grant_type=" + grant_type1 + "&appid="
				+ wxspAppid + "&secret=" + wxspSecret;
//		 https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret+"
		// 发送请求
		String sr = HttpRequest.sendGet(
				"https://api.weixin.qq.com/sns/jscode2session", params);
		String str = HttpRequest.sendGet(
				"https://api.weixin.qq.com/cgi-bin/token", tokenparams);
//		// 解析相应内容（转换成json对象）
		JSONObject json = JSONObject.fromObject(sr);
		JSONObject jsonObj = JSONObject.fromObject(str);
		// 获取会话密钥（session_key）
		String session_key = (String) json.get("session_key");
		// 用户的唯一标识（openid）
		String openid = (String) json.get("openid");
		// 获取access_token
		String access_token = (String) jsonObj.get("access_token");
		// 请求unionid的参数
		String unionidparams = "access_token=" + access_token + "&openid="
				+ openid + "&lang=zh_CN";
//		 https://api.weixin.qq.com/cgi-bin/user/info?access_token="+getToken(appid, secret)+"&openid="+openid+"&lang=zh_CN
		// 发送请求
		String string = HttpRequest.sendGet(
				"https://api.weixin.qq.com/cgi-bin/user/info", unionidparams);
		// 解析相应内容
		JSONObject jsonObject = JSONObject.fromObject(string);

		// 2、对encryptedData加密数据进行AES解密
		try {
			String result = AesCbcUtil.decrypt(encryptedData, session_key, iv,
					"UTF-8");
			if (null != result && result.length() > 0) {
				map.put("status", 1);
				map.put("msg", "解密成功");

				JSONObject userInfoJSON = JSONObject.fromObject(result);
				//将gender转换成‘男’或‘女’
				if ((Integer) userInfoJSON.get("gender") == 1) {
					sex = "男";
				} else {
					sex = "女";
				}
				String unionid = (String) userInfoJSON.get("unionId");
				User userModel = mapper.selectByOpenId(openid);
				String unionids = userModel==null?null:userModel.getUnionid();
				Map<String,Object> userInfo = new HashMap<String,Object>();
				if (null == unionids || (!(unionids.equals(unionid)))) {
					
					userInfo.put("openId", userInfoJSON.get("openId"));
					userInfo.put("nickName", userInfoJSON.get("nickName"));
					userInfo.put("gender", sex);
					userInfo.put("city", userInfoJSON.get("city"));
					userInfo.put("province", userInfoJSON.get("province"));
					userInfo.put("country", userInfoJSON.get("country"));
					userInfo.put("avatarUrl", userInfoJSON.get("avatarUrl"));
					userInfo.put("unionId", userInfoJSON.get("unionId"));
					map.put("userInfo", userInfo);
					user.setOpenid((String) userInfo.get("openId"));
					user.setUnionid((String) userInfo.get("unionId"));
					user.setNickname((String) userInfo.get("nickName"));
					user.setAvatarurl((String) userInfo.get("avatarUrl"));
					user.setGender((String)userInfo.get("gender"));
					user.setCountry((String) userInfo.get("country"));
					user.setProvice((String) userInfo.get("province"));
					user.setCity((String) userInfo.get("city"));
					//注册给时间戳默认值，下次取不会为空
					Calendar endtime = Calendar.getInstance();
					Timestamp timestamp  = new Timestamp(endtime.getTime().getTime());
					user.setVipendtime(timestamp);
					user.setVipstarttime(timestamp);
					mapper.insertSelective(user);
					//第一次进入小程序，新建任务表
					taskMapper.insertTask(userInfo.get("unionId").toString());
				} else {
					userInfo.put("openId", userInfoJSON.get("openId"));
					userInfo.put("nickName", userInfoJSON.get("nickName"));
					userInfo.put("gender", sex);
					userInfo.put("city", userInfoJSON.get("city"));
					userInfo.put("province", userInfoJSON.get("province"));
					userInfo.put("country", userInfoJSON.get("country"));
					userInfo.put("avatarUrl", userInfoJSON.get("avatarUrl"));
					userInfo.put("unionId", userInfoJSON.get("unionId"));
					//更改昵称头像
					userModel.setNickname( userInfoJSON.get("nickName").toString());
					userModel.setAvatarurl( userInfoJSON.get("avatarUrl").toString());
					userModel.setThisweekmoney(new BigDecimal(0));
					userModel.setMoney(new BigDecimal(0));
					Calendar endtime = Calendar.getInstance();
					Calendar thistime = Calendar.getInstance();
//					//会员到期
					
					endtime.setTime(userModel.getVipendtime()==null?new Date():new Date(userModel.getVipendtime().getTime()));
					thistime.setTime(new Date());
					if(endtime.getTimeInMillis()>0&&endtime.getTimeInMillis()-thistime.getTimeInMillis()<=0){
						userModel.setState((byte )0);
						userInfo.put("state", 0);
					}
					mapper.updateByPrimaryKeySelective(userModel);
					map.put("userInfo", userInfo);
					Logger.info("该用户已存在！");
				}

				return map;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("status", 0);
		map.put("msg", "解密失败");
		return map;
	}

}
