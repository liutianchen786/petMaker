package com.luke.service.impl;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.luke.dao.UserMapper;
import com.luke.dao.UserTaskMapper;
import com.luke.model.ChRegion;
import com.luke.model.User;
import com.luke.model.UserDileveryInfo;
import com.luke.model.UserGoodsOrderRecord;
import com.luke.service.IUserService;
import com.luke.util.DealUserImageToCircle;
import com.luke.util.FileUtil;
import com.luke.util.ResultBean;
import com.luke.util.ResultBean.Result;
@Service("userService")
public class UserServiceImpl implements IUserService{

	
	@Autowired
	private UserMapper uMapper;
	@Autowired
	private UserTaskMapper userTaskMapper;
	/**
	 * 
	 * @Description:个人信息修改 如果upflag = 1 资料完善
	 * @author: ltc 
	 * @date: 2018-5-16
	 * @Company: LuKe
	 */
	@Override
	public ResultBean updateUserInfo(User user,Integer upflag) {
		ResultBean bean = null;
		try{
			if(upflag==1){
				int row = userTaskMapper.updateCompleteTsk(user.getUnionid(),1);//row更新行数，如果>0就是更新了，如果是0就么有更新
				if(row>0){
					BigDecimal money = new BigDecimal(100);
					if(user.getState()!=0){//不是会员，积分*2
						money=money.multiply(new BigDecimal(2));
						user.setMoney(money);
					}
//					user.setMoney(user.getMoney().add(money));//加入金币
//					user.setThisweekmoney(user.getThisweekmoney().add(money));//更新本周金币
				}
			}
			uMapper.updateByPrimaryKeySelective(user);
			bean = new ResultBean(Result.SUCCESS);
		}
		catch (Exception e) {
			bean = new ResultBean(Result.EXCEPTION);
			e.printStackTrace();
		}
		return bean;
	}
	/**
	 * 
	 * @Description:个人信息查询
	 * @author: ltc
	 * @date: 2018-5-16
	 * @Company: LuKe
	 */
	@Override
	public User selectUserInfo(String uninoid) {
		return uMapper.selectByUnionidToMap(uninoid);
		
	}
	/**
	 * 
	 * @Description:个人信息更新以及宠物资料卡查询
	 * @author: ltc
	 * @date: 2018-5-16
	 * @Company: LuKe
	 */
	@Override
	public Map selectPetAndPerson(String unionid,String friendsUnionId) {
		return uMapper.selectPetAndPerson(unionid,friendsUnionId);

	}
	/**
	 * 
	 * @Description:个人任务卡查询
	 * @author: ltc
	 * @date: 2018-5-16
	 * @Company: LuKe
	 */
	@Override
	public List<Map> selectUserTask(String unionid) {
		return userTaskMapper.selectUserTask(unionid);
	}
	/**
	 * 
	 * @Description:查询用户收货地址
	 * @author: ltc
	 * @date: 2018-5-16
	 * @Company: LuKe
	 */
	@Override
	public List<UserDileveryInfo> selectAddress(String unionid,Integer deliveryAddressId) {
		return uMapper.selectAddress(unionid,deliveryAddressId);
	}
	
