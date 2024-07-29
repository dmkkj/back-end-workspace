 package controller.component;

import java.io.IOException;
import java.sql.SQLException;

import controller.Controller;
import controller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

/*
 * 컴포넌트
 * - 인터페이스 기반으로 작성된 재사용성이 강한 자바 클래스
 * */
public class RegisterController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		Member member = new Member(id, password, name);
		
		MemberDAO dao = new MemberDAO();
		dao.registerMember(member);	
		
		return new ModelAndView("index.jsp", true);
	}
	
}
