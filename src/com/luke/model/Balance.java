package com.luke.model;

import java.io.Serializable;

/**
 * 
 * 
 * @author hqin
 * 
 * @date 2018-03-29
 */
public class Balance implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -335041977942102765L;

	private Integer bid;

    private String openid;

    private Integer balance;

    private Integer topUp;

    private Integer withdrawal;

    private Integer state;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getTopUp() {
        return topUp;
    }

    public void setTopUp(Integer topUp) {
        this.topUp = topUp;
    }

    public Integer getWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(Integer withdrawal) {
        this.withdrawal = withdrawal;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}