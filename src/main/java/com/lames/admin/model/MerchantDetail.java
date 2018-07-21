package com.lames.admin.model;


import java.util.Arrays;


public class MerchantDetail {

	private Integer merchantDetailID;
	private Integer merchantID;
	private Integer idcardNum;
	private String idcardPic;
	private String merchantName;
	private Integer shopID;
	private Integer status;// 狀態：0-待處理、 1-審核通過（拉白）、 2-駁回 3、不同意（拉黑）

	private String[] shopPic;
	private String shopPics;
	private String businessPic;
	private String address;
	private String introduction;

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
