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
//		// Ŭ���̾�Ʈ�κ��� ���޵� ID�� PW�� �޽��ϴ�.
//        String inputId = request.getParameter("id");
//        String inputPassword = request.getParameter("password");
//
//        // IDPW.txt ������ ���
//        String filePath = "C:\\Users\\User\\eclipse-workspaceJSP\\example1\\src\\main\\java\\exam2\\IDPW.txt";
//
//        // ���Ͽ��� �о�� ID�� PW�� ������ ����
//        String storedId = null;
//        String storedPassword = null;
//
//        // ������ �б� ���� BufferedReader�� ���
//        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            // ���Ͽ��� �� �پ� �о��
//            while ((line = br.readLine()) != null) {
//                // �о�� ���� ":"�� �����ڷ� �и��Ͽ� ID�� PW�� ����
//                String[] parts = line.split(":");
//                if (parts.length == 2) {
//                    storedId = parts[0];
//                    storedPassword = parts[1];
//                    // �Է��� ID�� PW�� ���Ͽ� ����� ID�� PW�� ��ġ�ϴ��� Ȯ��
//                    if (inputId.equals(storedId) && inputPassword.equals(storedPassword)) {
//                        // ��ġ�� ��� "�α��� �Ǿ����ϴ�." �޽����� ����ϰ� �����մϴ�.
//                        response.getWriter().println("�α��� �Ǿ����ϴ�.");
//                        return;
//                    }
//                }
//            }
//        }
//
//        // ��ġ���� ���� ��� "�α��ο� �����ϼ̽��ϴ�." �޽����� ����մϴ�.
//        response.getWriter().println("�α��ο� �����ϼ̽��ϴ�.");
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
