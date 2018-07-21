package com.lames.admin.service.orm.impl;

import java.sql.SQLException;

import com.lames.admin.dao.orm.impl.TAdminDAOorm;
import com.lames.admin.model.orm.TAdmin;
import com.lames.admin.service.orm.ITAdminService;

public class TAdminServiceORMimpl implements ITAdminService {

	private TAdminDAOorm  tAdminDAO= new TAdminDAOorm();
	
	public TAdminServiceORMimpl() {
		// TODO Auto-generated constructor stub
	}

	public TAdmin login(String loginName, String loginPassword) {
		// TODO Auto-generated method stub
		try {
			return tAdminDAO.login(loginName, loginPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
