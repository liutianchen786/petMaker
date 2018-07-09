package com.luke.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author hqin
 * 
 * @date 2018-04-23
 */
public class AcceptTask implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7808940686370230791L;

	private Integer aid;

    /**
     * 接受任务人id
     */
    private String unionid;

    /**
     * 接受的任务名称
     */
    private String aname;

    /**
     * 接受任务的内容
     */
    private String contentdesc;

    /**
     * 接受任务的时间
     */
    private Date createtime;

    /**
     * 接受的任务的图片
     */
    private String aimage;

    /**
     * 接收人地点
     */
    private String aposition;

    /**
     * 接收任务人的纬度
     */
    private String alatitude;

    /**
     * 是否完成
     */
    private Byte aansewered;

    /**
     * 完成时间
     */
    private Date answeredtime;

    /**
     * 保留字段
     */
    private String state;

    /**
     * 保留字段
     */
    private String state1;

    /**
     * 接受任务人的经度
     */
    private String alongitude;

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

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname == null ? null : aname.trim();
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

    public String getAimage() {
        return aimage;
    }

    public void setAimage(String aimage) {
        this.aimage = aimage == null ? null : aimage.trim();
    }

    public String getAposition() {
        return aposition;
    }

    public void setAposition(String aposition) {
        this.aposition = aposition == null ? null : aposition.trim();
    }

    public String getAlatitude() {
        return alatitude;
    }

    public void setAlatitude(String alatitude) {
        this.alatitude = alatitude == null ? null : alatitude.trim();
    }

    public Byte getAansewered() {
        return aansewered;
    }

    public void setAansewered(Byte aansewered) {
        this.aansewered = aansewered;
    }

    public Date getAnsweredtime() {
        return answeredtime;
    }

    public void setAnsweredtime(Date answeredtime) {
        this.answeredtime = answeredtime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getState1() {
        return state1;
    }

    public void setState1(String state1) {
        this.state1 = state1 == null ? null : state1.trim();
    }

    public String getAlongitude() {
        return alongitude;
    }

    public void setAlongitude(String alongitude) {
        this.alongitude = alongitude == null ? null : alongitude.trim();
    }
}