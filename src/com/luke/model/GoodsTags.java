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
public class GoodsTags implements Serializable{
    /**
	 * 1
	 */
	private static final long serialVersionUID = -2459998104419055227L;

	/**
     * 商品标签ID
     */
    private Integer goodstagsid;

    /**
     * 商品标签名称
     */
    private String goodstagsname;

    /**
     * 操作人员id
     */
    private String operationid;

    /**
     * 操作时间
     */
    private Date operationtime;

    /**
     * 作废标记 0 不作废 1作废
     */
    private String zfflag;

    public Integer getGoodstagsid() {
        return goodstagsid;
    }

    public void setGoodstagsid(Integer goodstagsid) {
        this.goodstagsid = goodstagsid;
    }

    public String getGoodstagsname() {
        return goodstagsname;
    }

    public void setGoodstagsname(String goodstagsname) {
        this.goodstagsname = goodstagsname == null ? null : goodstagsname.trim();
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