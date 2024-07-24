package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.MemberDAO;
import model.vo.Member;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id = request.getParameter("id");
		
		MemberDAO dao = new MemberDAO();
		Member member = null;
		
		boolean check = false;
		
		try {
			member = dao.searchMember(id);
			check = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(check) {
			request.setAttribute("info", member);
			request.getRequestDispatcher("search_ok.jsp").forward(request, response);
		} else {
			response.sendRedirect("search_fail.jsp");
		}
		// 중복 여부 판단 후 결과페이지 2개 -> 회원가입 성공했을 때, 실패했을 때
//		if(check) {
//			// 3. 바인딩 : 결과 페이지에 서버에서 받은 값 보낼 때
//			request.setAttribute("name", name);
//			
//			// 4. 네비게이션 : 결과 페이지 지정 - result.jsp
//			// response.sendRedirect("result.jsp"); // 응답 페이지 'result.jsp'로 보내겠다
//			// 만약 결과 페이지로 서버에서 받은 값 보여주려면
//			//	-> RequestDispatcher forward 방식으로 보내야 함
//			request.getRequestDispatcher("result.jsp").forward(request, response);
//		} else {
//			response.sendRedirect("fail.jsp");
//		}
		
	}

}
