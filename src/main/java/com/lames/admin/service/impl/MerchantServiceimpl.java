package com.lames.admin.service.impl;

import com.lames.admin.dao.IMerchantDAO;
import com.lames.admin.dao.IMerchantDetailDAO;
import com.lames.admin.dao.impl.MerchantDAOimpl;
import com.lames.admin.model.JsonResult;
import com.lames.admin.model.Merchant;
import com.lames.admin.service.IMerchantService;

public class MerchantServiceimpl implements IMerchantService {

	private IMerchantDAO merchantDAO = new MerchantDAOimpl();
	private IMerchantDetailDAO merchantDetailDAO;

	public JsonResult loginMerchant(String account, String password) {
		// TODO Auto-generated method stub
		Merchant m = merchantDAO.login(account, password);
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
		Merchant m = merchantDAO.find(account);
		JsonResult jsonResult = new JsonResult();
		if (m == null) {
			if (merchantDAO.insert(account, password) > 0) {
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
		return jsonResult;
	}

}
