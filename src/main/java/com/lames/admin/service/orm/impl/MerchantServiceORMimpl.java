package com.lames.admin.service.orm.impl;

import java.sql.SQLException;

import com.lames.admin.dao.orm.impl.MerchantDAOorm;
import com.lames.admin.model.JsonResult;
import com.lames.admin.model.orm.Merchant;
import com.lames.admin.service.orm.IMerchantService;

public class MerchantServiceORMimpl implements IMerchantService {

	private MerchantDAOorm merchantDAO = new MerchantDAOorm();

	public JsonResult loginMerchant(String account, String password) {
		// TODO Auto-generated method stub
		Merchant m = null;
		try {
			m = merchantDAO.login(account, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonResult jsonResult = new JsonResult();
		if (m != null) {
			jsonResult.setData("merchant", m);
			jsonResult.setStatus(true);
			jsonResult.setMessage("login  successfully");
		} else {
			jsonResult.setStatus(false);
			jsonResult.setMessage("login  failed");
		}
		return jsonResult;
	}

	public JsonResult registerMerchant(String account, String password) {
		// TODO Auto-generated method stub
		Merchant m = null;
		JsonResult jsonResult = new JsonResult();
		try {
			m = merchantDAO.find(account);
			if (m == null) {
				Merchant merchant = new Merchant();
				merchant.setLoginName(account);
				merchant.setLoginPassword(password);
				if (merchantDAO.insert(merchant) > 0) {
					m =  merchantDAO.login(account, password);
					jsonResult.setData("merchant", m);
					jsonResult.setStatus(true);
					jsonResult.setMessage("register  successfully");
				}else {
					jsonResult.setStatus(false);
					jsonResult.setMessage("other  error");
				}
			} else {
				jsonResult.setStatus(false);
				jsonResult.setMessage("loginName  is  existed");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonResult;
	}

}
