package com.luke.model;

import java.io.Serializable;

public class PetVaccineRecord implements Serializable{

	/**
	 * 1
	 */
	private static final long serialVersionUID = -5312837251052928984L;
	private Integer vaccineId;
	private String unionid;
	private char vaccineState;
	public Integer getVaccineId() {
		return vaccineId;
	}
	public void setVaccineId(Integer vaccineId) {
		this.vaccineId = vaccineId;
	}
	public String getUnionId() {
		return unionid;
	}
	public void setUnionId(String unionId) {
		this.unionid = unionId;
	}
	public char getVaccineState() {
		return vaccineState;
	}
	public void setVaccineState(char vaccineState) {
		this.vaccineState = vaccineState;
	}
}
