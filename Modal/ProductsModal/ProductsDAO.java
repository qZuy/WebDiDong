package ProductsModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ketnoimodal.KetNoi;

public class ProductsDAO {

    public ArrayList<Products> getAllProducts() throws Exception {
        ArrayList<Products> productsList = new ArrayList<>();
        KetNoi kn = new KetNoi();
        kn.ketNoi();

        String sql = "SELECT * FROM Products";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        ResultSet rs = cmd.executeQuery();

        while (rs.next()) {
            productsList.add(new Products(
                rs.getInt("maDT"),
                rs.getString("tenDT"),
                rs.getInt("soLuong"),
                rs.getFloat("gia"),
                rs.getInt("maLoaiDT"),
                rs.getString("anh1"),
                rs.getString("anh2"),
                rs.getString("anh3"),
                rs.getString("manHinh"),
                rs.getString("heDieuHanh"),
                rs.getString("cameraTruoc"),
                rs.getString("cameraSau"),
                rs.getString("cpu"),
                rs.getString("gpu"),
                rs.getString("ram"),
                rs.getString("rom"),
                rs.getString("pin")
            ));
        }
        rs.close();
        cmd.close();
        kn.cn.close();

        return productsList;
    }

   public void insertProduct(String tenDT,int soLuong,float gia,int maLoaiDT,String anh1,
    String anh2,
     String anh3,
     String manHinh,
     String heDieuHanh,
    String cameraTruoc,
   String cameraSau,
    String cpu,
    String gpu,
   String ram,
    String rom,
    String pin) throws Exception {
        KetNoi kn = new KetNoi();
        kn.ketNoi();

        String sql = "INSERT INTO Products (tenDT, soLuong, gia, maLoaiDT, anh1, anh2, anh3, manHinh, heDieuHanh, "
                   + "cameraTruoc, cameraSau, cpu, gpu, ram, rom, pin) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        cmd.setString(1, tenDT);
        cmd.setInt(2, soLuong);
        cmd.setFloat(3, gia);
        cmd.setInt(4, maLoaiDT);
        cmd.setString(5, anh1);
        cmd.setString(6, anh2);
        cmd.setString(7, anh3);
        cmd.setString(8, manHinh);
        cmd.setString(9, heDieuHanh);
        cmd.setString(10, cameraTruoc);
        cmd.setString(11,cameraSau);
        cmd.setString(12, cpu);
        cmd.setString(13, gpu);
        cmd.setString(14, ram);
        cmd.setString(15, rom);
        cmd.setString(16, pin);

        cmd.executeUpdate();

        cmd.close();
        kn.cn.close();
    }

    public void updateProduct(String tenDT,int soLuong,float gia,int maLoaiDT,String anh1,
    	    String anh2,
    	     String anh3,
    	     String manHinh,
    	     String heDieuHanh,
    	    String cameraTruoc,
    	   String cameraSau,
    	    String cpu,
    	    String gpu,
    	   String ram,
    	    String rom,
    	    String pin,int maDT) throws Exception {
        KetNoi kn = new KetNoi();
        kn.ketNoi();

        String sql = "UPDATE Products SET tenDT = ?, soLuong = ?, gia = ?, maLoaiDT = ?, anh1 = ?, anh2 = ?, anh3 = ?, "
                   + "manHinh = ?, heDieuHanh = ?, cameraTruoc = ?, cameraSau = ?, cpu = ?, gpu = ?, ram = ?, rom = ?, pin = ? "
                   + "WHERE maDT = ?";

        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        cmd.setString(1, tenDT);
        cmd.setInt(2, soLuong);
        cmd.setFloat(3, gia);
        cmd.setInt(4, maLoaiDT);
        cmd.setString(5, anh1);
        cmd.setString(6, anh2);
        cmd.setString(7, anh3);
        cmd.setString(8, manHinh);
        cmd.setString(9, heDieuHanh);
        cmd.setString(10, cameraTruoc);
        cmd.setString(11,cameraSau);
        cmd.setString(12, cpu);
        cmd.setString(13, gpu);
        cmd.setString(14, ram);
        cmd.setString(15, rom);
        cmd.setString(16, pin);
        cmd.setInt(17, maDT);
        cmd.executeUpdate();

        cmd.close();
        kn.cn.close();
    }

    public void deleteProduct(int maDT) throws Exception {
        KetNoi kn = new KetNoi();
        kn.ketNoi();

        String sql = "DELETE FROM Products WHERE maDT = ?";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        cmd.setInt(1, maDT);

        cmd.executeUpdate();

        cmd.close();
        kn.cn.close();
    }

    public ArrayList<Products> getProductsByID(int maDT) throws Exception {
        ArrayList<Products> productsList = new ArrayList<>();
        KetNoi kn = new KetNoi();
        kn.ketNoi();

        String sql = "SELECT * FROM Products WHERE maDT = ?";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        cmd.setInt(1, maDT);

        ResultSet rs = cmd.executeQuery();

        while (rs.next()) {
            productsList.add(new Products(
                rs.getInt("maDT"),
                rs.getString("tenDT"),
                rs.getInt("soLuong"),
                rs.getFloat("gia"),
                rs.getInt("maLoaiDT"),
                rs.getString("anh1"),
                rs.getString("anh2"),
                rs.getString("anh3"),
                rs.getString("manHinh"),
                rs.getString("heDieuHanh"),
                rs.getString("cameraTruoc"),
                rs.getString("cameraSau"),
                rs.getString("cpu"),
                rs.getString("gpu"),
                rs.getString("ram"),
                rs.getString("rom"),
                rs.getString("pin")
            ));
        }

        rs.close();
        cmd.close();
        kn.cn.close();

        return productsList;
    }




