package com.lames.junittest.service;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.lames.admin.constant.MerchantDetailStatus;
import com.lames.admin.dao.impl.MerchantDetailDAOimpl;
import com.lames.admin.model.JsonResult;
import com.lames.admin.model.MerchantDetail;
import com.lames.admin.service.impl.MerchantDetailServiceimpl;
import com.lames.admin.util.PageUtil;

public class TestMerchantDetailService {

	private MerchantDetailServiceimpl service ;
	private MerchantDetailDAOimpl dao ;
	@Before
	public void init() {
		service = new MerchantDetailServiceimpl();
		dao = new MerchantDetailDAOimpl();
	}
	
	@Test
	public void testGetPassedShopID() {
		System.out.println(service.getPassedShopID());
		assertNotNull(service.getPassedShopID());
	}

	@Test
	public void testUpdateMerchantDetailStatus() {
		MerchantDetail merchantDetail=dao.fingByID(61);
		assertEquals(0,service.updateMerchantDetailStatus(merchantDetail, 3));
	}
	
	@Test
	public void testverifyMerchantDetailStatus() {
		MerchantDetail merchantDetail=dao.fingByID(61);
		merchantDetail.setStatus(MerchantDetailStatus.PASSED);
		assertEquals(1,service.verifyMerchantDetailStatus(merchantDetail));
	}
	
	@Test
	public void testFind() {
		System.out.println(service.findMerchantDetailByMerchantID(5).toString());
		assertNotNull(service.findMerchantDetailByMerchantID(5));
	}
	
	@Test
	public void testListtoUpdate() {
		PageUtil pUtil = new PageUtil();
		System.out.println(service.listToUpdateStatus(pUtil).size());
		assertNotNull(service.listToUpdateStatus(pUtil));
	}
	
	@Test
	public void testListtoVerify() {
		PageUtil pUtil = new PageUtil();
		assertNotNull(service.listToVerify(pUtil));
	}
	
	@Test
	public void isUpdateableTest() {		
		MerchantDetail merchantDetail=dao.fingByID(61);
		merchantDetail.setIntroduction("I am modified");
		JsonResult jsonResult=service.isUpdateable(merchantDetail);
		System.out.println(jsonResult.isStatus());
		assertTrue(jsonResult.isStatus());
	}
	
	@Test
	public void isUpdateableTestFalse() {		
		MerchantDetail merchantDetail=dao.fingByID(61);
		java.util.Date curDate = new java.util.Date();
		Long lastUpdateTime = curDate.getTime();
		merchantDetail.setLastUpdateTime(lastUpdateTime);
		merchantDetail.setIntroduction("if modified");
		JsonResult jsonResult=service.isUpdateable(merchantDetail);
		System.out.println(jsonResult.isStatus());
		assertFalse(jsonResult.isStatus());
	}
	
}
