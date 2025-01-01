package CategoriesModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ketnoimodal.KetNoi;

public class CategoriesDAO {
	public ArrayList<Categories> getcategories() throws Exception{
		ArrayList<Categories> ds=new ArrayList<Categories>();
		KetNoi kn=new KetNoi();
		kn.ketNoi();
		
		String sql="select*from Categories";
		
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		ResultSet rs=cmd.executeQuery();
		
		while (rs.next()) {
	        int maLoaiDT = rs.getInt("maLoaiDT");
	        String tenLoaiDT = rs.getString("tenLoaiDT");

	        
	        Categories categories = new Categories(maLoaiDT, tenLoaiDT);
	        ds.add(categories);
	    }

	    rs.close();
	    cmd.close();
	    kn.cn.close();

	    return ds;
	}
	
	public boolean themLoaiDT(String tenLoaiDT) throws Exception {
        KetNoi kn = new KetNoi();
        kn.ketNoi();
        
        String sql = "INSERT INTO Categories (tenLoaiDT) VALUES (?)";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        cmd.setString(1, tenLoaiDT);
        
        int n = cmd.executeUpdate(); 
        cmd.close();
        kn.cn.close();
        
        return n > 0; 
    }
	
	public boolean suaLoaiDT(int maLoaiDT, String tenLoaiDTMoi) throws Exception {
        KetNoi kn = new KetNoi();
        kn.ketNoi();
        
        String sql = "UPDATE Categories SET tenLoaiDT = ? WHERE maLoaiDT = ?";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        cmd.setString(1, tenLoaiDTMoi);
        cmd.setInt(2, maLoaiDT);
        
        int n = cmd.executeUpdate();
        cmd.close();
        kn.cn.close();
        
        return n > 0;
    }
	
	public boolean xoaLoaiDT(int maLoaiDT) throws Exception {
        KetNoi kn = new KetNoi();
        kn.ketNoi();
        
        String sql = "DELETE FROM Categories WHERE maLoaiDT = ?";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        cmd.setInt(1, maLoaiDT);
        
        int n = cmd.executeUpdate();
        cmd.close();
        kn.cn.close();
        
        return n > 0;
    }
	
	public boolean checkLoaiDT(int maLoaiDT) throws Exception {
        KetNoi kn = new KetNoi();
        kn.ketNoi();
        
        String sql = "SELECT COUNT(*) FROM Categories WHERE maLoaiDT = ?";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        cmd.setInt(1, maLoaiDT);
        ResultSet rs = cmd.executeQuery();
        
        boolean exit = false;
        if (rs.next()) {
            exit = rs.getInt(1) > 0;
        }
        
        rs.close();
        cmd.close();
        kn.cn.close();
        
        return exit;
    }
	
	public Categories getLoaiDTById(int maLoaiDT) throws Exception {
        KetNoi kn = new KetNoi();
        kn.ketNoi();
        
        String sql = "SELECT * FROM Categories WHERE maLoaiDT = ?";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        cmd.setInt(1, maLoaiDT);
        
        ResultSet rs = cmd.executeQuery();
        Categories category = null;
        if (rs.next()) {
            String tenLoaiDT = rs.getString("tenLoaiDT");
            category = new Categories(maLoaiDT, tenLoaiDT);
        }
        
        rs.close();
        cmd.close();
        kn.cn.close();
        
        return category;
    }
}

