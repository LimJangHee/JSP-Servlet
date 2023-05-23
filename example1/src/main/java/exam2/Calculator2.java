package exam2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class calculator
 */
@WebServlet("/Calculator2")
public class Calculator2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Calculator2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// Ŭ���̾�Ʈ�� �������� ������ ��û
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		// ���� ��û���� ���۵� ��� ��Ű�� ������(cookie �迭�� ��ȯ)
		Cookie[] cookies = request.getCookies();
		// ��Ű �迭�� null�� �ƴ��� Ȯ��
		if (cookies != null) {
			// cookies�迭�� �� ��ҿ� ���� �ݺ����� ����
			for (Cookie cookie : cookies) {
				// ���� �ݺ� ���� cookie��ü�� �̸��� count�� �ƴ��� Ȯ��
				// count�ʹ� ������ �����Ͽ� ó���ϱ� ���ؼ� ���
				if (!cookie.getName().equals("count")) {
					// count�� �ƴ� ��Ű�� ���� ���� url ���ڵ��� �����Ͽ� ������ ���ڿ��� ��ȯ
					String decodedValue = URLDecoder.decode(cookie.getValue(), "UTF-8");
					out.println("<h3>" + decodedValue + "</h3>");
				}
			}
		}

		out.println("<form method='post' action='./Calculator2'>");
		// required : �� ���� ����Ǵ� ���� ���� -> �ʼ� �Է°��� ������ ���
		out.println("<input type='number' name='num1' placeholder='num1' required >");
		out.println("<input type='number' name='num2' placeholder='num2' required >");
		out.println("<select name='operator'>");
		out.println("<option value='+'>+</option>");
		out.println("<option value='-'>-</option>");
		out.println("<option value='x'>x</option>");
		out.println("<option value='/'>/</option>");
		out.println("</select>");
		out.println("<input type='submit' value='���'></form>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// Ŭ���̾�Ʈ�� �������� �����͸� �����ϰ� ������Ʈ�� �� ���
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String operator = request.getParameter("operator");

		float result = 0;
		switch (operator) {
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = num1 - num2;
			break;
		case "x":
			result = num1 * num2;
			break;
		case "/":
			result = (num1 / (float) num2);
			break;
		}

		int cnt = 0;
		Cookie[] cookies = request.getCookies();
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			// ���� �ں� ���� cookies �迭�� i�ε����� �ش��ϴ� cookie ��ü�� �̸��� count���� Ȯ��
			if (cookies[i].getName().equals("count")) {
				// ���� �̸��� count�� ��Ű�� ã���� �ش� ��Ű�� ���� ������ ��ȯ�Ͽ� cnt ������ �Ҵ�
				cnt = Integer.parseInt(cookies[i].getValue());
				break;
			}
		}
		
		// ��½� ���ڰ� ����ϱ� ���ؼ� ������ ����
		String value = num1 + " " + operator + " " + num2 + " = " + result;
		// value���� UTF-8�� ���ڵ��Ͽ�(���� ����� �޶���) encodevalue ������ �Ҵ�
		// URL���� ����� �� �ִ� ���·� ��ȯ
		String encodedValue = URLEncoder.encode(value, "UTF-8");
		// cnt���� ����Ͽ� cookie��ü�� ����, encodevalue�� ��Ű�� ������ �����ϰ� cnt�� ���ڿ��� ��ȯ�Ͽ� ��Ű�� �̸����� ���
		Cookie cookie = new Cookie(cnt++ + "", encodedValue);
		// cnt���� ����Ͽ� cntcookie��ü�� ����, ������ ���� cnt���� �����ϱ� ���� ��Ű
		// �湮 Ƚ���� �����Ͽ� ���� ���� ������ �ƴ� ��� ������ �� �ֵ���
		Cookie cntCookie = new Cookie("count", cnt + "");

		// cookie, cntcookie ��ü�� http ���信 �߰�, ������ Ŭ���̾�Ʈ�� ��Ű�� ����
		// Ŭ���̾�Ʈ�� ���� ��Ű�� �����ϰ� ���߿� �ٽ� ������ ���� �� ����
		response.addCookie(cookie);
		response.addCookie(cntCookie);
		response.sendRedirect("Calculator2");
	}

}