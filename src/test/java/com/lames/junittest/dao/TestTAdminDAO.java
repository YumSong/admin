package com.lames.junittest.dao;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.junit.Test;

import com.lames.admin.dao.impl.TAdminDAOimpl;
import com.lames.admin.model.TAdmin;

public class TestTAdminDAO {

	@Test
	public void testlogin() {
		TAdminDAOimpl dao = new TAdminDAOimpl();
		TAdmin admin = dao.login("admin", "123456");
		assertNotNull(admin);
	}
	

}
