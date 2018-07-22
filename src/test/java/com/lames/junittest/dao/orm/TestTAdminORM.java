package com.lames.junittest.dao.orm;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.lames.admin.dao.orm.impl.TAdminDAOorm;
import com.lames.admin.model.orm.TAdmin;

public class TestTAdminORM {

	TAdminDAOorm dao = new TAdminDAOorm();
	@Test
	public void testlogin() throws SQLException {
		TAdmin t= dao.login("admin","123456");
		System.out.println(t.getAdminID());
		assertNotNull(t);
	}

}
