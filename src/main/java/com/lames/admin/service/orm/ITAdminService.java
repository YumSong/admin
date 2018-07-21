package com.lames.admin.service.orm;

import com.lames.admin.model.orm.TAdmin;

public interface ITAdminService {

	public TAdmin login(String loginName,String loginPassword);
}
