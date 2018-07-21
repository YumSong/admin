package com.lames.junittest.dao.orm;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.lames.admin.dao.orm.IMerchantDAOorm;
import com.lames.admin.dao.orm.impl.MerchantDAOorm;
import com.lames.admin.model.orm.Merchant;

public class testMerchantORM {

	IMerchantDAOorm dao = new MerchantDAOorm();
	
	@Test
	public void testInsert() throws SQLException {
		Merchant merchant = new Merchant();
		merchant.setLoginName("test123");
		merchant.setLoginPassword("123456");
		int i= dao.insert(merchant);
		System.out.println(i);
		assertEquals(1,i);
	}

	@Test
	public void testLogin() throws SQLException {
		String LoginName="test123";
		String LoginPassword="123456";
		Merchant merchant = dao.login(LoginName, LoginPassword);
		System.out.println(merchant);
		assertNotNull(merchant);;
	}

	@Test
	public void testFind() throws SQLException {
		String LoginName="test123";
		Merchant merchant = dao.find(LoginName);
		System.out.println(merchant);
		assertNotNull(merchant);;
	}

}
