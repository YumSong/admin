package com.lames.junittest.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.lames.admin.service.IMerchantService;
import com.lames.admin.service.impl.MerchantServiceimpl;

public class TestMerchantService {
	
	private IMerchantService service;
	@Before
	public void init() {
		service = new MerchantServiceimpl();
	}
	
	@Test//测试账号已被注册
	public void testregistertFail() {
		assertNotNull(service.registerMerchant("jacky", "123456"));
	}

	@Test//测试账号注册成功
	public void testregistertsucceed() {
		assertNotNull(service.registerMerchant("jackytest3", "123456"));
	}

	
}
