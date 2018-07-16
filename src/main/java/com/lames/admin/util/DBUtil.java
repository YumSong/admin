package com.lames.admin.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBUtil {
	private static BasicDataSource ds;
	private static final String PATH="db/jdbc.properties";
	static {
		Properties properties = new Properties();
		try {
			InputStream in = DBUtil.class.getClassLoader().getResourceAsStream(PATH); 
			properties.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ds = new BasicDataSource();
		ds.setDriverClassName(properties.getProperty("jdbc.divername"));
		ds.setUrl(properties.getProperty("jdbc.url"));
		ds.setUsername(properties.getProperty("jdbc.user"));
		ds.setPassword(properties.getProperty("jdbc.password"));
		
		ds.setInitialSize(20); // 初始连接数量
		ds.setMinIdle(3); //最少保持几条空闲的连接
		ds.setMaxTotal(1000); //最大连接数量
		ds.setMaxWaitMillis(10000); //最大等待时间
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void free(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void free(Connection conn, PreparedStatement pst){
        if(pst != null) {
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        free(conn);
    }

    public static void free(Connection conn, PreparedStatement pst, ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        free(conn,pst);
    }
}
