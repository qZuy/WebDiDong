package ProductsModal;


import java.util.ArrayList;


public class ProductsBO {
    ProductsDAO pdao = new ProductsDAO();
    ArrayList<Products> ds;

    // Lấy danh sách tất cả sản phẩm
    public ArrayList<Products> getAllProducts() throws Exception {
        if (ds == null) {
            ds = pdao.getAllProducts();
        }
        return ds;
    }

    // Kiểm tra sản phẩm có tồn tại không theo ID
//    public boolean checkProduct(int maDT) throws Exception {
//        return pdao.getProductsByCategory(maDT) != null; // Kiểm tra trong database
//    }
    public boolean checkdt(String tenDT) throws Exception {
        return pdao.checkdt(tenDT);  // Kiểm tra trong database
    }

    // Thêm mới sản phẩm
    public void insertProduct(String tenDT, int soLuong, float gia, int maLoaiDT, String anh1, String anh2, 
                              String anh3, String manHinh, String heDieuHanh, String cameraTruoc, String cameraSau, 
                              String cpu, String gpu, String ram, String rom, String pin) throws Exception {
        pdao.insertProduct(tenDT, soLuong, gia, maLoaiDT, anh1, anh2, anh3, manHinh, heDieuHanh, cameraTruoc, cameraSau, cpu, gpu, ram, rom, pin); 
        ds=null;
    }

    // Cập nhật sản phẩm
    public void update(String tenDT, int soLuong, float gia, int maLoaiDT, String anh1, String anh2, 
            String anh3, String manHinh, String heDieuHanh, String cameraTruoc, String cameraSau, 
            String cpu, String gpu, String ram, String rom, String pin,int maDT) throws Exception {
		pdao.updateProduct(tenDT, soLuong, gia, maLoaiDT, anh1, anh2, anh3, manHinh, heDieuHanh, cameraTruoc, cameraSau, cpu, gpu, ram, rom, pin,maDT); 
		ds=null;
		}

    public ArrayList<Products> getProductsByID(int maDT) throws Exception {
        return pdao.getProductsByID(maDT); // Gọi phương thức này từ ProductsDAO
    }

    // Xóa sản phẩm
    public void deleteProduct(int maDT) throws Exception {
        pdao.deleteProduct(maDT);
        ds = null; // Làm mới danh sách
    }

    // Tìm kiếm sản phẩm theo từ khóa
    public ArrayList<Products> searchProducts(String keyword) throws Exception {
        return pdao.searchProducts(keyword);
    }
    
    
    
    
    public int getNumberPage() throws Exception {
        return pdao.getNumberPage(); 
    }


    // Lấy danh sách sách với phân trang
    public ArrayList<Products> getPaging(int offset) throws Exception {
        return pdao.getPaging(offset); // Fetch books with pagination from sachdao
    }
    
    public ArrayList<Products> getPagingByCategory(int maloai, int offset) throws Exception {
        return pdao.getPagingByCategory(maloai, offset);
    }

}
