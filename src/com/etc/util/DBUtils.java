package com.etc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {

	private static final String DRIVERNAME = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/test";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";


	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName(DRIVERNAME);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	// doUpdate
	public static int doUpdate(String sql, Object... arr) {
		PreparedStatement psm = null;
		int count = 0;

		Connection conn = getConn();
		if (conn == null) {
			return 0;
		}
		try {

			psm = conn.prepareStatement(sql);
			for (int i = 0; i < arr.length; i++) {
				psm.setObject(i + 1, arr[i]);
			}

			count = psm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (psm != null)
				psm.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}



	// doQuery
	public static ResultSet doQuery(String sql, Object... arr) {
		PreparedStatement psm = null;
		ResultSet rs = null;

		Connection conn = getConn();
		if (conn == null) {
			return null;
		}
		try {

			psm = conn.prepareStatement(sql);
			for (int i = 0; i < arr.length; i++) {
				psm.setObject(i + 1, arr[i]);
			}

			rs = psm.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rs;
	}

	public static void free(ResultSet rs) {
		Statement sm = null;
		Connection conn = null;
		try {
			sm = rs.getStatement();
			conn = sm.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (rs != null)
				rs.close();
			if (sm != null)
				sm.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


	public static List<Map<String, Object>> doQueryList(String sql, Object... arr) {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		ResultSet rs = doQuery(sql, arr);
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();

			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();

				for (int i = 0; i < count; i++) {
					//
					String columnName = rsmd.getColumnLabel(i + 1);
					Object columnValue = rs.getObject(columnName);
					map.put(columnName, columnValue);
				}

				list.add(map);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.free(rs);
		}

		return list;
	}

}
