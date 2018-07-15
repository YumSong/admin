package com.lames.admin.model;

public class MerchantDetailPic extends MerchantDetail {

	private Integer merchantDetailID;
	private Integer merchantID;
	private Integer idcardNum;
	private String idcardPic;
	private String merchantName;
	private Integer shopID;
	private Integer status;// 狀態：0-待處理、 1-審核通過（拉白）、 2-駁回 3、不同意（拉黑）
	private String shopPic1;
	private String shopPic2;
	private String businessPic;
	private String address;
	private String introduction;

	public MerchantDetailPic() {
		// TODO Auto-generated constructor stub
	}

	public MerchantDetailPic(MerchantDetail m) {
		// TODO Auto-generated constructor stub
	
		this.merchantDetailID = m.getMerchantDetailID();
		this.merchantID = m.getMerchantID();
		this.idcardNum = m.getIdcardNum();
		this.idcardPic = m.getIdcardPic();
		this.merchantName = m.getMerchantName();
		this.shopID = m.getShopID();
		this.status = m.getStatus();
		this.businessPic = m.getBusinessPic();
		this.address = m.getAddress();
		this.introduction = m.getIntroduction();
	}

	private void splitPicURL(String url) {
		String[] str = url.split(";;");
		for (int i = 0; i < str.length; i++) {
			if (i == 0)
				this.shopPic1 = str[i];
			if (i == 1)
				this.shopPic2 = str[i];
		}
	}

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

	public String getShopPic1() {
		return shopPic1;
	}

	public void setShopPic1(String shopPic1) {
		this.shopPic1 = shopPic1;
	}

	public String getShopPic2() {
		return shopPic2;
	}

	public void setShopPic2(String shopPic2) {
		this.shopPic2 = shopPic2;
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

}
