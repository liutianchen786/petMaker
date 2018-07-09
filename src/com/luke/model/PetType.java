package com.luke.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-05-09
 */
public class PetType implements Serializable{
    /**
	 * 1
	 */
	private static final long serialVersionUID = -4186358364067744962L;

	/**
     * 宠物类型Id
     */
    private Integer pettypeid;

    /**
     * 宠物类型名称
     */
    private String pettypename;

    /**
     * 级联ID
     */
    private Integer pettypepid;

    /**
     * 操作人员ID
     */
    private Integer operationid;

    /**
     * 操作时间
     */
    private Date operationtime;

    /**
     * 作废标记 0 不作废 1 作废
     */
    
    private List<PetType> childTypes;
    
    public List<PetType> getChildTypes() {
		return childTypes;
	}

	public void setChildTypes(List<PetType> childTypes) {
		this.childTypes = childTypes;
	}

	private String zfflag;

    public Integer getPettypeid() {
        return pettypeid;
    }

    public void setPettypeid(Integer pettypeid) {
        this.pettypeid = pettypeid;
    }

    public String getPettypename() {
        return pettypename;
    }

    public void setPettypename(String pettypename) {
        this.pettypename = pettypename == null ? null : pettypename.trim();
    }

    public Integer getPettypepid() {
        return pettypepid;
    }

    public void setPettypepid(Integer pettypepid) {
        this.pettypepid = pettypepid;
    }

    public Integer getOperationid() {
        return operationid;
    }

    public void setOperationid(Integer operationid) {
        this.operationid = operationid;
    }

    public Date getOperationtime() {
        return operationtime;
    }

    public void setOperationtime(Date operationtime) {
        this.operationtime = operationtime;
    }

    public String getZfflag() {
        return zfflag;
    }

    public void setZfflag(String zfflag) {
        this.zfflag = zfflag == null ? null : zfflag.trim();
    }
}