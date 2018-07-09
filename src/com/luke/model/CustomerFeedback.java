package com.luke.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-03-29
 */
public class CustomerFeedback implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5846258316379048789L;

	private Integer cid;
    
    private String openid;

    private Date senttime;

    private String title;

    private String desc;

    private String state;

    private String state1;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Date getSenttime() {
        return senttime;
    }

    public void setSenttime(Date senttime) {
        this.senttime = senttime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
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
}