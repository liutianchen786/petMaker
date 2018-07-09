package com.luke.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author hiqn
 * 
 * @date 2018-04-23
 */
public class ReleaseTask implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 5308979098395510675L;

	private Integer aid;

    /**
     * 用户id
     */
    private String unionid;

    /**
     * 任务名称
     */
    private String rname;

    /**
     * 任务内容描述
     */
    private String contentdesc;

    /**
     * 任务发布时间
     */
    private Date createtime;

    /**
     * 任务图
     */
    private String rimage;

    /**
     * 任务地点
     */
    private String rposition;

    /**
     * 任务是否被接
     */
    private Byte ranswered;

    /**
     * 任务发起人的经度
     */
    private String rlongitude;

    /**
     * 任务发起热的纬度
     */
    private String rlatitude;

    /**
     * 任务最后一次修改时间
     */
    private Date lasttime;

    /**
     * 保留字段
     */
    private String reserved;

    /**
     * 保留字段
     */
    private String reserved1;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname == null ? null : rname.trim();
    }

    public String getContentdesc() {
        return contentdesc;
    }

    public void setContentdesc(String contentdesc) {
        this.contentdesc = contentdesc == null ? null : contentdesc.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getRimage() {
        return rimage;
    }

    public void setRimage(String rimage) {
        this.rimage = rimage == null ? null : rimage.trim();
    }

    public String getRposition() {
        return rposition;
    }

    public void setRposition(String rposition) {
        this.rposition = rposition == null ? null : rposition.trim();
    }

    public Byte getRanswered() {
        return ranswered;
    }

    public void setRanswered(Byte ranswered) {
        this.ranswered = ranswered;
    }

    public String getRlongitude() {
        return rlongitude;
    }

    public void setRlongitude(String rlongitude) {
        this.rlongitude = rlongitude == null ? null : rlongitude.trim();
    }

    public String getRlatitude() {
        return rlatitude;
    }

    public void setRlatitude(String rlatitude) {
        this.rlatitude = rlatitude == null ? null : rlatitude.trim();
    }

    public Date getLasttime() {
        return lasttime;
    }

    public void setLasttime(Date lasttime) {
        this.lasttime = lasttime;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved == null ? null : reserved.trim();
    }

    public String getReserved1() {
        return reserved1;
    }

    public void setReserved1(String reserved1) {
        this.reserved1 = reserved1 == null ? null : reserved1.trim();
    }
}