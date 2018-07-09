package com.luke.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-04-23
 */
public class USignrecord implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1350011925191621393L;

	/**
     * 签到id
     */
    private Integer signid;

    /**
     * 用户id
     */
    private String unionid;

    /**
     * 签到时间
     */
    private Timestamp signtime;

    /**
     * 操作员id
     */
    private Integer operationid;

    /**
     * 操作时间
     */
    private Timestamp operationtime;

    public Integer getSignid() {
        return signid;
    }

    public void setSignid(Integer signid) {
        this.signid = signid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    public Timestamp getSigntime() {
        return signtime;
    }

    public void setSigntime(Timestamp signtime) {
        this.signtime = signtime;
    }

    public Integer getOperationid() {
        return operationid;
    }

    public void setOperationid(Integer operationid) {
        this.operationid = operationid;
    }

    public Timestamp getOperationtime() {
        return operationtime;
    }

    public void setOperationtime(Timestamp operationtime) {
        this.operationtime = operationtime;
    }
}