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
    // �����͸� ������ ��
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// �Է�, ���, ���ڵ�, ���ڵ� ���ڼ� ����
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		// ��� HTML ���� ����� ���� �ν� ����
		PrintWriter out = response.getWriter();
		
		// �������κ��� ��Ű ��������
		Cookie[] cookies = request.getCookies();
		
		// ��Ű�� �ִ��� Ȯ��
		if(cookies != null) 
		{
			// ��Ű�� ������ ���
			for(Cookie cookie : cookies) 
			{
				out.println("cookie :"+cookie.getName()+":"+cookie.getValue()+"<br/>");
			}
		}
		
		
				
		// name�� value �Է¹޴� html �� ����
		out.println("<form method='post' action='CookieTestServlet2'>");
		// method : ������ ����� ����(doPost), action : �׶� ������ servlet
		// �� ���� �����ϸ� doPost�� �Ѿ
		out.println("name<input type='text' name='name'/>");
		out.println("value<input type='text' name='value'/>");
		out.println("<input type='submit'/>");
		out.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	// �����͸� �ٲ��� ��(?)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ������ POST�� ��û�̿���
		// request���� name, value ����
		String name = request.getParameter("name");
		String value = request.getParameter("value");
		
		// ��Ű�� ����
		Cookie c = new Cookie(name, value);
		response.addCookie(c);
		
		// ��Ű�� add�� �� servlet�� �� ȣ��
		response.sendRedirect("CookieTestServlet2");
	}

}