package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import LichsukhModal.Lichsukh;
import LichsukhModal.LichsukhBO;
import UsersModal.Users;

/**
 * Servlet implementation class ControllerHistorykh
 */
@WebServlet("/ControllerHistorykh")
public class ControllerHistorykh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerHistorykh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
	        Users us = (Users) session.getAttribute("dn");
	       
			int userId = us.getId();
            

            // Sử dụng LichsukhBO để lấy danh sách lịch sử
            LichsukhBO lichsukhBO = new LichsukhBO();
            List<Lichsukh> historyList = lichsukhBO.getlsid(userId);

            // Gửi danh sách lịch sử sang JSP
            request.setAttribute("historyList", historyList);
            request.getRequestDispatcher("HistoryKh.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Có lỗi xảy ra khi lấy dữ liệu lịch sử mua hàng.");
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
