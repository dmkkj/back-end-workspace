package controller.component;

import java.io.IOException;
import java.sql.SQLException;

import controller.Controller;
import controller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.MemberDAO;
import model.vo.Member;

public class SearchController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		String id = request.getParameter("id");
		
		MemberDAO dao = new MemberDAO();
		Member member = dao.searchMember(id);
		
		if(member!=null) {
			request.setAttribute("member", member);
			return new ModelAndView("/views/search_ok.jsp");
		} 
		
		return new ModelAndView("/views/search_fail.jsp", true);
	}
	
}
