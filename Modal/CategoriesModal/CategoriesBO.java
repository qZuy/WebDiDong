package CategoriesModal;

import java.util.ArrayList;

public class CategoriesBO {
    CategoriesDAO categoriesDAO = new CategoriesDAO();

    // Lấy danh sách tất cả Categories
    public ArrayList<Categories> getcategories() throws Exception {
        return categoriesDAO.getcategories();
    }

    // Thêm mới một loại điện thoại
    public boolean themLoaiDT(String tenLoaiDT) throws Exception {
        return categoriesDAO.themLoaiDT(tenLoaiDT);
    }

    // Sửa thông tin loại điện thoại
    public boolean suaLoaiDT(int maLoaiDT, String tenLoaiDTMoi) throws Exception {
        return categoriesDAO.suaLoaiDT(maLoaiDT, tenLoaiDTMoi);
    }

    // Xóa loại điện thoại
    public boolean xoaLoaiDT(int maLoaiDT) throws Exception {
        return categoriesDAO.xoaLoaiDT(maLoaiDT);
    }

    // Kiểm tra sự tồn tại của loại điện thoại
    public boolean checkLoaiDT(int maLoaiDT) throws Exception {
        return categoriesDAO.checkLoaiDT(maLoaiDT);
    }

    // Lấy thông tin loại điện thoại theo ID
    public Categories getCategoryById(int maLoaiDT) throws Exception {
    	return categoriesDAO.getLoaiDTById(maLoaiDT);
    }
}
