package com.lames.admin.dao.orm;

import java.sql.SQLException;

import com.lames.admin.model.orm.Merchant;

public interface IMerchantDAOorm {

	public int insert(Merchant merchant)throws SQLException;
	public Merchant login(String account, String password)throws SQLException;
	public Merchant find(String account)throws SQLException;
}
