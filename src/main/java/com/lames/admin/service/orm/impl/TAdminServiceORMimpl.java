package com.lames.admin.service.orm.impl;

import java.sql.SQLException;

import com.lames.admin.dao.orm.impl.TAdminDAOorm;
import com.lames.admin.model.JsonResult;
import com.lames.admin.model.orm.TAdmin;
import com.lames.admin.service.orm.ITAdminService;

public class TAdminServiceORMimpl implements ITAdminService {

	private TAdminDAOorm  tAdminDAO= new TAdminDAOorm();
	
	public TAdminServiceORMimpl() {
		// TODO Auto-generated constructor stub
	}

	public JsonResult login(String loginName, String loginPassword) {
		// TODO Auto-generated method stub
		JsonResult jsonResult = new JsonResult();
		try {
			TAdmin t=tAdminDAO.login(loginName, loginPassword);
			if(t!=null) {
				jsonResult.setStatus(true);
				jsonResult.setMessage("Login Successfully");
				jsonResult.setData("TAdmin", t);
				return jsonResult;
			}else {
				jsonResult.setStatus(false);
				jsonResult.setMessage("Account or password is invalid");
				return jsonResult;
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jsonResult.setStatus(false);
		jsonResult.setMessage("Orther Error");
		return jsonResult;
	}

}
