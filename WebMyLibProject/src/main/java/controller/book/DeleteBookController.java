package controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.book.BookDAO;
import controller.Controller;

public class DeleteBookController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");  
        
        BookDAO dao = new BookDAO();
        dao.deleteBook(name);
        
        return "/homepage.jsp";
    }
}