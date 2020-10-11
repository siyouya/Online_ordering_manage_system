package com.etc.test;

import com.etc.util.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws SQLException {
        DBUtils db=new DBUtils();
        ResultSet rs = DBUtils.doQuery("select * from dishes ");
        while (rs.next()){
            int did=rs.getInt("did");
            System.out.println(did);
        }
    }
}
