package com.luke.model;

import java.io.Serializable;

/**
 * 
 * 
 * @author
 * 
 * @date 2018-03-29
 */
public class Role implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -4587444533451697010L;

	private Integer roleid;

    private String openid;

    private String rolename;

    private String roledesc;

    private String state;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getRoledesc() {
        return roledesc;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc == null ? null : roledesc.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}