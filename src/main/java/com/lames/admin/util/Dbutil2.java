package com.lames.admin.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class Dbutil2 {
	private static String driverClassName ="oracle.jdbc.OracleDriver" ;
	private static String url ="jdbc:oracle:thin:@localhost:1521:xe";
	private static String user="onlinedinner";
	private static String password="123456";
	private static BasicDataSource ds;
	
	 static {
		ds = new BasicDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(url);
		ds.setUsername(user);
		ds.setPassword(password);	
		ds.setInitialSize(20);
		ds.setMinIdle(30);
		ds.setMaxTotal(1000);
		ds.setMaxWaitMillis(10000);
	
	}
	
	public static Connection getConn() {
		Connection conn =null;
		try {
			conn=ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return null;
		}
		return conn;				
	}

	
}
