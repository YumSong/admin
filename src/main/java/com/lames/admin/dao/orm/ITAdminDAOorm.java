package com.lames.admin.dao.orm;

import java.sql.SQLException;

import com.lames.admin.model.orm.TAdmin;

public interface ITAdminDAOorm {

	public TAdmin login(String loginName,String loginPassword) throws SQLException;
}
