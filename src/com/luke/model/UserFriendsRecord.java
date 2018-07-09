package com.luke.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-05-07
 */
public class UserFriendsRecord implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -4250506905071531848L;

	/**
     * 记录表ID
     */
    private Integer userfriendsid;

    /**
     * User表用户unionId关联
     */
    private String unionid;

    /**
     * 好友的unoinId
     */
    private String friendsunionid;

    /**
     * 操作员unoinId
     */
    private String operationid;

    /**
     * 操作时间
     */
    private Date operationtime;

    /**
     * 关注为1 ,取消关注为0（默认值为1）
     */
    private String flag;

    public Integer getUserfriendsid() {
        return userfriendsid;
    }

    public void setUserfriendsid(Integer userfriendsid) {
        this.userfriendsid = userfriendsid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    public String getFriendsunionid() {
        return friendsunionid;
    }

    public void setFriendsunionid(String friendsunionid) {
        this.friendsunionid = friendsunionid == null ? null : friendsunionid.trim();
    }

    public String getOperationid() {
        return operationid;
    }

    public void setOperationid(String operationid) {
        this.operationid = operationid == null ? null : operationid.trim();
    }

    public Date getOperationtime() {
        return operationtime;
    }

    public void setOperationtime(Date operationtime) {
        this.operationtime = operationtime;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }
}