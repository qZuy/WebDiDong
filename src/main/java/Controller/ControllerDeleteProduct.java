package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import ProductsModal.ProductsBO;


/**
 * Servlet implementation class ControllerDeleteProduct
 */
@WebServlet("/ControllerDeleteProduct")
public class ControllerDeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerDeleteProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        
        String madt = request.getParameter("mdt");
        ProductsBO pbo = new ProductsBO();
        
        if (madt != null && !madt.isEmpty()) {
            try {int maDT = Integer.parseInt(madt);
            	pbo.deleteProduct(maDT);
	            response.sendRedirect("ControllerAdmin");
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
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
