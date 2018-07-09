package com.luke.model;

import java.io.Serializable;
import java.util.List;

/**
 * 地区信息表
 * 
 * @author ltc
 * 
 * @date 2018-05-18
 */
public class ChRegion implements Serializable{

	/**
	 * 1
	 */
	private static final long serialVersionUID = 5897677555915219914L;

	private Long id;

    private Long parentId;

    private Long regionId;

    private Long regionParentId;

    private String regionName;

    /**
     * 1省 2市 3区
     */
    private Integer regionType;

    private String zipcode;

    private String quhao;

    private Boolean status;

    private List<ChRegion> childRegions;
    
    public List<ChRegion> getChildRegions() {
		return childRegions;
	}

	public void setChildRegions(List<ChRegion> childRegions) {
		this.childRegions = childRegions;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public Long getRegionParentId() {
        return regionParentId;
    }

    public void setRegionParentId(Long regionParentId) {
        this.regionParentId = regionParentId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName == null ? null : regionName.trim();
    }

    public Integer getRegionType() {
        return regionType;
    }

    public void setRegionType(Integer regionType) {
        this.regionType = regionType;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode == null ? null : zipcode.trim();
    }

    public String getQuhao() {
        return quhao;
    }

    public void setQuhao(String quhao) {
        this.quhao = quhao == null ? null : quhao.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}