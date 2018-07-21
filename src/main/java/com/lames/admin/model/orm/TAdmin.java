package com.lames.admin.model.orm;

import com.jake.annotation.Column;
import com.jake.annotation.ID;
import com.jake.annotation.Sequence;

public class TAdmin {
	
	@Column("login_name")
	private String loginName;
	@Column("login_password")
	private String loginPassword;
	@ID
	@Sequence("S_t_admin")
	@Column("ID")
	private Integer AdminID;
	
	public TAdmin() {
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

	public Integer getAdminID() {
		return AdminID;
	}

	public void setAdminID(Integer adminID) {
		AdminID = adminID;
	}


	
}
