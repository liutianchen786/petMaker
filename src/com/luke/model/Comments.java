package com.luke.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * 
 * @author
 * 
 * @date 2018-04-18
 */
public class Comments implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5939949280365964758L;

	private Integer commid;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp createtime;

    /**
     * 消息id  说说的id
     */
    private Integer mid;

    /**
     * 评论人的id
     */
    private String unionid;

    /**
     * 发说说人的id
     */
    private String messunionid;

    /**
     * 评论的id
     */
    private Integer pid;

    private String name;
    
    public Integer getCommid() {
        return commid;
    }

    public void setCommid(Integer commid) {
        this.commid = commid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    
}