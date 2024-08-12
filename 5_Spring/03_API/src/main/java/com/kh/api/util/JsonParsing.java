package com.kh.api.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonParsing {

	public static void main(String[] args) {
		String serviceKey = "UNmnLkcNtzgMKivBzvyb3TdrsqmthwquJWOHYpkKXK6aXtSdhG1gbTQ6EOqATL5t3ApCJ2hySkej4pCTXuaAZg%3D%3D";
		String url = "https://apis.data.go.kr/6260000/FoodService/getFoodKr?serviceKey=" + serviceKey + "&numOfRows=10&resultType=json";
		
		try {
			URL requestUrl = new URL(url); // import java.net.URL;
			HttpURLConnection urlConnection = (HttpURLConnection) requestUrl.openConnection();
			urlConnection.setRequestMethod("GET");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String line = null;
			
			StringBuffer responseBuffer = new StringBuffer();
			
			while((line = br.readLine())!=null) {
				responseBuffer.append(line);
			}
			br.close();
			urlConnection.disconnect();
			
			String responseData = responseBuffer.toString();
			System.out.println(responseData);
			// json 구조로(Object 구조)써야 하는데.. pom.xml에 JSON <<dependency> 코드 추가!
			JSONObject jsonResponse = new JSONObject(responseData);
			
			JSONObject jsonData = jsonResponse.getJSONObject("getFoodKr"); // Object 형태로 하나씩 가지고 와야 함
			System.out.println(jsonData);
			
			JSONArray items = jsonData.getJSONArray("item"); // 배열로 되어있는 item 가져오기
			
//			for(Object json : items) {
//				System.out.println(json);
//			}
			
			for(int i = 0; i < items.length(); i++) {
				JSONObject result = items.getJSONObject(i);
				System.out.println(result.getString("MAIN_TITLE"));	// 해당하는 MAIN_TITLE만 뽑아오기
				System.out.println(result.getDouble("LNG")); // 위도
				System.out.println(result.getDouble("LAT")); // 경도
				System.out.println("-------------------------------");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
