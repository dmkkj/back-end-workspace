package controller.component;

import java.io.IOException;
import java.sql.SQLException;

import controller.Controller;
import controller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dao.MemberDAO;
import model.vo.Member;

public class LoginController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
	
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	MemberDAO dao = new MemberDAO();
	Member member = dao.login(id, password);
		
	HttpSession session = request.getSession();
	session.setAttribute("member", member);
	
	return new ModelAndView("index.jsp");

	}

}


