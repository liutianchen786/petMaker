package com.luke.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-05-24
 */
public class UserGoodsOrderRecord implements Serializable{
    /**
	 * 1
	 */
	private static final long serialVersionUID = -7716362055383752594L;

	/**
     * 订单记录ID
     */
    private String goodsOrderRecordId;

    /**
     * 商品ID
     */
    private String goodsId;

    /**
     * 收货地址ID
     */
    private Integer deliveryAddressId;

    /**
     * 用户uninoid
     */
    private String unionId;

    /**
     * 订单状态 0待付款   1等待发货 2已发货 3 已签收  4取消订单 
     */
    private Integer orderState;

    /**
     * 订单时间
     */
    private Timestamp orderTime;

    /**
     * 付款时间
     */
    private Timestamp payTime;

    /**
     * 发货时间
     */
    private Timestamp sendTime;

    /**
     * 取消时间
     */
    private Timestamp cancelTime;

    /**
     * 操作人ID
     */
    private String operationId;

    /**
     * 操作时间
     */
    private Timestamp operationTime;

    /**
     * 作废标记 0不作废 1作废
     */
    private String zfFlag;

    public String getGoodsorderrecordid() {
        return goodsOrderRecordId;
    }

    public void setGoodsorderrecordid(String goodsorderrecordid) {
        this.goodsOrderRecordId = goodsorderrecordid == null ? null : goodsorderrecordid.trim();
    }

    public String getGoodsid() {
        return goodsId;
    }

    public void setGoodsid(String goodsid) {
        this.goodsId = goodsid == null ? null : goodsid.trim();
    }

    public Integer getDeliveryaddressid() {
        return deliveryAddressId;
    }

    public void setDeliveryaddressid(Integer deliveryaddressid) {
        this.deliveryAddressId = deliveryaddressid;
    }

    public String getUnionid() {
        return unionId;
    }

    public void setUnionid(String unionid) {
        this.unionId = unionid == null ? null : unionid.trim();
    }

    public Integer getOrderstate() {
        return orderState;
    }

    public void setOrderstate(Integer orderstate) {
        this.orderState = orderstate;
    }

    public Date getOrdertime() {
        return orderTime;
    }

    public void setOrdertime(Timestamp ordertime) {
        this.orderTime = ordertime;
    }

    public Timestamp getPaytime() {
        return payTime;
    }

    public void setPaytime(Timestamp paytime) {
        this.payTime = paytime;
    }

    public Timestamp getSendtime() {
        return sendTime;
    }

    public void setSendtime(Timestamp sendtime) {
        this.sendTime = sendtime;
    }

    public Timestamp getCanceltime() {
        return cancelTime;
    }

    public void setCanceltime(Timestamp canceltime) {
        this.cancelTime = canceltime;
    }

    public String getOperationid() {
        return operationId;
    }

    public void setOperationid(String operationid) {
        this.operationId = operationid == null ? null : operationid.trim();
    }

    public Timestamp getOperationtime() {
        return operationTime;
    }

    public void setOperationtime(Timestamp operationtime) {
        this.operationTime = operationtime;
    }

    public String getZfflag() {
        return zfFlag;
    }

    public void setZfflag(String zfFlag) {
        this.zfFlag = zfFlag == null ? null : zfFlag.trim();
    }
}