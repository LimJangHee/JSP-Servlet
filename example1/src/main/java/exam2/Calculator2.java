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
	// 클라이언트가 서버에게 정보를 요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		// 현재 요청에서 전송된 모든 쿠키를 가져옴(cookie 배열을 반환)
		Cookie[] cookies = request.getCookies();
		// 쿠키 배열이 null이 아닌지 확인
		if (cookies != null) {
			// cookies배열의 각 요소에 대해 반복문을 실행
			for (Cookie cookie : cookies) {
				// 현재 반복 중인 cookie객체의 이름이 count가 아닌지 확인
				// count와는 별개로 구분하여 처리하기 위해서 사용
				if (!cookie.getName().equals("count")) {
					// count가 아닌 쿠키의 값에 대해 url 디코딩을 수행하여 원래의 문자열로 변환
					String decodedValue = URLDecoder.decode(cookie.getValue(), "UTF-8");
					out.println("<h3>" + decodedValue + "</h3>");
				}
			}
		}

		out.println("<form method='post' action='./Calculator2'>");
		// required : 빈 값이 제출되는 것을 방지 -> 필수 입력값이 있을때 사용
		out.println("<input type='number' name='num1' placeholder='num1' required >");
		out.println("<input type='number' name='num2' placeholder='num2' required >");
		out.println("<select name='operator'>");
		out.println("<option value='+'>+</option>");
		out.println("<option value='-'>-</option>");
		out.println("<option value='x'>x</option>");
		out.println("<option value='/'>/</option>");
		out.println("</select>");
		out.println("<input type='submit' value='계산'></form>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// 클라이언트가 서버에게 데이터를 제출하고 업데이트할 때 사용
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
			// 현재 박복 중인 cookies 배열의 i인덱스에 해당하는 cookie 객체의 이름이 count인지 확인
			if (cookies[i].getName().equals("count")) {
				// 만약 이름이 count인 쿠키를 찾으면 해당 쿠키의 값을 정수로 변환하여 cnt 변수에 할당
				cnt = Integer.parseInt(cookies[i].getValue());
				break;
			}
		}
		
		// 출력시 예쁘게 출력하기 위해서 공백을 생성
		String value = num1 + " " + operator + " " + num2 + " = " + result;
		// value값을 UTF-8로 인코딩하여(필터 적용시 달라짐) encodevalue 변수에 할당
		// URL에서 사용할 수 있는 형태로 변환
		String encodedValue = URLEncoder.encode(value, "UTF-8");
		// cnt값을 사용하여 cookie객체를 생성, encodevalue를 쿠키의 값으로 설정하고 cnt를 문자열로 변환하여 쿠키의 이름으로 사용
		Cookie cookie = new Cookie(cnt++ + "", encodedValue);
		// cnt값을 사용하여 cntcookie객체를 생성, 다음에 사용될 cnt값을 저장하기 위한 쿠키
		// 방문 횟수를 저장하여 기존 값에 갱신이 아닌 계속 생성될 수 있도록
		Cookie cntCookie = new Cookie("count", cnt + "");

		// cookie, cntcookie 객체를 http 응답에 추가, 서버는 클라이언트로 쿠키를 전송
		// 클라이언트는 받은 쿠키를 저장하고 나중에 다시 서버에 보낼 수 있음
		response.addCookie(cookie);
		response.addCookie(cntCookie);
		response.sendRedirect("Calculator2");
	}

}