    public ArrayList<Products> searchProducts(String keyword) throws Exception {
        ArrayList<Products> productsList = new ArrayList<>();
        KetNoi kn = new KetNoi();
        kn.ketNoi();

        String sql = "SELECT * FROM Products WHERE tenDT LIKE ? OR heDieuHanh LIKE ?";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        cmd.setString(1, "%" + keyword + "%");
        cmd.setString(2, "%" + keyword + "%");

        ResultSet rs = cmd.executeQuery();
        while (rs.next()) {
            productsList.add(new Products(
                rs.getInt("maDT"),
                rs.getString("tenDT"),
                rs.getInt("soLuong"),
                rs.getFloat("gia"),
                rs.getInt("maLoaiDT"),
                rs.getString("anh1"),
                rs.getString("anh2"),
                rs.getString("anh3"),
                rs.getString("manHinh"),
                rs.getString("heDieuHanh"),
                rs.getString("cameraTruoc"),
                rs.getString("cameraSau"),
                rs.getString("cpu"),
                rs.getString("gpu"),
                rs.getString("ram"),
                rs.getString("rom"),
                rs.getString("pin")
            ));
        }

        rs.close();
        cmd.close();
        kn.cn.close();

        return productsList;
    }
    
    
    public int getNumberPage() throws Exception{
    	String query ="select count(*) from Products";
    	try {
    		KetNoi kn=new KetNoi();
    		kn.ketNoi();
    		PreparedStatement cmd =kn.cn.prepareStatement(query);
    		ResultSet rs=cmd.executeQuery();
			while(rs.next()) {
				int total = rs.getInt(1);
				int countpage = 0;
				countpage=total/8;
				if(total %8 !=0) {
					countpage++;
				}
				return countpage;
			}
		} catch (Exception e) {
			
		}
    	return 0;
    }
    
    public ArrayList<Products> getPaging(int offset) throws Exception {
        ArrayList<Products> ds = new ArrayList<>();
        KetNoi kn = new KetNoi();
        kn.ketNoi();

        // Sử dụng OFFSET để phân trang
        String sql = "SELECT * FROM Products ORDER BY maDT OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        cmd.setInt(1, offset);
        ResultSet rs = cmd.executeQuery();

        while (rs.next()) {
            ds.add(new Products(
                rs.getInt("maDT"),
                rs.getString("tenDT"),
                rs.getInt("soLuong"),
                rs.getFloat("gia"),
                rs.getInt("maLoaiDT"),
                rs.getString("anh1"),
                rs.getString("anh2"),
                rs.getString("anh3"),
                rs.getString("manHinh"),
                rs.getString("heDieuHanh"),
                rs.getString("cameraTruoc"),
                rs.getString("cameraSau"),
                rs.getString("cpu"),
                rs.getString("gpu"),
                rs.getString("ram"),
                rs.getString("rom"),
                rs.getString("pin")
            ));
        }

        rs.close();
        kn.cn.close();
        return ds;
    }
    
    public ArrayList<Products> getPagingByCategory(int maloai, int offset) throws Exception {
        ArrayList<Products> ds = new ArrayList<>();
        KetNoi kn = new KetNoi();
        kn.ketNoi();

        String sql = "SELECT * FROM Products WHERE maLoaiDT = ? ORDER BY maDT OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        cmd.setInt(1, maloai);
        cmd.setInt(2, offset);
        ResultSet rs = cmd.executeQuery();

        while (rs.next()) {
            ds.add(new Products(
                rs.getInt("maDT"),
                rs.getString("tenDT"),
                rs.getInt("soLuong"),
                rs.getFloat("gia"),
                rs.getInt("maLoaiDT"),
                rs.getString("anh1"),
                rs.getString("anh2"),
                rs.getString("anh3"),
                rs.getString("manHinh"),
                rs.getString("heDieuHanh"),
                rs.getString("cameraTruoc"),
                rs.getString("cameraSau"),
                rs.getString("cpu"),
                rs.getString("gpu"),
                rs.getString("ram"),
                rs.getString("rom"),
                rs.getString("pin")
            ));
        }

        rs.close();
        cmd.close();
        kn.cn.close();
        return ds;
    }
    public boolean checkdt(String tenDT) throws Exception {
	    KetNoi kn = new KetNoi();  // Kết nối cơ sở dữ liệu
	    kn.ketNoi();  // Mở kết nối

	    String sql = "SELECT COUNT(*) FROM Products WHERE TenDT = ?";
	    try (PreparedStatement stmt = kn.cn.prepareStatement(sql)) {
	        stmt.setString(1, tenDT);  // Gán giá trị vào câu lệnh SQL
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                return rs.getInt(1) > 0;  // Nếu có dòng dữ liệu, nghĩa là sách đã tồn tại
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw e;  // Ném lại ngoại lệ nếu có lỗi
	    } finally {
	        kn.cn.close();  // Đảm bảo đóng kết nối sau khi thực hiện xong
	    }
	    return false;  // Nếu không có sách, trả về false
	}
}
