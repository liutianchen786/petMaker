package com.luke.util;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ResultBean implements Serializable{
	private String code;
	private String msg;
	private Object obj;
	
	public enum Result{
		SUCCESS,FAIL,EXCEPTION,FULL
	}
	
	public ResultBean()
	{
		code="10000";
		msg="success";
	}
	
	public ResultBean(Result result)
	{
		switch (result) {
		case SUCCESS:
			code="10000";
			msg="success";
			break;
		case FAIL:
			code="10001";
			msg="fail";
			break;
		case EXCEPTION:
			code="10002";
			msg="exception";
			break;
		case FULL:
			code="10003";
			msg="等级已满";
			break;
		default:
			break;
		}
	}
	
	
	
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
}
