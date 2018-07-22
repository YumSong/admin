package com.lames.admin.service.orm;

import com.lames.admin.model.JsonResult;


public interface ITAdminService {

	public JsonResult login(String loginName,String loginPassword);
}
