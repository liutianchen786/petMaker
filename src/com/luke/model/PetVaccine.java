package com.luke.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-05-09
 */
public class PetVaccine implements Serializable{
    /**
	 * 1
	 */
	private static final long serialVersionUID = 7725688246027724763L;

	private Integer vaccineid;

    /**
     * 疫苗名称
     */
    private String vaccinename;

    /**
     * 操作人id
     */
    private Integer operationid;

    /**
     * 操作时间
     */
    private Date operationtime;

    /**
     * 作废标记 0 不作废 1作废
     */
    private String zfflag;

    public Integer getVaccineid() {
        return vaccineid;
    }

    public void setVaccineid(Integer vaccineid) {
        this.vaccineid = vaccineid;
    }

    public String getVaccinename() {
        return vaccinename;
    }

    public void setVaccinename(String vaccinename) {
        this.vaccinename = vaccinename == null ? null : vaccinename.trim();
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