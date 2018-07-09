package com.luke.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-05-25
 */
public class Region implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer regionid;

    private String unionid;

    /**
     * 地区名称
     */
    private String address;

    /**
     * 经度
     */
    private Double longitude;

    /**
     * 纬度
     */
    private Double latitude;

    /**
     * 地区代码
     */
    private Integer regioncode;

    /**
     * 上级地区代码
     */
    private Integer superiorareacode;
    /**
     * 地图缩放等级
     */
    private double scale;
    public double getScale() {
		return scale;
	}

	public void setScale(double scale) {
		this.scale = scale;
	}

	/**
     * 地区简称
     */
    private String regionreferred;

    /**
     * 地区等级
     */
    private String regionlevel;

    /**
     * 用户头像
     */
    private String userImage;

    /**
     * 操作人员id
     */
    private String operationid;

    /**
     * 操作时间
     */
    private Date operationtime;

    /**
     * 作废标记 0不作废 1作废
     */
    private String zfflag;
    private String avaCirImage;

    public String getAvaCirImage() {
		return avaCirImage;
	}

	public void setAvaCirImage(String avaCirImage) {
		this.avaCirImage = avaCirImage;
	}

	public Integer getRegionid() {
        return regionid;
    }

    public void setRegionid(Integer regionid) {
        this.regionid = regionid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Integer getRegioncode() {
        return regioncode;
    }

    public void setRegioncode(Integer regioncode) {
        this.regioncode = regioncode;
    }

    public Integer getSuperiorareacode() {
        return superiorareacode;
    }

    public void setSuperiorareacode(Integer superiorareacode) {
        this.superiorareacode = superiorareacode;
    }

    public String getRegionreferred() {
        return regionreferred;
    }

    public void setRegionreferred(String regionreferred) {
        this.regionreferred = regionreferred == null ? null : regionreferred.trim();
    }

    public String getRegionlevel() {
        return regionlevel;
    }

    public void setRegionlevel(String regionlevel) {
        this.regionlevel = regionlevel == null ? null : regionlevel.trim();
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage == null ? null : userImage.trim();
    }

    public String getOperationid() {
        return operationid;
    }

    public void setOperationid(String operationid) {
        this.operationid = operationid == null ? null : operationid.trim();
    }

    public Date getOperationtime() {
        return operationtime;
    }

    public void setOperationtime(Date operationtime) {
        this.operationtime = operationtime;
    }

    public String getZfflag() {
        return zfflag;
    }

    public void setZfflag(String zfflag) {
        this.zfflag = zfflag == null ? null : zfflag.trim();
    }
}