	/**
	 * 
	 * @Description:新增收货地址
	 * @author: ltc
	 * @date: 2018-5-16
	 * @Company: LuKe
	 */
	@Override
	public ResultBean insertAddress(UserDileveryInfo user) {
		ResultBean  bean  = new ResultBean();
		try{
		
			int row = uMapper.insertAddress(user);
			if(row>1){
				bean = new ResultBean(Result.SUCCESS);
			}
			else{
				bean = new ResultBean(Result.FAIL);
			}
		}
		catch(Exception e){
			bean = new ResultBean(Result.EXCEPTION);
			e.printStackTrace();
		}
		return bean;
	}
	/**
	 * 
	 * @Description:修改收货地址
	 * @author: ltc
	 * @date: 2018-5-17
	 * @Company: LuKe
	 */
	@Override
	public ResultBean updateAddress(UserDileveryInfo user) {
		ResultBean  bean  = new ResultBean();
		try{
		
			int row = uMapper.updateAddress(user);
			if(row>1){
				bean = new ResultBean(Result.SUCCESS);
			}
			else{
				bean = new ResultBean(Result.FAIL);
			}
		}
		catch(Exception e){
			bean = new ResultBean(Result.EXCEPTION);
			e.printStackTrace();
		}
		return bean;
	}
	/**
	 * 
	 * @Description:设为默认地址
	 * @author: ltc
	 * @date: 2018-5-17
	 * @Company: LuKe
	 */
	@Override
	public ResultBean SetDeafultAddress(Integer deliveryAddressId,String unionid) {
		//先把所有unionid下所有isdeafult = 1
		//然后把deleveryAddressId的地址置为0
    	ResultBean  bean  = new ResultBean();
		try{
			uMapper.updateIsdeafult(-1,unionid);
			int row = uMapper.updateIsdeafult(deliveryAddressId,unionid);
			if(row>1){
				bean = new ResultBean(Result.SUCCESS);
			}
			else{
				bean = new ResultBean(Result.FAIL);
			}
		}
		catch(Exception e){
			bean = new ResultBean(Result.EXCEPTION);
			e.printStackTrace();
		}
		bean = new  ResultBean(Result.SUCCESS);
		return bean;
	}
	/**
	 * 
	 * @Description:省市区三级别联动
	 * @author: ltc
	 * @date: 2018-5-18
	 * @Company: LuKe
	 */
	@Override
	public List<ChRegion> selectChRegion() {
		 List<ChRegion>  result= uMapper.selectChRegion();
		 List<ChRegion>  regions  = new LinkedList<ChRegion>();
		 for(int i = 0;i<result.size();i++){
			 if(result.get(i).getRegionType()==1){
				 regions.add(result.get(i));
			 }
		 }
		 for (ChRegion chRegion : regions) {
			 chRegion.setChildRegions(regionRecursion(chRegion.getRegionId(),result));
		}       
		 
		 
		 return regions;
	}
	private List<ChRegion> regionRecursion(Long regionId, List<ChRegion> result) {
		
		List<ChRegion> childlist = new LinkedList<ChRegion>();
		
		//子节点
				for(int i=0;i<result.size();i++){
					if(result.get(i).getRegionParentId().equals(regionId)){
						childlist.add(result.get(i));
					}
				}
				//子节点的子节点的子节点*N
				for (ChRegion chRegion : childlist) {
					chRegion.setChildRegions(regionRecursion(chRegion.getRegionId(), result));
				}
				
				if(childlist.size()==0){
					return null;
				}
				return childlist ;
	}
	/**
	 * 
	 * @Description:开通会员
	 * @author: ltc
	 * @throws ParseException 
	 * @date: 2018-5-19
	 * @Company: LuKe
	 */
	@SuppressWarnings("deprecation")
	@Override
	public ResultBean joinVip(User user, Integer month,String viptime) throws ParseException {
		ResultBean bean = null;
		Calendar calendar=Calendar.getInstance();   
		calendar.setTime(new Date()); 
		Timestamp starttime = new Timestamp(calendar.getTime().getTime());
//		//未开通过
		if(user.getState()==0){
			user.setVipstarttime(starttime);
			calendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH)+month);
			user.setVipendtime(new Timestamp(calendar.getTime().getTime()));
		}
		//已经是会员/续费
		else{
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date endTimestamp = formatter.parse(viptime);
			Calendar c=Calendar.getInstance();   
			c.setTime(endTimestamp); 
			c.set(Calendar.MONTH, c.get(Calendar.MONTH)+month);
			user.setVipendtime(new Timestamp(c.getTime().getTime()));
		}
		user.setState((byte) 1);
		//更新user表状态
		uMapper.updateByPrimaryKeySelective(user);
		//插入商品记录表生成开通记录
		UserGoodsOrderRecord ugOrderRecord = new UserGoodsOrderRecord();
		ugOrderRecord.setUnionid(user.getUnionid());//用户id
		ugOrderRecord.setDeliveryaddressid(0);//用户地址
		ugOrderRecord.setGoodsid("0");//商品id
		ugOrderRecord.setGoodsorderrecordid(UUID.randomUUID().toString().replaceAll("-", "").substring(0,32));
		ugOrderRecord.setOrderstate(3);//已签收
		ugOrderRecord.setZfflag("0");
		ugOrderRecord.setOrdertime(starttime);//订单时间
		ugOrderRecord.setPaytime(starttime);//交易时间
		ugOrderRecord.setOperationid(user.getUnionid());//操作人id
		ugOrderRecord.setOperationtime(starttime);//操作时间
		uMapper.insertGoodsRecord(ugOrderRecord);
		bean = new  ResultBean(Result.SUCCESS);
		return bean;
	}
	//背景图片查找
	@Override
	public List<Map<String, Object>> querybkgd() {
		return uMapper.querybkgd();
	}
	//更改背景图
	@Override
	public ResultBean changeBackGround(User user) {
		ResultBean bean =null;
		int row = uMapper.updateByPrimaryKeySelective(user);
		if(row>1){
			bean = new ResultBean(Result.SUCCESS);
		}
		else{
			bean = new ResultBean(Result.FAIL);
		}
		return bean;
	}
	//更新照片墙
	@Override
	public ResultBean updateUserPicphone(User user,String deleUrl,String realPath) {
		ResultBean bean= new ResultBean(Result.SUCCESS);
		try{
			//删除照片墙
			if(deleUrl!=null){
				List<String> messImage = Arrays.asList(deleUrl.split(","));
				FileUtil fileUtil = new FileUtil();
				ResultBean rs= fileUtil.FileDele(messImage, realPath);
				if(!rs.getMsg().equals("success")){
					return rs;
				}
			}
			//更新user表
			int row = uMapper.updateByPrimaryKeySelective(user);
			if(row<=0){
				bean = new ResultBean(Result.FAIL);
			}
		}
		catch (Exception e) {
			bean = new ResultBean(Result.EXCEPTION);
		}
		return bean;
	}
	
}
