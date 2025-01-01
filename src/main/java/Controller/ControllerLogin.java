package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import UsersModal.Users;
import UsersModal.UsersBO;
import nl.captcha.Captcha;

/**
 * Servlet implementation class ControllerLogin
 */
@WebServlet("/ControllerLogin")
public class ControllerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String email = request.getParameter("email");
			String password = request.getParameter("password");
	        String mess = null;
	        HttpSession session = request.getSession();
	        int d = 0;

	        // Kiểm tra số lần đăng nhập sai
	        if (session.getAttribute("dem") != null) {
	            d = (int) session.getAttribute("dem");
	        }
	        Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
	        String answer = request.getParameter("answer");
	        if (d >= 3 && (answer == null || !captcha.isCorrect(answer))) {
	            mess = "Mã CAPTCHA không đúng hoặc không được nhập!";
	            request.setAttribute("mess", mess);
	            RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
	            rd.forward(request, response);
	            return;
	        }
	        if (email != null && password != null) {
	        	UsersBO ubo = new UsersBO();
				Users kh = ubo.checkLogin(email, password);
	            if (kh!=null) {
	                // Nếu đăng nhập thành công
	                session.setAttribute("dn", kh);
	                response.sendRedirect("ControllerStore");
	                return;
	            } else {
	                // Nếu đăng nhập thất bại, cập nhật số lần đăng nhập sai
	                if (session.getAttribute("dem") == null) {
	                    session.setAttribute("dem", 0);
	                }
	                int dem = (int) session.getAttribute("dem");
	                dem++;
	                session.setAttribute("dem", dem);

	                mess = "Sai thông tin đăng nhập!";
	            }
	        }

	        // Gửi thông báo lỗi nếu có
	        request.setAttribute("mess", mess);
	        RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
	        rd.forward(request, response);
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
