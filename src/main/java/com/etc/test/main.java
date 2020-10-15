package com.etc.test;

import com.etc.dao.MapDistance;
import com.etc.util.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws SQLException {
        MapDistance mapd=new MapDistance();
        String start = "北京天安门";
//        mapd.getLonLattest(start);

        String end = "上海市黄浦区西藏中路";

        String startLonLat = mapd.getLonLat(start);
        String endLonLat = mapd.getLonLat(end);

        System.out.println("起始地："+start+",经纬度："+startLonLat);
        System.out.println("终点："+end+",经纬度："+endLonLat);

        Long dis = mapd.getDistance(startLonLat,endLonLat);
        System.out.println("两点间距离："+dis+"米");
    }
}
