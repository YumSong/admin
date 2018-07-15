package com.lames.junittest.dao;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.lames.admin.dao.IMerchantDAO;
import com.lames.admin.dao.impl.MerchantDAOimpl;
import com.lames.admin.model.Merchant;

public class TestMerchantDAO {

	private IMerchantDAO dao;
	@Before
	public void init() {
		dao = new MerchantDAOimpl();
	}
	
	@Test
	public void testAdd() {
		
		assertEquals(1,(int)dao.insert("jackytest2", "zxc12345"));
	}
	@Test
	public void testFind() {
		
		assertNotNull(dao.find("jackytest2"));
	}
	@Test
	public void testLogin() {
		Merchant m=dao.login("jacky", "123456");
		assertEquals("jacky", m.getLoginName());
	}

}
