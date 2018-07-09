package com.luke.model;

import java.io.Serializable;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-04-17
 */
public class Circle implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -64887793367998177L;

	private Integer circleid;

    /**
     * 圈子名称
     */
    private String cname;

    /**
     * 圈子描述
     */
    private String cdesc;

    /**
     * 圈子图片
     */
    private String circleimage;

    /**
     * 圈子总人数
     */
    private Integer total;

    /**
     * 圈子管理员id
     */
    private Integer managerid;

    /**
     * 今天关注人数
     */
    private Integer todaycount;

    /**
     * 圈子用户id
     */
    private String unionid;

    /**
     * 保留字段
     */
    private String state;

    public Integer getCircleid() {
        return circleid;
    }

    public void setCircleid(Integer circleid) {
        this.circleid = circleid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getCdesc() {
        return cdesc;
    }

    public void setCdesc(String cdesc) {
        this.cdesc = cdesc == null ? null : cdesc.trim();
    }

    public String getCircleimage() {
        return circleimage;
    }

    public void setCircleimage(String circleimage) {
        this.circleimage = circleimage == null ? null : circleimage.trim();
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getManagerid() {
        return managerid;
    }

    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }

    public Integer getTodaycount() {
        return todaycount;
    }

    public void setTodaycount(Integer todaycount) {
        this.todaycount = todaycount;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}