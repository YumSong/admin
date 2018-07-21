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

	@Test// 状态参数为1时 改为3，为3时改为1.
	public void testUpdateMerchantDetailStatus() {
		MerchantDetail merchantDetail=dao.fingByID(61);
		assertEquals(0,service.updateMerchantDetailStatus(merchantDetail, 3));
	}
	
	@Test//将状态改成参数值
	public void testverifyMerchantDetailStatus() {
		MerchantDetail merchantDetail=dao.fingByID(61);
		merchantDetail.setStatus(MerchantDetailStatus.PASSED);
		assertEquals(1,service.verifyMerchantDetailStatus(merchantDetail));
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
	
	@Test//测试是否能更新状态,true
	public void isUpdateableTest() {		
		MerchantDetail merchantDetail=dao.fingByID(61);
		merchantDetail.setIntroduction("I am modified");
		JsonResult jsonResult=service.isUpdateable(merchantDetail);
		System.out.println(jsonResult.isStatus());
		assertTrue(jsonResult.isStatus());
	}
	
	@Test//测试是否能更新状态,false
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
