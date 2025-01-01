package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CategoriesModal.CategoriesBO;
import ProductsModal.Products;
import ProductsModal.ProductsBO;



/**
 * Servlet implementation class ControllerStore
 */
@WebServlet("/ControllerStore")
public class ControllerStore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerStore() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
	        response.setCharacterEncoding("utf-8");
	        
	        String keyword = request.getParameter("keyword");
	        String ml = request.getParameter("ml"); 
	        String pageParam = request.getParameter("page"); 
            int page = (pageParam != null && !pageParam.isEmpty()) ? Integer.parseInt(pageParam) : 1;
            
	        CategoriesBO cbo = new CategoriesBO();
	        ProductsBO pbo=new ProductsBO();
	        int totalPages = pbo.getNumberPage();
            int offset = (page - 1) * 8; 
	        ArrayList<Products> ds;
	        if (keyword != null && !keyword.isEmpty()) {
                ds = pbo.searchProducts(keyword); 
            } else if (ml != null && !ml.isEmpty()) {
                try {
                    int maLoai = Integer.parseInt(ml); 
                    ds = pbo.getPagingByCategory(maLoai, offset);
                     
                } catch (Exception e) {
                    ds = new ArrayList<>();
                }
            } else {
                ds = pbo.getPaging(offset);
            }
            
	        request.setAttribute("totalPages", totalPages); 
            request.setAttribute("currentPage", page); 

	        request.setAttribute("dsdt", ds); 
	        request.setAttribute("dsloai", cbo.getcategories()); 


                request.getRequestDispatcher("Store.jsp").forward(request, response);
            
		} catch (Exception e) {
		
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
