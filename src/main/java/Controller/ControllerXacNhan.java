package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import LichsukhModal.Lichsukh;
import LichsukhModal.LichsukhBO;


/**
 * Servlet implementation class ControllerXacNhan
 */
@WebServlet("/ControllerXacNhan")
public class ControllerXacNhan extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LichsukhBO lichsukhBO = new LichsukhBO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerXacNhan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
            

            // Sử dụng LichsukhBO để lấy danh sách lịch sử
            
            List<Lichsukh> historyList = lichsukhBO.getls();

            // Gửi danh sách lịch sử sang JSP
            request.setAttribute("historyList", historyList);
            request.getRequestDispatcher("XacNhan.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Có lỗi xảy ra khi lấy dữ liệu lịch sử mua hàng.");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String xacNhan = request.getParameter("xacNhan");
	        if (xacNhan != null && !xacNhan.isEmpty()) {
	            int mahd = Integer.parseInt(xacNhan);
	            
	            // Gọi bo để xác nhận đơn hàng
	            if (lichsukhBO.xacNhanDonHang(mahd)) {
	                // Nếu xác nhận thành công, chuyển lại về trang quản lý đơn hàng
	                response.sendRedirect("ControllerXacNhan");
	            } else {
	                // Xử lý khi xác nhận không thành công
	                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Không thể xác nhận đơn hàng.");
	            }
	        } else {
	            // Xử lý khi mã hóa đơn không hợp lệ
	            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Mã hóa đơn không hợp lệ.");
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
