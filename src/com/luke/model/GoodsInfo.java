package com.luke.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-05-16
 */
public class GoodsInfo implements Serializable{
    /**
	 * 1
	 */
	private static final long serialVersionUID = -8283123935025298520L;

	/**
     * 商品Id(UUID)
     */
    private String goodsid;

    /**
     * 商品名称
     */
    private String goodsname;

    /**
     * 商品标签
     */
    private String goodstagsid;

    /**
     * 商品详情
     */
    private String goodsdetails;

    /**
     * 商品兑换个数
     */
    private Integer goodsexchangeno;

    /**
     * 商品图片
     */
    private String goodsimageurl;

    /**
     * 商品存量
     */
    private Integer goodsstock;

    /**
     * 商品价格
     */
    private BigDecimal goodsprice;

    /**
     * 操作人id
     */
    private String operationid;

    /**
     * 操作时间
     */
    private Date operationtime;

    /**
     * 作废标记 0 不作废 1作废
     */
    private String zfflag;

    /**
     * 商品规格（暂时废弃）
     */
    private String goodsspecificationid;

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid == null ? null : goodsid.trim();
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    public String getGoodstagsid() {
        return goodstagsid;
    }

    public void setGoodstagsid(String goodstagsid) {
        this.goodstagsid = goodstagsid == null ? null : goodstagsid.trim();
    }

    public String getGoodsdetails() {
        return goodsdetails;
    }

    public void setGoodsdetails(String goodsdetails) {
        this.goodsdetails = goodsdetails == null ? null : goodsdetails.trim();
    }

    public Integer getGoodsexchangeno() {
        return goodsexchangeno;
    }

    public void setGoodsexchangeno(Integer goodsexchangeno) {
        this.goodsexchangeno = goodsexchangeno;
    }

    public String getGoodsimageurl() {
        return goodsimageurl;
    }

    public void setGoodsimageurl(String goodsimageurl) {
        this.goodsimageurl = goodsimageurl == null ? null : goodsimageurl.trim();
    }

    public Integer getGoodsstock() {
        return goodsstock;
    }

    public void setGoodsstock(Integer goodsstock) {
        this.goodsstock = goodsstock;
    }

    public BigDecimal getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(BigDecimal goodsprice) {
        this.goodsprice = goodsprice;
    }

    public String getOperationid() {
        return operationid;
    }

    public void setOperationid(String operationid) {
        this.operationid = operationid == null ? null : operationid.trim();
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

    public String getGoodsspecificationid() {
        return goodsspecificationid;
    }

    public void setGoodsspecificationid(String goodsspecificationid) {
        this.goodsspecificationid = goodsspecificationid == null ? null : goodsspecificationid.trim();
    }
}