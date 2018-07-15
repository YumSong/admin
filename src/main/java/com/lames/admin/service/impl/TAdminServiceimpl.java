package com.lames.admin.service.impl;

import com.lames.admin.dao.impl.TAdminDAOimpl;
import com.lames.admin.model.TAdmin;
import com.lames.admin.service.ITAdminService;

public class TAdminServiceimpl implements ITAdminService {

	private TAdminDAOimpl  tAdminDAO= new TAdminDAOimpl();
	
	public TAdminServiceimpl() {
		// TODO Auto-generated constructor stub
	}

	public TAdmin login(String loginName, String loginPassword) {
		// TODO Auto-generated method stub
		return tAdminDAO.login(loginName, loginPassword);
	}

}
