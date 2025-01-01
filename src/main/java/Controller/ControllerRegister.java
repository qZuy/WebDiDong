package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import UsersModal.UsersBO;

/**
 * Servlet implementation class ControllerRegister
 */
@WebServlet("/ControllerRegister")
public class ControllerRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			UsersBO ubo= new UsersBO();
			
			String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");
	        String confirmPassword = request.getParameter("confirmPassword");
	        
	        if (name == null || email == null || password == null || confirmPassword == null) {
	            request.setAttribute("errorMessage", "Vui lòng điền đầy đủ thông tin.");
	            request.getRequestDispatcher("Register.jsp").forward(request, response);
	            return;
	        }
	        if (!password.equals(confirmPassword)) {
	            request.setAttribute("errorMessage", "Mật khẩu không khớp");
	            request.getRequestDispatcher("Register.jsp").forward(request, response);
	            return;
	        }
	        boolean isSuccess = ubo.createUser(name, email, password);
	        if (isSuccess) {
	            response.sendRedirect("ControllerLogin");
	        } else {
	            request.setAttribute("errorMessage", "Email đã tồn tại. Vui lòng thử lại!");
	            request.getRequestDispatcher("Register.jsp").forward(request, response);
	            return;
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
