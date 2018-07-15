package com.lames.admin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lames.admin.dao.ITAdminDAO;
import com.lames.admin.model.TAdmin;
import com.lames.admin.util.DBUtil;


public class TAdminDAOimpl implements ITAdminDAO {

	public TAdminDAOimpl() {
		// TODO Auto-generated constructor stub
	}

	public TAdmin login(String loginName, String loginPassword) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		ResultSet rs =null;
		PreparedStatement ps =null;
		try {
			String sql = "SELECT ID,LOGIN_NAME From T_ADMIN where Login_PASSWORD=? and LOGIN_NAME=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginPassword);
			ps.setString(2, loginName);
			rs = ps.executeQuery();		
			while(rs.next()) {
				TAdmin admin=new TAdmin();
				admin.setAdminID(rs.getInt(1));
				admin.setLoginName(rs.getString(2));				
				return admin;
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

}
