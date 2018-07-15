package com.lames.junittest.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.lames.admin.service.impl.MerchantDetailServiceimpl;
import com.lames.admin.util.PageUtil;

public class TestMerchantDetailService {

	private MerchantDetailServiceimpl service ;
	
	@Before
	public void init() {
		service = new MerchantDetailServiceimpl();
	}
	
	@Test
	public void testGetPassedShopID() {
		System.out.println(service.getPassedShopID());
		assertNotNull(service.getPassedShopID());
	}

	@Test// 状态参数为1时 改为3，为3时改为1.
	public void testUpdateMerchantDetailStatus() {

		assertEquals(1,service.updateMerchantDetailStatus(4, 1));
	}
	
	@Test//将状态改成参数值
	public void testverifyMerchantDetailStatus() {

		assertEquals(1,service.verifyMerchantDetailStatus(1, 3));
	}
	
	@Test//查找一个MerchantDetail
	public void testFind() {
		System.out.println(service.findMerchantDetailByMerchantID(5).toString());
		assertNotNull(service.findMerchantDetailByMerchantID(5));
	}
	
	@Test//展示MerchantDetails可以拉黑拉白的列表
	public void testListtoUpdate() {
		PageUtil pUtil = new PageUtil();
		System.out.println(service.listToUpdateStatus(pUtil).size());
		assertNotNull(service.listToUpdateStatus(pUtil));
	}
	
	@Test//展示MerchantDetails可以拉黑拉白的列表
	public void testListtoVerify() {
		PageUtil pUtil = new PageUtil();
		assertNotNull(service.listToVerify(pUtil));
	}
	
	
}
