package com.etc.dao;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import javax.xml.ws.spi.http.HttpContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
public class MapDistance {
    public static final String MAP_KEY ="fb984f3aaa64a50dd2ffc98545435540";
   // public static final String MAP_KEY ="9b2c5c13a6501227c97613b559324a12";

    public static long getDistanceByAdress(String start,String end){
        String startLonLat = getLonLat(start);
        String endLonLat = getLonLat(end);
        long dis = getDistance(startLonLat,endLonLat);
        return dis;
    }

    /**
     *  获取
     * @param address 输入地址
     * @return 返回经纬度
     */
    public static String getLonLat(String address){

//返回输入地址address的经纬度信息, 格式是 经度,纬度
        String queryUrl = "http://restapi.amap.com/v3/geocode/geo?key="+MAP_KEY+"&address="+address;
        //System.out.println(queryUrl);
        //String queryResult = getResponse(queryUrl); //高德接品返回的是JSON格式的字符串
        String queryResult = sendGetByApache(queryUrl);
        //System.out.println(queryResult);
        JSONObject job = JSONObject.parseObject(queryResult);
        JSONObject jobJSON = JSONObject.parseObject(job.get("geocodes").toString().substring(1, job.get("geocodes").toString().length()-1));
        String DZ = jobJSON.get("location").toString();
        //System.out.println("经纬度："+DZ);
        return DZ;
    }

    // 将经纬度getLng， getLat 通过getAmapByLngAndLat方法转换地址
    public static String getAmapByLngAndLat(String getLng, String getLat) throws Exception {
        String url;
        try {
            url = "http://restapi.amap.com/v3/geocode/regeo?output=JSON&location=" + getLng + "," + getLat
            + "&key="+MAP_KEY+"&radius=0&extensions=base";
            String queryResult = getResponse(url); // 高德接品返回的是JSON格式的字符串
            if (queryResult == null) {
                return "-1";
            }
// 将获取结果转为json 数据
            JSONObject obj = JSONObject.parseObject(queryResult);
            if (obj.get("status").toString().equals("1")) {
// 如果没有返回-1

                JSONObject regeocode = obj.getJSONObject("regeocode");
                if (regeocode.size() > 0) {
                    // 在regeocode中拿到 formatted_address 具体位置
                    String formatted = regeocode.get("formatted_address").toString();
                    return formatted;

                } else {
                    System.out.println("未找到相匹配的地址！");
                    return "-1";

                }
            } else {
                System.out.println("请求错误！");
                return "-1";
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "-1";
    }
    /**

     2.经纬度算出两点间距离
     */
    public static long getDistance(String startLonLat, String endLonLat){
//返回起始地startAddr与目的地endAddr之间的距离，单位：米
        Long result = new Long(0);
        String queryUrl = "http://restapi.amap.com/v3/distance?key="+MAP_KEY+"&origins="+startLonLat+"&destination="+endLonLat;
        String queryResult = getResponse(queryUrl);
        JSONObject job = JSONObject.parseObject(queryResult);
        JSONArray ja = job.getJSONArray("results");
        JSONObject jobO = JSONObject.parseObject(ja.getString(0));
        result = Long.parseLong(jobO.get("distance").toString());
        System.out.println("距离："+result);
        return result;
    }
    /**

     3.发送请求
     */
    public static String getResponse(String serverUrl){
//用JAVA发起http请求，并返回json格式的结果
        StringBuffer result = new StringBuffer();
        try {
            URL url = new URL(serverUrl);

            URLConnection conn = url.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while((line = in.readLine()) != null){
                result.append(line);

            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    private static String sendGetByApache(String url) {
        StringBuilder buffer = new StringBuilder();

        DefaultHttpClient client = new DefaultHttpClient();
        try {
            HttpGet get = new HttpGet(url);
            HttpResponse response = client.execute(get);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent()));
                String str;
                while ((str = br.readLine()) != null) {
                    buffer.append(str);
                }
                br.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.getConnectionManager().shutdown();
        }

        return buffer.toString();
    }

}