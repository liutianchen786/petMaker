package com.luke.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 
 * 
 * 
 * @date 2018-05-29
 */
public class UserCirclelikeRecord implements Serializable{
    /**
	 * 1
	 */
	private static final long serialVersionUID = 4987768697598849061L;

	/**
     * 用户圈子关注记录表
用户注册时会自动生成圈子条数
     */
    private String userCircleRecordId;

    /**
     * 用户关联id
     */
    private String unionId;

    /**
     * 圈子id
     */
    private Integer circleId;

    /**
     * 是否关注 2 否 1是
     */
    private String isLike;

    /**
     * 操作人id
     */
    private String opreationId;

    /**
     * 操作时间
     */
    private Timestamp opreationTime;

    /**
     * 作废标记 
     */
    private String ZFflag;

	public String getUserCircleRecordId() {
		return userCircleRecordId;
	}

	public void setUserCircleRecordId(String userCircleRecordId) {
		this.userCircleRecordId = userCircleRecordId;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public Integer getCircleId() {
		return circleId;
	}

	public void setCircleId(Integer circleId) {
		this.circleId = circleId;
	}

	public String getIsLike() {
		return isLike;
	}

	public void setIsLike(String isLike) {
		this.isLike = isLike;
	}

	public String getOpreationId() {
		return opreationId;
	}

	public void setOpreationId(String opreationId) {
		this.opreationId = opreationId;
	}

	public Timestamp getOpreationTime() {
		return opreationTime;
	}

	public void setOpreationTime(Timestamp opreationTime) {
		this.opreationTime = opreationTime;
	}

	public String getZFflag() {
		return ZFflag;
	}

	public void setZFflag(String zFflag) {
		ZFflag = zFflag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}