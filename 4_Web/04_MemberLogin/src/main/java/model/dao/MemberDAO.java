package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.vo.Member;

public class MemberDAO {

	public MemberDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection connect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/member", "root", "qwer1234");
	}
	
	
	public void close(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	
	public void close(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		close(ps, conn);
	}
	
	// DAO 개발할 때 중요한 것
	// 매개변수(파라미터)가 있으면 뭘 가지고 와야 되는지, 호출됐을 때 리턴타입 결과 출력이 어떤 게 필요한지
	// 필요하면 리턴타입, 없으면 void로 끝내버리기. 매개변수가 없으면 그냥 비어있는 거고.
	
	// 회원가입
	public void registerMember(Member member) throws SQLException {
//	public Member registerMember(String id, String password, String name) throws SQLException {
		Connection conn = connect();
		
		String query = "INSERT INTO member VALUES(?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
//		ps.setString(1, id);
//		ps.setString(2, password);
//		ps.setString(3, name);
		
		ps.setString(1, member.getId());
		ps.setString(2, member.getPassword());
		ps.setString(3, member.getName());
		
		ps.executeUpdate();
		
		close(ps, conn);
	}

	// 회원 검색
	public Member searchMember(String id) throws SQLException {
		Connection conn = connect();
		
		String query = "SELECT * FROM member WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		
		Member member = null;
		
		if(rs.next()) member = new Member(id, rs.getString("password"), rs.getString("name"));
	
		close(rs, ps, conn);
		
		return member;
	}
}
