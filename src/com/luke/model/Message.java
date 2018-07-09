package com.luke.model;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-05-09
 */
public class Message implements Serializable{
    /**
	 * 1
	 */
	private static final long serialVersionUID = 6805423847941693631L;
	private Logger logger  = Logger.getLogger(Message.class);
	private Integer messid;

    /**
     * 用户id
     */
    private String unionid;

    /**
     * 关联的circleId
     */
    private Integer circleid;

    /**
     * 消息图片
     */
    private String messimage;

    /**
     * 消息描述
     */
    private String messdesc;

    /**
     * 消息发出时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date messtime;

    /**
     * 广播无标题 圈子有标题
     */
    private String messtitle;

    /**
     * 当前位置
     */
    private String messlocation;

    /**
     * 当前时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date printtime;

    /**
     * 是否点赞
     */
    private Byte ifclick;

    /**
     * 点赞数
     */
    private Integer clickcount;

    /**
     * 评论数
     */
    private Integer commenetscount;

    /**
     * 消息已读数
     */
    private Byte havereadcount;

    /**
     * 消息类型
     */
    private String messtype;

    /**
     * 消息来源
     */
    private String messfrom;

    /**
     * 消息去向
     */
    private String messto;

    /**
     * 0为广播动态  1为圈子话题 2为广播+圈子
     */
    private Integer messState;

    /**
     * 作废标记 0不作废 1 作废
     */
    private String zfflag;

    /**
     * 操作人员id
     */
    private Integer operationid;

    /**
     * 操作时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date operationtime;

    public Integer getMessid() {
        return messid;
    }

    public void setMessid(Integer messid) {
        this.messid = messid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    public Integer getCircleid() {
        return circleid;
    }

    public void setCircleid(Integer circleid) {
        this.circleid = circleid;
    }

    public String getMessimage() {
        return messimage;
    }

    public void setMessimage(String messimage) {
        this.messimage = messimage == null ? null : messimage.trim();
    }

    public String getMessdesc() {
    	logger.info("is using getMessDesc:"+messdesc);
    	return messdesc;
//        try {
//			return URLEncoder.encode(messdesc, "utf-8");
//		} catch (UnsupportedEncodingException e) {
//			logger.warn("编码错误:"+e.getMessage());
//			return messdesc;
//		}
    }

    public void setMessdesc(String messdesc) {
    	logger.info("is using setMessDesc"+messdesc);
        try {
			this.messdesc = messdesc == null ? null : URLEncoder.encode(messdesc, "utf-8");
		} catch (UnsupportedEncodingException e) {
			logger.warn("编码错误:"+e.getMessage());
		}
    }

    public Date getMesstime() {
        return messtime;
    }

    public void setMesstime(Date messtime) {
        this.messtime = messtime;
    }

    public String getMesstitle() {
        return messtitle;
    }

    public void setMesstitle(String messtitle) {
        this.messtitle = messtitle == null ? null : messtitle.trim();
    }

    public String getMesslocation() {
        return messlocation;
    }

    public void setMesslocation(String messlocation) {
        this.messlocation = messlocation == null ? null : messlocation.trim();
    }

    public Date getPrinttime() {
        return printtime;
    }

    public void setPrinttime(Date printtime) {
        this.printtime = printtime;
    }

    public Byte getIfclick() {
        return ifclick;
    }

    public void setIfclick(Byte ifclick) {
        this.ifclick = ifclick;
    }

    public Integer getClickcount() {
        return clickcount;
    }

    public void setClickcount(Integer clickcount) {
        this.clickcount = clickcount;
    }

    public Integer getCommenetscount() {
        return commenetscount;
    }

    public void setCommenetscount(Integer commenetscount) {
        this.commenetscount = commenetscount;
    }

    public Byte getHavereadcount() {
        return havereadcount;
    }

    public void setHavereadcount(Byte havereadcount) {
        this.havereadcount = havereadcount;
    }

    public String getMesstype() {
        return messtype;
    }

    public void setMesstype(String messtype) {
        this.messtype = messtype == null ? null : messtype.trim();
    }

    public String getMessfrom() {
        return messfrom;
    }

    public void setMessfrom(String messfrom) {
        this.messfrom = messfrom == null ? null : messfrom.trim();
    }

    public String getMessto() {
        return messto;
    }

    public void setMessto(String messto) {
        this.messto = messto == null ? null : messto.trim();
    }

    public Integer getmessState() {
        return messState;
    }

    public void setmessState(Integer messState) {
        this.messState = messState;
    }

    public String getZfflag() {
        return zfflag;
    }

    public void setZfflag(String zfflag) {
        this.zfflag = zfflag == null ? null : zfflag.trim();
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
}