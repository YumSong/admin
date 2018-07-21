package com.lames.junittest.dao;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.lames.admin.dao.IMerchantDetailDAO;
import com.lames.admin.dao.impl.MerchantDetailDAOimpl;
import com.lames.admin.model.MerchantDetail;
import com.lames.admin.util.PageUtil;


public class TestMerchantDetailDAO {

	private IMerchantDetailDAO dao;
	@Before
	public void init() {
		dao = new MerchantDetailDAOimpl();
	}
	
	@Test
	public void testFindbyID() {
		MerchantDetail m= dao.fingByID(61);
		System.out.println(m.toString());
		assertNotNull(dao.fingByID(61));
	}
	
	@Test
	public void testFindbyMerchantID() {
		System.out.println(dao.findByMerchantID(1).getShopPic()[0].toString());
		System.out.println(dao.findByMerchantID(1).getShopPic()[1].toString());
		assertNotNull(dao.findByMerchantID(1));
	}

	@Test
	public void testgetShopList() {
		System.out.println(dao.queryPassedShopID().size());
		assertNotNull(dao.queryPassedShopID());
	}

	
	@Test
	public void testInsert() {
		MerchantDetail m = new MerchantDetail();
		String[] str = {"https://gss0.bdstatic.com/70cFsjip0QIZ8tyhnq/img/logo-zhidao.gif","https://gss0.bdstatic.com/70cFsjip0QIZ8tyhnq/img/logo-zhidao.gif"};
		m.setAddress("Address test2");
		m.setBusinessPic("https://gss0.bdstatic.com/70cFsjip0QIZ8tyhnq/img/logo-zhidao.gif");
		m.setIdcardNum(11122);
		m.setIdcardPic("https://gss0.bdstatic.com/70cFsjip0QIZ8tyhnq/img/logo-zhidao.gif");
		
		m.setMerchantID(0);
		m.setMerchantName("test name2");
		m.setShopID(1);
		m.setShopPic(str);
		m.setStatus(0);
		dao.insert(m);
		assertNotNull(dao.fingByID(22));
	}

	@Test//shoppic 数组为null,lastUpdateTime
	public void testInsert1() {
		MerchantDetail m = new MerchantDetail();
		java.util.Date curDate = new java.util.Date();
		Long lastUpdateTime = curDate.getTime();
		String[] str = {"https://gss0.bdstatic.com/70cFsjip0QIZ8tyhnq/img/logo-zhidao.gif"};
		m.setAddress("Address test2");
		m.setBusinessPic("https://gss0.bdstatic.com/70cFsjip0QIZ8tyhnq/img/logo-zhidao.gif");
		m.setIdcardNum(11122);
		m.setIdcardPic("https://gss0.bdstatic.com/70cFsjip0QIZ8tyhnq/img/logo-zhidao.gif");
		m.setMerchantID(0);
		m.setMerchantName("test name2");
		m.setShopID(1);
		m.setShopPic(str);
		m.setStatus(0);
		m.setLastUpdateTime(lastUpdateTime);
		dao.insert(m);
		assertNotNull(dao.fingByID(61));
	}
	@Test
	public void testListtoUpdate() {
		PageUtil pUtil = new PageUtil();
		pUtil.setLength(2);
		pUtil.setPageNum(1);
		System.out.println(dao.listToUpdateStatus(pUtil).size());
		assertNotNull(dao.listToUpdateStatus(pUtil));
	}
	
	@Test
	public void testListtoVerify() {
		PageUtil pUtil = new PageUtil();
		pUtil.setLength(2);
		pUtil.setPageNum(3);
		System.out.println(dao.listToVerify(pUtil).size());
		assertNotNull(dao.listToVerify(pUtil));
	}
	
	@Test
	public void testUpdateStatus() {
	
		assertEquals(1,(int)(dao.updateStatusByID(1, 2)));
	}

}
