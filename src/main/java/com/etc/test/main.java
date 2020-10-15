package com.etc.test;

import com.etc.dao.MapDistance;

import java.sql.SQLException;

import static com.etc.dao.MapDistance.getDistanceByAdress;

public class main {
    public static void main(String[] args) throws SQLException {
        MapDistance mapd=new MapDistance();
        String start = "厦门市软件园三期d03公寓";
//        mapd.getLonLattest(start);

        String end = "福建省福州市";

//        String startLonLat = mapd.getLonLat(start);
//        String endLonLat = mapd.getLonLat(end);
//
//        System.out.println("起始地："+start+",经纬度："+startLonLat);
//        System.out.println("终点："+end+",经纬度："+endLonLat);

        Long dis = getDistanceByAdress(start,end);

        System.out.println("两点间距离："+dis+"米");
    }
}
