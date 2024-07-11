package com.kh.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class A_Date {

	/*
	 * Date 
	 * - java.util 패키지에 속한 날짜와 시간을 다룰 목적으로 만들어진 클래스 (JDK 1.0)
	 * - Date의 메서드는 대부분 deprecated(비권장) 되어있지만 여전히 사용
	 * */
	public void method1() {
		// 기본 생성자로 객체를 생성하면 현재 시스템의 시간에 대한 정보를 가지고 객체 생성
		Date today = new Date(); // 기본생성자. import java.util.Date;
		System.out.println(today); // Thu Jul 11 11:46:21 KST 2024
		
		Date when = new Date(0);
		System.out.println(when); // Thu Jan 01 09:00:00 KST 1970		
		
		System.out.println("getTime : " + today.getTime()); // 1720666156917
		
		// Deprecated된 기능들!
		System.out.println("getYear : " + (today.getYear() + 1900) + "년");
		System.out.println("getMonth : " + (today.getMonth() + 1) + "월");
		System.out.println("getDate : " + today.getDate() + "일");
		System.out.println("getHours : " + today.getHours() + "시");
		System.out.println("getMinutes : " + today.getMinutes() + "분");
		System.out.println("getSeconds : " + today.getSeconds() + "초");
		
		// SimpleDateFormat : 날짜 데이터를 원하는 형태로 출력할 수 있도록 (H : 0~23, h : 1~12)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 (E) a HH시 mm분 ss초"); // 객체 생성
		String formatDate = sdf.format(today);
		// 2024년 7월 11일 (목) 오후 12시 14분 10초
		System.out.println(formatDate);
		
	}
	
	/*
	 * Calendar
	 * - Date 클래스를 개선한 추상 클래스 (JDK 1.1)
	 * - 여전히 단점이 존재
	 * */
	public void method2() {
		/*
		 * 추상 클래스이기 때문에 직접 객체 생성할 수 없다
		 * getInstance() 메서드로 Calendar 클래스를 구현한 클래스의 객체를 반환
		 * 태국 - BuddhistCalendar, 그 외 - GregorianCalendar
		 * */
		Calendar today = Calendar.getInstance();
		today = new GregorianCalendar();
		System.out.println(today);
		
		// 년, 월, 일, 시, 분, 초
		System.out.println("YEAR : " + today.get(Calendar.YEAR) + "년");
		System.out.println("MONTH : " + (today.get(Calendar.MONTH)+1) + "월");
		System.out.println("DATE : " + today.get(Calendar.DATE) + "일");
		System.out.println("HOUR : " + today.get(Calendar.HOUR) + "시"); // 0 ~ 11
		System.out.println("HOUR_OF_DAY : " + today.get(Calendar.HOUR_OF_DAY) + "시"); // 0 ~ 23시까지 
		System.out.println("MINUTE : " + today.get(Calendar.MINUTE) + "분");
		System.out.println("SECOND : " + today.get(Calendar.SECOND) + "초");
	
		System.out.println();
		
		// 날짜 지정
		Calendar date = Calendar.getInstance();
		date.set(2024, Calendar.JULY, 11);
//		date.set(2024, 7, 11);	// Sun Aug 11 12:33:51 KST 2024 '월'이 +1이 되어서 출력(default)
//		date.set(2024, 6, 11);	// Thu Jul 11 12:34:24 KST 2024

		// System.out.println(date); // java.util.GregorianCalendar[time=?,areFieldsSet=false,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,dstSavings=0,useDaylight=false,transitions=30,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2024,MONTH=7,WEEK_OF_YEAR=28,WEEK_OF_MONTH=2,DAY_OF_MONTH=11,DAY_OF_YEAR=193,DAY_OF_WEEK=5,DAY_OF_WEEK_IN_MONTH=2,AM_PM=1,HOUR=0,HOUR_OF_DAY=12,MINUTE=33,SECOND=29,MILLISECOND=235,ZONE_OFFSET=32400000,DST_OFFSET=0]
		System.out.println(date.getTime()); // Date 객체로 반환
		
		// SimpleDateFormat 사용 가능
		// 24-07-11 12:35:26
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		String result = sdf.format(date.getTime());
		System.out.println(result);
		
		// String result = sdf.format(date); 실행 시 아래 에러 발생!
		// java.lang.IllegalArgumentException: Cannot format given Object as a Date
		// 메서드 사용 시 리턴 타입이랑 매개변수 타입 확인하기 sdf.format()
	}
	
	
	public static void main(String[] args) {
		A_Date a = new A_Date();
//		a.method1();
		a.method2();
	}

}
