package com.etc.dao;


import com.etc.entity.Disher;
import com.etc.util.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DishDao {
    public List<Disher> query() throws SQLException {

        ArrayList<Disher> list=new ArrayList<Disher>();

        ResultSet rs = DBUtils.doQuery("select * from dishes ");
        while(rs.next()){

            list.add(new Disher(rs.getInt("did"),rs.getString("dishname"),
                    rs.getInt("number"),rs.getString("rmaterial"),
                    rs.getInt("price"),rs.getInt("sid")));

        }
        return list;
    }
}
