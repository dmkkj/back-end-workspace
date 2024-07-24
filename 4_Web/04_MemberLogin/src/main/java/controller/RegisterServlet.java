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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		MemberDAO dao = new MemberDAO(); // MVC에서 DB와 관련되어 있는 것 MemberDAO
//		Member member = null;
		
		try {
//			member = dao.registerMember(id, password, name);
			dao.registerMember(new Member(id, password, name));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		request.setAttribute("info", member);
		response.sendRedirect("index.jsp");
//		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
