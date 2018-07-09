package com.luke.model;

import java.io.Serializable;
import java.net.URLEncoder;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-05-10
 */
public class UserChatRecord implements Serializable{
    /**
	 * 1
	 */
	private static final long serialVersionUID = -4219844671982153173L;

	/** 
     * 聊天记录表
     */
    private Integer chatId;

    /**
     * 发送人ID
     */
    private String sendUnionId;

    /**
     * 接受人ID
     */
    private String toUnionId;

    /**
     * 发送内容
     */
    private String content;

    /**
     * 发送时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date chatTime;

    /**
     * 操作人id
     */
    private Integer operationid;

    /**
     * 操作时间
     */
    private Date opertaiontime;

    /**
     * 废作标记0 为不作废 1为作废
     */
    private String ZFflag;

    /**
     * 此信息状态 0为未读  1为已读
     */
    private String chatstate;

    private static Logger logger = Logger.getLogger(UserChatRecord.class);


	public Integer getChatId() {
		return chatId;
	}

	public void setChatId(Integer chatId) {
		this.chatId = chatId;
	}

	public String getSendUnionId() {
		return sendUnionId;
	}

	public void setSendUnionId(String sendUnionId) {
		this.sendUnionId = sendUnionId;
	}

	public String getToUnionId() {
		return toUnionId;
	}

	public void setToUnionId(String toUnionId) {
		this.toUnionId = toUnionId;
	}

	public String getContent()  {
		return content;
//		try {			
//			return URLEncoder.encode(content,"utf-8");
//		} catch (Exception e) {
//			// TODO: handle exception
//			logger.warn("编码错误:"+e.getMessage());
//			return content;
//		}
	}

	public void setContent(String content) {
		try {
			this.content = content == null ? null : URLEncoder.encode(content,"utf-8");
		} catch (Exception e) {
			// TODO: handle exception
			logger.warn("编码错误："+e.getMessage());
		}
	}

	public Date getChatTime() {
		return chatTime;
	}

	public void setChatTime(Date chatTime) {
		this.chatTime = chatTime;
	}

	public Integer getOperationid() {
		return operationid;
	}

	public void setOperationid(Integer operationid) {
		this.operationid = operationid;
	}

	public Date getOpertaiontime() {
		return opertaiontime;
	}

	public void setOpertaiontime(Date opertaiontime) {
		this.opertaiontime = opertaiontime;
	}

	public String getZFflag() {
		return ZFflag;
	}

	public void setZFflag(String zFflag) {
		ZFflag = zFflag;
	}

	public String getChatstate() {
		return chatstate;
	}

	public void setChatstate(String chatstate) {
		this.chatstate = chatstate;
	}

   
}