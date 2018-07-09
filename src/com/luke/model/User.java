package com.luke.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-05-17
 */
public class User implements Serializable{
    /**
	 * 1
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 用户id
     */
    private Integer uid;

    private String openid;

    /**
     * unionId
     */
    private String unionid;

    /**
     * 手机号
     */
    private Integer phone;

    /**
     * 头像地址
     */
    private String avatarurl;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 性别
     */
    private String gender;

    /**
     * 城市
     */
    private String city;

    /**
     * 省份
     */
    private String provice;

    /**
     * 国家
     */
    private String country;

    /**
     * 金额
     */
    private BigDecimal money;

    /**
     * 0保密 1单身 2恋爱 3 已婚
     */
    private String affectivestate;

    /**
     * 二维码
     */
    private String qrcode;

    /**
     * 是否是会员（1是，0不是，默认为0）
     */
    private Byte state;

    /**
     * 用户背景图片
     */
    private Integer backGroundId;

    public Integer getBackGroundId() {
		return backGroundId;
	}

	public void setBackGroundId(Integer backGroundId) {
		this.backGroundId = backGroundId;
	}

	/**
     * vip开启时间
     */
    private Timestamp  vipstarttime;

    /**
     * vip结束时间
     */
    private Timestamp  vipendtime;

    /**
     * 会员积分
     */
    private Long userpoints;

    /**
     * 用户等级
     */
    private Integer userlevel;

    /**
     * 关注的圈子的id
     */
    private String circleid;

    /**
     * 今天是否签到
     */
    private Byte todayifsign;

    /**
     * 连续签到天数
     */
    private Integer continuousday;

    /**
     * 用户说明
     */
    private String userdesc;

    /**
     * 操作人id
     */
    private String operationid;

    /**
     * 操作时间
     */
    private Timestamp  opertaiontime;

    /**
     * 作废标记 0不作废 1作废
     */
    private String zfflag;

    public BigDecimal getThisweekmoney() {
		return thisweekmoney;
	}

	public void setThisweekmoney(BigDecimal thisweekmoney) {
		this.thisweekmoney = thisweekmoney;
	}

	public BigDecimal getLastweekmoney() {
		return lastweekmoney;
	}

	public void setLastweekmoney(BigDecimal lastweekmoney) {
		this.lastweekmoney = lastweekmoney;
	}

	/**
     * 本周金额
     */
    private BigDecimal thisweekmoney;

    /**
     * 上周金额
     */
    private BigDecimal lastweekmoney;

    /**
     * 
     * @Title: petMaker
     * @Description:年龄 
     * @author: ltc
     * @date: 2018-5-17-下午3:40:00
     * @Company: LuKe
     */
    private Integer userage;
    /**
     * 相册
     */
    private String phonePic;
    
    public String getPhonePic() {
		return phonePic;
	}

	public void setPhonePic(String phonePic) {
		this.phonePic = phonePic;
	}

	public Integer getUserage() {
		return userage;
	}

	public void setUserage(Integer userage) {
		this.userage = userage;
	}

	public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl == null ? null : avatarurl.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getProvice() {
        return provice;
    }

    public void setProvice(String provice) {
        this.provice = provice == null ? null : provice.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getAffectivestate() {
        return affectivestate;
    }

    public void setAffectivestate(String affectivestate) {
        this.affectivestate = affectivestate == null ? null : affectivestate.trim();
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode == null ? null : qrcode.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }


    public Timestamp  getVipstarttime() {
        return vipstarttime;
    }

    public void setVipstarttime(Timestamp  vipstarttime) {
        this.vipstarttime = vipstarttime;
    }

    public Timestamp  getVipendtime() {
        return vipendtime;
    }

    public void setVipendtime(Timestamp  vipendtime) {
        this.vipendtime = vipendtime;
    }

    public Long getUserpoints() {
        return userpoints;
    }

    public void setUserpoints(Long userpoints) {
        this.userpoints = userpoints;
    }

    public Integer getUserlevel() {
        return userlevel;
    }

    public void setUserlevel(Integer userlevel) {
        this.userlevel = userlevel;
    }

    public String getCircleid() {
        return circleid;
    }

    public void setCircleid(String circleid) {
        this.circleid = circleid == null ? null : circleid.trim();
    }

    public Byte getTodayifsign() {
        return todayifsign;
    }

    public void setTodayifsign(Byte todayifsign) {
        this.todayifsign = todayifsign;
    }

    public Integer getContinuousday() {
        return continuousday;
    }

    public void setContinuousday(Integer continuousday) {
        this.continuousday = continuousday;
    }

    public String getUserdesc() {
        return userdesc;
    }

    public void setUserdesc(String userdesc) {
        this.userdesc = userdesc == null ? null : userdesc.trim();
    }

    public String getOperationid() {
        return operationid;
    }

    public void setOperationid(String operationid) {
        this.operationid = operationid == null ? null : operationid.trim();
    }

    public Timestamp  getOpertaiontime() {
        return opertaiontime;
    }

    public void setOpertaiontime(Timestamp  opertaiontime) {
        this.opertaiontime = opertaiontime;
    }

    public String getZfflag() {
        return zfflag;
    }

    public void setZfflag(String zfflag) {
        this.zfflag = zfflag == null ? null : zfflag.trim();
    }
}