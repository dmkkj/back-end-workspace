package com.kh.api.util;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParsing {

	public static void main(String[] args) {
		String serviceKey = "UNmnLkcNtzgMKivBzvyb3TdrsqmthwquJWOHYpkKXK6aXtSdhG1gbTQ6EOqATL5t3ApCJ2hySkej4pCTXuaAZg%3D%3D";
		String url = "https://apis.data.go.kr/6260000/FoodService/getFoodKr?serviceKey=" + serviceKey + "&numOfRows=396";
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url);	// Document import > org.w3c.dom.Document;
			
			doc.getDocumentElement().normalize();
			// 문서 제대로 긁어 왔는지 찍어서 확인해보기
			System.out.println(doc.getDocumentElement().getNodeName()); // 문서 제대로 긁어 왔다면 response. 읽을 준비 끝났다는 것. 이제 읽어오겠다는 것
			
			NodeList nList = doc.getElementsByTagName("item"); // 반환 타입이 NodeList. import > org.w3c.dom.NodeList;
			System.out.println("파싱할 데이터 수 : " + nList.getLength()); // 396
			
			for(int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);	// Node import > org.w3c.dom.Node;
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode; // import > org.w3c.dom.Element;
					System.out.println("MAIN_TITLE : " + getTagValue("MAIN_TITLE", eElement)); // 해당하는 정보 뽑아내기
					System.out.println("ADDR1 : " + getTagValue("ADDR1", eElement).trim());
					System.out.println("----------------------------------");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getTagValue(String tag, Element eElement) {
		NodeList nList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = nList.item(0);
		if(nValue == null) return null;
		return nValue.getNodeValue();
	}

}
