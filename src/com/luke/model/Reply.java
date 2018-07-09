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
public class Reply implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3829404757068749112L;

	private Integer replyid;

    private Integer cid;

    private Integer openid;

    private Date replytime;

    private String replydesc;

    private Byte answered;

    private Date answeredtime;

    private String state;

    private String state1;

    public Integer getReplyid() {
        return replyid;
    }

    public void setReplyid(Integer replyid) {
        this.replyid = replyid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getOpenid() {
        return openid;
    }

    public void setOpenid(Integer openid) {
        this.openid = openid;
    }

    public Date getReplytime() {
        return replytime;
    }

    public void setReplytime(Date replytime) {
        this.replytime = replytime;
    }

    public String getReplydesc() {
        return replydesc;
    }

    public void setReplydesc(String replydesc) {
        this.replydesc = replydesc == null ? null : replydesc.trim();
    }

    public Byte getAnswered() {
        return answered;
    }

    public void setAnswered(Byte answered) {
        this.answered = answered;
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
}