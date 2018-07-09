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
public class PetInfo implements Serializable{
    /**
	 * 1
	 */
	private static final long serialVersionUID = -7948672499441034134L;

	private Integer petid;

    /**
     * 关联用户Id
     */
    private String unionid;

    /**
     * 宠物姓名
     */
    private String petname;

    /**
     * 宠物类型ID 和petType表关联
     */
    private Integer pettypeid;

    /**
     * 宠物年龄
     */
    private Integer petage;

    /**
     * 宠物性别（公,母）
     */
    private String petsex;

    /**
     * 宠物描述
     */
    private String petdes;

    /**
     * 是否是主宠 0 是  1 不是 废弃
     */
    private String isfavorite;

    /**
     * 宠物头像地址
     */
    private String petimageurl;

    /**
     * 是否接种疫苗 0未接种 1 接种
     */
    private String vaccineid;

    /**
     * 操作人员ID
     */
    private Integer operationid;

    /**
     * 操作时间
     */
    private Date operationtime;

    /**
     * 作废标记 0 不作废 1作废（逻辑删除）
     */
    private String zfflag;

    public Integer getPetid() {
        return petid;
    }

    public void setPetid(Integer petid) {
        this.petid = petid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname == null ? null : petname.trim();
    }

    public Integer getPettypeid() {
        return pettypeid;
    }

    public void setPettypeid(Integer pettypeid) {
        this.pettypeid = pettypeid;
    }

    public Integer getPetage() {
        return petage;
    }

    public void setPetage(Integer petage) {
        this.petage = petage;
    }

    public String getPetsex() {
        return petsex;
    }

    public void setPetsex(String petsex) {
        this.petsex = petsex == null ? null : petsex.trim();
    }

    public String getPetdes() {
        return petdes;
    }

    public void setPetdes(String petdes) {
        this.petdes = petdes == null ? null : petdes.trim();
    }

    public String getIsfavorite() {
        return isfavorite;
    }

    public void setIsfavorite(String isfavorite) {
        this.isfavorite = isfavorite == null ? null : isfavorite.trim();
    }

    public String getPetimageurl() {
        return petimageurl;
    }

    public void setPetimageurl(String petimageurl) {
        this.petimageurl = petimageurl == null ? null : petimageurl.trim();
    }


    public String getVaccine() {
        return vaccineid;
    }

    public void setVaccineid(String petimageurl) {
        this.vaccineid = vaccineid == null ? null : vaccineid.trim();
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