package com.lames.admin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lames.admin.dao.IMerchantDAO;
import com.lames.admin.model.Merchant;
import com.lames.admin.util.DBUtil;
import com.lames.admin.util.Dbutil2;

public class MerchantDAOimpl implements IMerchantDAO {

	public MerchantDAOimpl() {
		// TODO Auto-generated constructor stub
	}

	public Merchant login(String account, String password) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();

		ResultSet rs =null;
		PreparedStatement ps =null;
		try {
			String sql = "SELECT MERCHANT_ID,LOGIN_NAME From MERCHANT where Login_PASSWORD=? and LOGIN_NAME=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, account);
			rs = ps.executeQuery();		
			while(rs.next()) {
				Merchant m=new Merchant();
				m.setMerchantID(rs.getInt(1));
				m.setLoginName(rs.getString(2));				
				return m;
			}
			conn.close();			
		} catch (Exception e) {
			try {
				conn.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			DBUtil.free(conn, ps, rs);;
		}	
		return null;
	}

	public Integer insert(String account, String password) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		ResultSet rs =null;
		PreparedStatement ps =null;
		try {
			String sql = "INSERT INTO MERCHANT(MERCHANT_ID,LOGIN_PASSWORD,LOGIN_NAME) VALUES(S_merchant.nextval,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, account);
			int i= ps.executeUpdate();		
			if(i>0)	
				return 1;
			conn.close();
			return 0;
		} catch (Exception e) {
			try {
				conn.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			DBUtil.free(conn, ps, rs);;
		}	
		return 0;
	}

	public Merchant find(String account) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		ResultSet rs =null;
		PreparedStatement ps =null;
		try {
			String sql = "SELECT MERCHANT_ID,LOGIN_NAME From MERCHANT where LOGIN_NAME=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			rs = ps.executeQuery();		
			while(rs.next()) {
				Merchant m=new Merchant();
				m.setMerchantID(rs.getInt(1));
				m.setLoginName(rs.getString(2));				
				return m;
			}
			conn.close();			
		} catch (Exception e) {
			try {
				conn.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}	finally {
			DBUtil.free(conn, ps, rs);;
		}	
		return null;
	}

}
