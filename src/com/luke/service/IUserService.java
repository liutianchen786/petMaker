package com.luke.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.luke.model.ChRegion;
import com.luke.model.User;
import com.luke.model.UserDileveryInfo;
import com.luke.util.ResultBean;

public interface IUserService {
	
	//更新个人信息
	public ResultBean updateUserInfo(User user, Integer upflag);
	//个人信息查询
	public User selectUserInfo(String  uninoid);
	//个人信息以及宠物资料卡查询
	public Map selectPetAndPerson(String unionid,String friendsUnionId);
	//用户任务卡
	public List<Map> selectUserTask(String unionid);
	//用户收货地址
	public List<UserDileveryInfo> selectAddress(String unionid,Integer deliveryAddressId);
	//新增收货地址
	public ResultBean insertAddress(UserDileveryInfo user);
	//修改收货地址 
	public ResultBean updateAddress(UserDileveryInfo user);
	//设为默认地址
	public ResultBean SetDeafultAddress(Integer deliveryAddressId,String unionid);
	//省市区三级联动
	public List<ChRegion> selectChRegion();
	//开通会员
	public ResultBean joinVip(User user, Integer month, String viptime) throws ParseException;
	//查找背景图片
	public List<Map<String, Object>> querybkgd();
	//更改背景图
	public ResultBean changeBackGround(User user);
	//更新照片墙
	public ResultBean updateUserPicphone(User user, String deleUrl, String realPath);

}
