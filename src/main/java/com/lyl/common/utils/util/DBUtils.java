package com.lyl.common.utils.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;

public class DBUtils {

	private static DruidDataSource ds;
	
	private static Properties p = new Properties();
	
	public static void load(String resourcePath) {
		try {
			p.load(new FileInputStream(resourcePath));
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			String username = p.getProperty("username");
			String password = p.getProperty("password");
			
			Integer maxActive = Integer.valueOf(p.getProperty("maxActive")); 
			Integer initial = Integer.valueOf(p.getProperty("initial").toString());
			Integer minIdle = Integer.valueOf(p.getProperty("minIdle"));
			
			ds = new DruidDataSource();
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(username);
			ds.setPassword(password);
			ds.setMaxActive(maxActive);
			ds.setInitialSize(initial);
			ds.setMinIdle(minIdle);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void rollback(Connection conn) {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
