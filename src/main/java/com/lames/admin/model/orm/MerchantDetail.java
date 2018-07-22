package com.lames.admin.model.orm;


import java.util.Arrays;

import com.jake.annotation.Column;
import com.jake.annotation.Entity;
import com.jake.annotation.ID;
import com.jake.annotation.Sequence;

import jdk.nashorn.internal.ir.annotations.Ignore;

@Entity("merchantDetail")
public class MerchantDetail {

    @ID
    @Sequence("S_merchantDetail")
    @Column("merchantDetail_id")
	private Integer merchantDetailID;
    @Column("merchant_id")
	private Integer merchantID;
    @Column("idcard_num")    
	private Integer idcardNum;
    @Column("idcard_pic")
	private String idcardPic;
    @Column("merchant_name")	
	private String merchantName;
    @Column("shop_id")	
	private Integer shopID;
    @Column("status")	
	private Integer status;
	private String[] shopPic;
    @Column("shop_pic")	
	private String shopPics;
    @Column("business_pic")	
	private String businessPic;
    @Column("address")	
	private String address; 
    @Column("INTRODUCTION")	
	private String introduction;
    @Column("last_update_time")
	private Long lastUpdateTime;

	public Integer getMerchantDetailID() {
		return merchantDetailID;
	}

	public void setMerchantDetailID(Integer merchantDetailID) {
		this.merchantDetailID = merchantDetailID;
	}

	public Integer getMerchantID() {
		return merchantID;
	}

	public void setMerchantID(Integer merchantID) {
		this.merchantID = merchantID;
	}

	public Integer getIdcardNum() {
		return idcardNum;
	}

	public void setIdcardNum(Integer idcardNum) {
		this.idcardNum = idcardNum;
	}

	public String getIdcardPic() {
		return idcardPic;
	}

	public void setIdcardPic(String idcardPic) {
		this.idcardPic = idcardPic;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public Integer getShopID() {
		return shopID;
	}

	public void setShopID(Integer shopID) {
		this.shopID = shopID;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String[] getShopPic() {
		return shopPic;
	}

	public void setShopPic(String[] shopPic) {
		this.shopPic = shopPic;
	}

	public String getShopPics() {
		return shopPics;
	}

	public void setShopPics(String shopPics) {
		this.shopPics = shopPics;
	}

	public String getBusinessPic() {
		return businessPic;
	}

	public void setBusinessPic(String businessPic) {
		this.businessPic = businessPic;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Long getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Long lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	@Override
	public String toString() {
		return "MerchantDetail [merchantDetailID=" + merchantDetailID + ", merchantID=" + merchantID + ", idcardNum="
				+ idcardNum + ", idcardPic=" + idcardPic + ", merchantName=" + merchantName + ", shopID=" + shopID
				+ ", status=" + status + ", shopPic=" + Arrays.toString(shopPic) + ", shopPics=" + shopPics
				+ ", businessPic=" + businessPic + ", address=" + address + ", introduction=" + introduction
				+ ", lastUpdateTime=" + lastUpdateTime + "]";
	}

	
}
