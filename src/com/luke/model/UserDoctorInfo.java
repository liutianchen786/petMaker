package com.luke.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * 
 */
public class UserDoctorInfo implements Serializable{
    /**
	 * 1
	 */
	private static final long serialVersionUID = -6876356249921239183L;

	/**
     * 医生uuid
     */
    private String userDtcId;

    /**
     * 关联用户表中的unionid
     */
    private String unionId;

    /**
     * 医生姓名
     */
    private String dtcName;

    /**
     * 医生头像
     */
    private String dtcAvaImage;

    /**
     * 医生职位
     */
    private String dtcPosition;

    /**
     * 所属医院
     */
    private String dtcHospital;

    /**
     * 医生特长
     */
    private String dtcSpeciality;

    /**
     * 收费0免费 1vip
     */
    private String dtcPrice;

    /**
     * 询问人数
     */
    private Integer userAmount;

    /**
     * 用户点赞个数
     */
    private Integer userLikeAmount;

    /**
     * 操作人id
     */
    private String opreationId;

    /**
     * 操作时间
     */
    private Date opreationTime;

    /**
     * 作废标记
     */
    private String zfflag;
    /**
     * 头像
     */
    private String avatarUrl;
    
    public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public String getUserdtcid() {
        return userDtcId;
    }

    public void setUserdtcid(String userDtcId) {
        this.userDtcId = userDtcId == null ? null : userDtcId.trim();
    }

    public String getUnionid() {
        return unionId;
    }

    public void setUnionid(String unionId) {
        this.unionId = unionId == null ? null : unionId.trim();
    }

    public String getDtcname() {
        return dtcName;
    }

    public void setDtcname(String dtcName) {
        this.dtcName = dtcName == null ? null : dtcName.trim();
    }

    public String getDtcavaimage() {
        return dtcAvaImage;
    }

    public void setDtcavaimage(String dtcAvaImage) {
        this.dtcAvaImage = dtcAvaImage == null ? null : dtcAvaImage.trim();
    }

    public String getdtcPosition() {
        return dtcPosition;
    }

    public void setdtcPosition(String dtcPosition) {
        this.dtcPosition = dtcPosition == null ? null : dtcPosition.trim();
    }

    public String getdtcHospital() {
        return dtcHospital;
    }

    public void setdtcHospital(String dtcHospital) {
        this.dtcHospital = dtcHospital == null ? null : dtcHospital.trim();
    }

    public String getdtcSpeciality() {
        return dtcSpeciality;
    }

    public void setdtcSpeciality(String dtcSpeciality) {
        this.dtcSpeciality = dtcSpeciality == null ? null : dtcSpeciality.trim();
    }

    public String getdtcPrice() {
        return dtcPrice;
    }

    public void setdtcPrice(String dtcPrice) {
        this.dtcPrice = dtcPrice == null ? null : dtcPrice.trim();
    }

    public Integer getuserAmount() {
        return userAmount;
    }

    public void setuserAmount(Integer userAmount) {
        this.userAmount = userAmount;
    }

    public Integer getuserLikeAmount() {
        return userLikeAmount;
    }

    public void setuserLikeAmount(Integer userLikeAmount) {
        this.userLikeAmount = userLikeAmount;
    }

    public String getopreationId() {
        return opreationId;
    }

    public void setopreationId(String opreationId) {
        this.opreationId = opreationId == null ? null : opreationId.trim();
    }

    public Date getopreationTime() {
        return opreationTime;
    }

    public void setopreationTime(Date opreationTime) {
        this.opreationTime = opreationTime;
    }

    public String getZfflag() {
        return zfflag;
    }

    public void setZfflag(String zfflag) {
        this.zfflag = zfflag == null ? null : zfflag.trim();
    }
}