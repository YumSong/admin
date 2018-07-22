package com.lames.admin.dao.orm.impl;


import java.sql.SQLException;

import com.jake.core.Criteria;
import com.jake.core.SqlSession;
import com.jake.core.SqlSessionFactory;
import com.lames.admin.dao.orm.ITAdminDAOorm;
import com.lames.admin.model.orm.TAdmin;
import com.lames.admin.util.DBormUtil;


public class TAdminDAOorm implements ITAdminDAOorm {

	private SqlSessionFactory factory = new SqlSessionFactory("com.lames.admin.model.orm");

	public TAdmin login(String loginName, String loginPassword) throws SQLException {
		// TODO Auto-generated method stub
		factory.setDataSource(DBormUtil.getBasicDataSource());
		SqlSession sqlSession = factory.createSqlSession();
		TAdmin admin = new TAdmin();
		Criteria criteria = new Criteria();
		criteria.put("login_Name=",loginName);
		criteria.put("login_Password=",loginPassword);
		TAdmin admin2=sqlSession.find(admin, criteria);
		return admin2;
	}

}
