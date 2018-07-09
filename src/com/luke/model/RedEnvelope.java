package com.luke.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author
 * 
 * @date 2018-03-29
 */
public class RedEnvelope implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 6244810619926676773L;

	private Integer eid;

    private String openid;

    private Integer money;

    private Date createtime;

    private Byte estate;

    private Date gettime;

    private Integer getuid;

    private Date timeout;

    private Integer sentid;

    private Integer sentenvelope;

    private Integer getenvelope;

    private Integer getmoney;

    private Integer sentmoney;

    private Integer state;

    private Integer state1;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Byte getEstate() {
        return estate;
    }

    public void setEstate(Byte estate) {
        this.estate = estate;
    }

    public Date getGettime() {
        return gettime;
    }

    public void setGettime(Date gettime) {
        this.gettime = gettime;
    }

    public Integer getGetuid() {
        return getuid;
    }

    public void setGetuid(Integer getuid) {
        this.getuid = getuid;
    }

    public Date getTimeout() {
        return timeout;
    }

    public void setTimeout(Date timeout) {
        this.timeout = timeout;
    }

    public Integer getSentid() {
        return sentid;
    }

    public void setSentid(Integer sentid) {
        this.sentid = sentid;
    }

    public Integer getSentenvelope() {
        return sentenvelope;
    }

    public void setSentenvelope(Integer sentenvelope) {
        this.sentenvelope = sentenvelope;
    }

    public Integer getGetenvelope() {
        return getenvelope;
    }

    public void setGetenvelope(Integer getenvelope) {
        this.getenvelope = getenvelope;
    }

    public Integer getGetmoney() {
        return getmoney;
    }

    public void setGetmoney(Integer getmoney) {
        this.getmoney = getmoney;
    }

    public Integer getSentmoney() {
        return sentmoney;
    }

    public void setSentmoney(Integer sentmoney) {
        this.sentmoney = sentmoney;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getState1() {
        return state1;
    }

    public void setState1(Integer state1) {
        this.state1 = state1;
    }
}