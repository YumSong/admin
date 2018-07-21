package com.lames.admin.service.orm;

import com.lames.admin.model.JsonResult;

public interface IMerchantService {
	
	public JsonResult registerMerchant(String account, String password);
	public JsonResult loginMerchant(String account, String password);
}
