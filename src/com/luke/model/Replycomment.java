package com.luke.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-04-16
 */
public class Replycomment implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3272971296161664058L;

	private Integer replyCommentid;

    /**
     * 回复内容
     */
    private String replycontent;

    private Date replytime;

    /**
     * 评论内容的id
     */
    private Integer commentid;

    /**
     * 消息id
     */
    private Integer mid;

    /**
     * 评论人id
     */
    private String unioinid;

    /**
     * 发消息人id
     */
    private String messunionid;

    private String state;

    public Integer getReplyCommentid() {
        return replyCommentid;
    }

    public void setReplyCommentid(Integer replyCommentid) {
        this.replyCommentid = replyCommentid;
    }

    public String getReplycontent() {
        return replycontent;
    }

    public void setReplycontent(String replycontent) {
        this.replycontent = replycontent == null ? null : replycontent.trim();
    }

    public Date getReplytime() {
        return replytime;
    }

    public void setReplytime(Date replytime) {
        this.replytime = replytime;
    }

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getUnioinid() {
        return unioinid;
    }

    public void setUnioinid(String unioinid) {
        this.unioinid = unioinid == null ? null : unioinid.trim();
    }

    public String getMessunionid() {
        return messunionid;
    }

    public void setMessunionid(String messunionid) {
        this.messunionid = messunionid == null ? null : messunionid.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}