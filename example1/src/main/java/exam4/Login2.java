package exam4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login2")
public class Login2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
  
/**
* @see HttpServlet#HttpServlet()
*/
public Login2() {
   super();
   // TODO Auto-generated constructor stub
}

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        
        // 1. IDPW.txt 파일에서 id와 pw 비교
        boolean isValidUser = checkCredentials(id, password);
        
        if (isValidUser) {
            // 2. 로그인 성공 시 main.jsp로 이동
            HttpSession session = request.getSession();
            session.setAttribute("userId", id);
            response.sendRedirect("exam4/main.jsp");
        } else {
            // 3. 로그인 실패 시 error.jsp로 이동
            response.sendRedirect("exam4/error.jsp");
        }
    }
    
    private boolean checkCredentials(String id, String password) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\User\\eclipse-workspaceJSP\\example1\\src\\main\\java\\exam2\\IDPW.txt"));
        String line;
        
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(":");
            
            if (parts.length == 2 && parts[0].equals(id) && parts[1].equals(password)) {
                reader.close();
                return true;
            }
        }
        
        reader.close();
        return false;
    }
}
