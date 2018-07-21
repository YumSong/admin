package com.lames.junittest.dao.orm;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.lames.admin.constant.MerchantDetailStatus;
import com.lames.admin.dao.orm.IMerchantDetailDAOorm;
import com.lames.admin.dao.orm.impl.MerchantDetailDAOorm;
import com.lames.admin.model.orm.MerchantDetail;

public class testMerchantDetailORM {

	private IMerchantDetailDAOorm  dao = new MerchantDetailDAOorm();
	
	@Test
	public void testFind() throws SQLException {
		MerchantDetail m = dao.fingByID(81);
		System.out.println(m.toString());
		assertNotNull(m);
	}
	
	@Test//未完成
	public void testFindByMerchantId() throws SQLException {
		MerchantDetail m = dao.findByMerchantID(59);
		System.out.println(m.toString());
		assertNotNull(m);
	}


	@Test
	public void testInsert() throws SQLException {
		MerchantDetail m = new MerchantDetail();
		java.util.Date curDate = new java.util.Date();
		Long lastUpdateTime = curDate.getTime();
		String str = "https://gss0.bdstatic.com/70cFsjip0QIZ8tyhnq/img/logo-zhidao.gif;;https://gss0.bdstatic.com/70cFsjip0QIZ8tyhnq/img/logo-zhidao.gif";
		m.setAddress("Address test2");
		m.setBusinessPic("https://gss0.bdstatic.com/70cFsjip0QIZ8tyhnq/img/logo-zhidao.gif");
		m.setIdcardNum(11122);
		m.setIdcardPic("https://gss0.bdstatic.com/70cFsjip0QIZ8tyhnq/img/logo-zhidao.gif");
		m.setMerchantID(0);
		m.setMerchantName("test name2");
		m.setShopID(3);
		m.setShopPics(str);
		m.setStatus(0);
		m.setLastUpdateTime(lastUpdateTime);
		int i =dao.insert(m);
		System.out.println(i);
		assertEquals(1, i);
	}
	
	
	@Test//ORM未完成 所以在完成后要继续测试
	public void testQueryPassedShopID() throws SQLException {
		List<Integer>list = dao.queryPassedShopID();
		System.out.println(list);
		assertNotNull(list);
	}
	
	@Test
	public void testupdateStatusByID() throws SQLException {
		int i =dao.updateStatusByID(81,MerchantDetailStatus.PASSED);
		System.out.println(i);
		assertEquals(1,i);
	}
	
	@Test
	public void testupdateByID() throws SQLException {
		MerchantDetail detail ;
		detail=dao.fingByID(81);
		detail.setMerchantName("I have modified the name 3");
		System.out.println(detail.toString());
		int i =dao.updateByID(detail);
		System.out.println(i);
		assertEquals(1,i);
	}
}
