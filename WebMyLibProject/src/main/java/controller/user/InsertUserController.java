package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.user.UserDAO;
import biz.user.UserVO;
import controller.Controller;

public class InsertUserController implements Controller{
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String role = request.getParameter("role");
		
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		vo.setName(name);
		vo.setBirth(birth);
		vo.setEmail(email);
		vo.setPhone(phone);
		vo.setRole(role);
		
		UserDAO dao = new UserDAO();
		dao.insertUser(vo);
		
		return "/homepage.jsp";
	}
	
}
