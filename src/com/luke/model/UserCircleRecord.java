package com.luke.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-05-07
 */
public class UserCircleRecord implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 5067351463408193822L;

	private Integer userCircleRecordid;

    /**
     * 用户id
     */
    private String unionid;

    /**
     * 圈子Id
     */
    private Integer circleid;

    /**
     * 退出时间
     */
    private Date exittime;

    /**
     * 操作人Id
     */
    private Integer operationid;

    /**
     * 操作时间
     */
    private Date operationtime;

    public Integer getUserCircleRecordid() {
        return userCircleRecordid;
    }

    public void setUserCircleRecordid(Integer userCircleRecordid) {
        this.userCircleRecordid = userCircleRecordid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    public Integer getCircleid() {
        return circleid;
    }

    public void setCircleid(Integer circleid) {
        this.circleid = circleid;
    }

    public Date getExittime() {
        return exittime;
    }

    public void setExittime(Date exittime) {
        this.exittime = exittime;
    }

    public Integer getOperationid() {
        return operationid;
    }

    public void setOperationid(Integer operationid) {
        this.operationid = operationid;
    }

    public Date getOperationtime() {
        return operationtime;
    }

    public void setOperationtime(Date operationtime) {
        this.operationtime = operationtime;
    }
}