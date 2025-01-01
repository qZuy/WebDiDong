package Controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


import CategoriesModal.CategoriesBO;
import ProductsModal.Products;
import ProductsModal.ProductsBO;

/**
 * Servlet implementation class ControllerEditProduct
 */
@WebServlet("/ControllerEditProduct")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class ControllerEditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerEditProduct() {
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
            CategoriesBO cbo = new CategoriesBO();
            if (madt != null && !madt.isEmpty()) {
                try {int maDT = Integer.parseInt(madt);
                	Products product = pbo.getProductsByID(maDT).get(0);
                	
		            request.setAttribute("dt",product);
		            request.setAttribute("danhSachLoai", cbo.getcategories());
		            request.getRequestDispatcher("EditProduct.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }}
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
          

            int maDT =Integer.parseInt(request.getParameter("mdt"));
            String tenDT =  getStringParameter(request, "tenDT");
            int maLoaiDT = Integer.parseInt(getStringParameter(request, "maLoaiDT"));
            int soLuong = Integer.parseInt(getStringParameter(request, "soLuong"));
            float gia = Float.parseFloat(getStringParameter(request, "gia"));
            String manHinh = getStringParameter(request, "manHinh");
            String heDieuHanh = getStringParameter(request, "heDieuHanh");
            String cameraTruoc = getStringParameter(request, "cameraTruoc");
            String cameraSau = getStringParameter(request, "cameraSau");
            String cpu = getStringParameter(request, "cpu");
            String gpu = getStringParameter(request, "gpu");
            String ram = getStringParameter(request, "ram");
            String rom = getStringParameter(request, "rom");
            String pin = getStringParameter(request, "pin");
            String anhCu1 = request.getParameter("anhCu1");
                String anhCu2 = request.getParameter("anhCu2");
                String anhCu3 = request.getParameter("anhCu3");
                 String uploadPath = getServletContext().getRealPath("") + File.separator + "image_dt";
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }
                String anh1 = handleFileUpload(request, "anh1", uploadPath,anhCu1);
                String anh2 = handleFileUpload(request, "anh2", uploadPath,anhCu2);
                String anh3 = handleFileUpload(request, "anh3", uploadPath,anhCu3);
          

            ProductsBO pbo = new ProductsBO();
            
            pbo.update(tenDT, soLuong, gia, maLoaiDT, anh1, anh2, anh3, manHinh, heDieuHanh, cameraTruoc, cameraSau, cpu, gpu, ram, rom, pin,maDT);

          request.setAttribute("message", "Chỉnh sửa thành công!");
            request.getRequestDispatcher("ControllerAdmin").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
     private String getStringParameter(HttpServletRequest request, String paramName) throws IOException, ServletException {
        Part part = request.getPart(paramName);
        if (part != null) {
            try (InputStream inputStream = part.getInputStream();
                 Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name())) {
                if (scanner.hasNextLine()) {
                    return scanner.nextLine();
                }
            }
        }
        return null; // Return null if the part doesn't exist or has no content
    }
  private String handleFileUpload(HttpServletRequest request, String inputName, String uploadPath,String anhCu)
            throws IOException, ServletException {
        Part filePart = request.getPart(inputName);
        String fileName = null;
          if (filePart != null && filePart.getSize() > 0) {
            fileName = filePart.getSubmittedFileName();
            if (fileName != null && !fileName.isEmpty()) {
                String filePath = uploadPath + File.separator + fileName;
                filePart.write(filePath);
                return "image_dt/" + fileName;
            }
        }
        return anhCu; // Return null if no file was uploaded for this input
    }

}