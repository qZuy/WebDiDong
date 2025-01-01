package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AssessModal.Assess;
import AssessModal.AssessBO;
import ProductsModal.Products;
import ProductsModal.ProductsBO;

/**
 * Servlet implementation class ControllerProduct
 */
@WebServlet("/ControllerProduct")
public class ControllerProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductsBO pbo = new ProductsBO();
        AssessBO abo=new AssessBO();
        String madt = request.getParameter("mdt");
        
        if (madt != null && !madt.isEmpty()) {
            try {
                int maDT = Integer.parseInt(madt);
                Products product = pbo.getProductsByID(maDT).get(0);
                ArrayList<Assess> reviews = abo.getAllAssess(maDT);
                request.setAttribute("Product", product);
                request.setAttribute("reviews", reviews);
                request.getRequestDispatcher("Product.jsp").forward(request, response); 
            } catch (Exception e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Lỗi khi lấy sản phẩm.");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Mã sản phẩm không hợp lệ.");
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
