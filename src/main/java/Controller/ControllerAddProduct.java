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
import ProductsModal.ProductsBO;

/**
 * Servlet implementation class ControllerAddProduct
 */
@WebServlet("/ControllerAddProduct")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class ControllerAddProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAddProduct() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            CategoriesBO cbo = new CategoriesBO();

            request.setAttribute("danhSachLoai", cbo.getcategories());
            request.getRequestDispatcher("AddProduct.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
          

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

            ProductsBO pbo = new ProductsBO();
            boolean isExist = pbo.checkdt(tenDT);
            if (isExist) {
                // If product code already exists, display an error message
                request.setAttribute("errorMessage", "Tên điện thoại đã có trong cửa hàng");
                CategoriesBO cbo = new CategoriesBO();
                request.setAttribute("danhSachLoai", cbo.getcategories());
                request.getRequestDispatcher("AddProduct.jsp").forward(request, response);
                return;
            }

            String uploadPath = getServletContext().getRealPath("") + File.separator + "image_dt";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
           
            String anh1 = handleFileUpload(request, "anh1", uploadPath);
            String anh2 = handleFileUpload(request, "anh2", uploadPath);
            String anh3 = handleFileUpload(request, "anh3", uploadPath);

            pbo.insertProduct(tenDT, soLuong, gia, maLoaiDT, anh1, anh2, anh3, manHinh, heDieuHanh, cameraTruoc, cameraSau, cpu, gpu, ram, rom, pin);
            // Redirect to success page
             request.setAttribute("message", "Thêm thành công!");
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
        return null; 
    }


    private String handleFileUpload(HttpServletRequest request, String inputName, String uploadPath)
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
        return null; // Return null if no file was uploaded for this input
    }

}