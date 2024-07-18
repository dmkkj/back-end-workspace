package config;

public interface ServerInfo {
	// 서버 정보 따로 저장해놓을 interface 하나 생성
	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	String URL = "jdbc:mysql://localhost:3306/member";
	String USER = "root";
	String PASSWORD = "qwer1234";
		
}
