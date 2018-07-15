package com.lames.admin.service;

import com.lames.admin.model.TAdmin;

public interface ITAdminService {

	public TAdmin login(String loginName,String loginPassword);
}
