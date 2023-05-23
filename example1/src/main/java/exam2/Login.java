//package exam2;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class Login
// */
//@WebServlet("/Login")
//public class Login extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public Login() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		// 클라이언트로부터 전달된 ID와 PW를 받습니다.
//        String inputId = request.getParameter("id");
//        String inputPassword = request.getParameter("password");
//
//        // IDPW.txt 파일의 경로
//        String filePath = "C:\\Users\\User\\eclipse-workspaceJSP\\example1\\src\\main\\java\\exam2\\IDPW.txt";
//
//        // 파일에서 읽어온 ID와 PW를 저장할 변수
//        String storedId = null;
//        String storedPassword = null;
//
//        // 파일을 읽기 위해 BufferedReader를 사용
//        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            // 파일에서 한 줄씩 읽어옴
//            while ((line = br.readLine()) != null) {
//                // 읽어온 줄을 ":"를 구분자로 분리하여 ID와 PW로 나눔
//                String[] parts = line.split(":");
//                if (parts.length == 2) {
//                    storedId = parts[0];
//                    storedPassword = parts[1];
//                    // 입력한 ID와 PW가 파일에 저장된 ID와 PW와 일치하는지 확인
//                    if (inputId.equals(storedId) && inputPassword.equals(storedPassword)) {
//                        // 일치할 경우 "로그인 되었습니다." 메시지를 출력하고 종료합니다.
//                        response.getWriter().println("로그인 되었습니다.");
//                        return;
//                    }
//                }
//            }
//        }
//
//        // 일치하지 않을 경우 "로그인에 실패하셨습니다." 메시지를 출력합니다.
//        response.getWriter().println("로그인에 실패하셨습니다.");
//    }
//
//	
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
