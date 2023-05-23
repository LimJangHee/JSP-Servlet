package ex5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieTestServlet2
 */
@WebServlet("/CookieTestServlet2")
public class CookieTestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieTestServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // 데이터를 가져올 때
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 입력, 출력, 인코딩, 디코딩 문자셋 설정
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		// 출력 HTML 파일 만들기 위한 인스 생성
		PrintWriter out = response.getWriter();
		
		// 브라우저로부터 쿠키 가져오기
		Cookie[] cookies = request.getCookies();
		
		// 쿠키가 있는지 확인
		if(cookies != null) 
		{
			// 쿠키가 있으면 출력
			for(Cookie cookie : cookies) 
			{
				out.println("cookie :"+cookie.getName()+":"+cookie.getValue()+"<br/>");
			}
		}
		
		
				
		// name과 value 입력받는 html 폼 생성
		out.println("<form method='post' action='CookieTestServlet2'>");
		// method : 나가는 방식을 지정(doPost), action : 그때 나가는 servlet
		// 즉 폼을 제출하면 doPost로 넘어감
		out.println("name<input type='text' name='name'/>");
		out.println("value<input type='text' name='value'/>");
		out.println("<input type='submit'/>");
		out.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	// 데이터를 바꿔줄 때(?)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 폼에서 POST로 요청이오면
		// request에서 name, value 추출
		String name = request.getParameter("name");
		String value = request.getParameter("value");
		
		// 쿠키로 저장
		Cookie c = new Cookie(name, value);
		response.addCookie(c);
		
		// 쿠키를 add한 후 servlet을 재 호출
		response.sendRedirect("CookieTestServlet2");
	}

}
