package com.lames.admin.dao;

import com.lames.admin.model.TAdmin;

public interface ITAdminDAO {

	public TAdmin login(String loginName,String loginPassword);
}
