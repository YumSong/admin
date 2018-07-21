package com.lames.admin.model.orm;

import com.jake.annotation.Column;
import com.jake.annotation.Entity;
import com.jake.annotation.ID;
import com.jake.annotation.Sequence;

@Entity("merchant")
public class Merchant {
	
	@Column("login_name")
	private String loginName;
	@Column("login_password")
	private String loginPassword;
	@ID
	@Sequence("S_merchant")
	@Column("merchant_id")
	private Integer merchantID;
	
	public Merchant() {
		// TODO Auto-generated constructor stub
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public Integer getMerchantID() {
		return merchantID;
	}

	public void setMerchantID(Integer merchantID) {
		this.merchantID = merchantID;
	}


}
