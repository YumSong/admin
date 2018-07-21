package com.lames.admin.dao.orm.impl;

import java.sql.SQLException;

import com.jake.core.Criteria;
import com.jake.core.SqlSession;
import com.jake.core.SqlSessionFactory;
import com.jake.core.Table;
import com.lames.admin.dao.orm.IMerchantDAOorm;
import com.lames.admin.model.orm.Merchant;
import com.lames.admin.util.DBormUtil;

public class MerchantDAOorm implements IMerchantDAOorm {
	
	private SqlSessionFactory factory = new SqlSessionFactory("com.lames.admin.model.orm");
	
	public int insert(Merchant merchant) throws SQLException {
		// TODO Auto-generated method stub
		factory.setDataSource(DBormUtil.getBasicDataSource());
		SqlSession sqlSession = factory.createSqlSession();	
		int i = sqlSession.save(merchant);
		sqlSession.close();
		return i;
	}

	public Merchant login(String account, String password)throws SQLException {
		// TODO Auto-generated method stub
		factory.setDataSource(DBormUtil.getBasicDataSource());
		SqlSession sqlSession = factory.createSqlSession();	
		Merchant merchant = new Merchant();
		Criteria criteria = new Criteria();
		criteria.put("login_Name=",account);
		criteria.put("login_Password=",password);
		merchant = sqlSession.find(merchant, criteria);
		return merchant;
	}

	public Merchant find(String account)throws SQLException {
		// TODO Auto-generated method stub
		factory.setDataSource(DBormUtil.getBasicDataSource());
		SqlSession sqlSession = factory.createSqlSession();	
		Merchant merchant = new Merchant();
		Criteria criteria = new Criteria();
		criteria.put("login_Name=",account);
		merchant = sqlSession.find(merchant, criteria);
		return merchant;
	}

}
