package com.luke.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-04-17
 */
public class Clicklike implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 6511727819023185955L;

	private Integer id;

    private Byte ifclick;

    /**
     * 点赞时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp clicktime;

    /**
     * 被点赞的消息的id
     */
    private Integer mid;

    /**
     * 点赞人id
     */
    private String unionid;

    /**
     * 信息发出人id
     */
    private String messunionid;

    /**
     * 点赞数
     */
    private Integer clickcount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getIfclick() {
        return ifclick;
    }

    public void setIfclick(Byte ifclick) {
        this.ifclick = ifclick;
    }

    public Timestamp getClicktime() {
        return clicktime;
    }

    public void setClicktime(Timestamp clicktime) {
        this.clicktime = clicktime;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    public String getMessunionid() {
        return messunionid;
    }

    public void setMessunionid(String messunionid) {
        this.messunionid = messunionid == null ? null : messunionid.trim();
    }

    public Integer getClickcount() {
        return clickcount;
    }

    public void setClickcount(Integer clickcount) {
        this.clickcount = clickcount;
    }
}