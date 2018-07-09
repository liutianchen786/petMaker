package com.luke.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-05-16
 */
public class UserDileveryInfo implements Serializable{
    /**
	 * 1
	 */
	private static final long serialVersionUID = -3422706778815950525L;

	/**
     * 收货地址ID
     */
    private Integer deliveryaddressid;

    /**
     * 用户unionid
     */
    private String unionid;

    /**
     * 收货号码
     */
    private String deliveryphone;

    /**
     * 收货人姓名
     */
    private String deliveryusername;

    /**
     * 地图收货地址
     */
    private String addressfrommap;

    /**
     * 门牌号
     */
    private String addressdetail;

    /**
     * 是否设为默认 0 为是 1为否
     */
    private Integer isdeafult;

    /**
     * 操作人ID
     */
    private String operationid;

    private Date operationtime;

    /**
     * 作废标记 0不作废 1作废
     */
    private String zfflag;

    public Integer getDeliveryaddressid() {
        return deliveryaddressid;
    }

    public void setDeliveryaddressid(Integer deliveryaddressid) {
        this.deliveryaddressid = deliveryaddressid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    public String getDeliveryphone() {
        return deliveryphone;
    }

    public void setDeliveryphone(String deliveryphone) {
    	this.deliveryphone = deliveryphone == null ? null : deliveryphone.trim();
    }

    public String getDeliveryusername() {
        return deliveryusername;
    }

    public void setDeliveryusername(String deliveryusername) {
        this.deliveryusername = deliveryusername == null ? null : deliveryusername.trim();
    }

    public String getAddressfrommap() {
        return addressfrommap;
    }

    public void setAddressfrommap(String addressfrommap) {
        this.addressfrommap = addressfrommap == null ? null : addressfrommap.trim();
    }

    public String getAddressdetail() {
        return addressdetail;
    }

    public void setAddressdetail(String addressdetail) {
        this.addressdetail = addressdetail == null ? null : addressdetail.trim();
    }

    public Integer getIsdeafult() {
        return isdeafult;
    }

    public void setIsdeafult(Integer isdeafult) {
        this.isdeafult = isdeafult;
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