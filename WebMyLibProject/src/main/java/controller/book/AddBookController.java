package controller.book;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.book.BookDAO;
import biz.book.BookVO;
import controller.Controller;

public class AddBookController implements Controller{
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String isbnString = request.getParameter("isbn");
		int isbn = 0; // 기본값 설정

		if (isbnString != null && !isbnString.isEmpty()) {
		    try {
		        isbn = Integer.parseInt(isbnString);
		    } catch (NumberFormatException e) {
		        e.printStackTrace();
		        // 숫자로 변환할 수 없는 경우에 대한 예외 처리
		    }
		}
		
		String name = request.getParameter("name");  
		String writer = request.getParameter("writer");  
		String publisher = request.getParameter("publisher");  
//		String receive = request.getParameter("receive");
		
		BookVO vo = new BookVO();
		vo.setIsbn(isbn);
		vo.setName(name);
		vo.setWriter(writer);
		vo.setPublisher(publisher);
		
//		Calendar calendar = Calendar.getInstance();
//		calendar.add(Calendar.DAY_OF_MONTH, 7);
//		Date futureDate = calendar.getTime();
//		vo.setReceive(futureDate);
		
		BookDAO dao = new BookDAO();
		dao.addBook(vo);
		
		return "/homepage.jsp";
	}

}
