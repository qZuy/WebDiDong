package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import AssessModal.AssessBO;
import UsersModal.Users;

/**
 * Servlet implementation class ControllerAddReview
 */
@WebServlet("/ControllerAddReview")
public class ControllerAddReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAddReview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("Product.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
        Users us = (Users) session.getAttribute("dn");
        if (us == null) {
            response.sendRedirect("ControllerLogin");  // Nếu chưa đăng nhập, chuyển hướng đến trang đăng nhập
            return;
        }
		int userId = us.getId();
        int maDT = Integer.parseInt(request.getParameter("maDT")); 
        byte rating = Byte.parseByte(request.getParameter("rating"));
        String comment = request.getParameter("comment");
        String createdAt = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()); // Ngày giờ hiện tại

        // Xử lý dữ liệu và thêm đánh giá
        AssessBO assessBO = new AssessBO();
        try {
            assessBO.addAssess(userId, maDT, rating, comment, createdAt);
            
            response.sendRedirect("ControllerProduct?mdt=" + maDT);  // Ví dụ trang thành công
        } catch (Exception e) {
            e.printStackTrace();
            
        }
	}

}
