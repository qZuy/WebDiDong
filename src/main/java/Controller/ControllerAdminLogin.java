package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AdminModal.Admin;
import AdminModal.AdminBO;
import nl.captcha.Captcha;

/**
 * Servlet implementation class ControllerAdminLogin
 */
@WebServlet("/ControllerAdminLogin")
public class ControllerAdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String username = request.getParameter("username");
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
	            RequestDispatcher rd = request.getRequestDispatcher("AdminLogin.jsp");
	            rd.forward(request, response);
	            return;
	        }
	        if (username != null && password != null) {
	        	AdminBO adbo = new AdminBO();
	        	
				Admin ad = adbo.checkLogin(username, password);
	            if (ad!=null) {
	                // Nếu đăng nhập thành công
	                session.setAttribute("ad", ad);
	                response.sendRedirect("ControllerAdmin");
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
	        RequestDispatcher rd = request.getRequestDispatcher("AdminLogin.jsp");
	        rd.forward(request, response);
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
