package com.lames.admin.dao;

import com.lames.admin.model.Merchant;

public interface IMerchantDAO {

	public Integer  insert(String account, String password);
	public Merchant login(String account, String password);
	public Merchant find(String account);
}
