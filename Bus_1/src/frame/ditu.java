package frame;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ditu {

private static final String BAIDU_APP_KEY = "42b8ececa9cd6fe72ae4cddd77c0da5d";



/**
* 返回输入地址的经纬度坐标 key lng(经度),lat(纬度)
*/
public static Map<String, String> getLatitude(String address) {
		try {
		// 将地址转换成utf-8的16进制
		address = URLEncoder.encode(address, "UTF-8");
		// 如果有代理，要设置代理，没代理可注释
		// System.setProperty("http.proxyHost","192.168.172.23");
		// System.setProperty("http.proxyPort","3209");
		
		URL resjson = new URL("http://api.map.baidu.com/geocoder?address="
		+ address + "&output=json&key=" + BAIDU_APP_KEY);
		BufferedReader in = new BufferedReader(new InputStreamReader(
		resjson.openStream()));
		String res;
		StringBuilder sb = new StringBuilder("");
		while ((res = in.readLine()) != null) {
		sb.append(res.trim());
		}
		in.close();
		String str = sb.toString();
		if(str!=null&&!str.equals("")){
		Map<String, String> map = null;
		int lngStart = str.indexOf("lng\":");
		int lngEnd = str.indexOf(",\"lat");
		int latEnd = str.indexOf("},\"precise");
		if (lngStart > 0 && lngEnd > 0 && latEnd > 0) {
		String lng = str.substring(lngStart + 5, lngEnd);
		String lat = str.substring(lngEnd + 7, latEnd);
		map = new HashMap<String, String>();
		map.put("lng", lng);
		map.put("lat", lat);
		return map;
		}
		}
		} catch (Exception e) {
		e.printStackTrace();
		}
		return null;
}

public static void main(String args[]) {
	
	SQLHelper aaa = new SQLHelper();
	aaa.getConnection();
	aaa.exesql("select * from Stop ");
	ResultSet rs=aaa.rs;
	try {
		while (rs.next()) {
			SQLHelper SQL_4 = new SQLHelper();
			SQL_4.getConnection();
			String a= "济南"+rs.getString(1)+"站";
			Map<String, String> map = ditu.getLatitude(a);
			if (null != map) {
				SQL_4.updatesql("update Stop set Longitude="+map.get("lng")+"  where name = '"+rs.getString(1)+"'");
				SQL_4.updatesql("update Stop set Latitude="+map.get("lat")+" where name = '"+rs.getString(1)+"'");

				}
		
		}
	} catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}

}
}

