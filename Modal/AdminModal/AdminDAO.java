package AdminModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ketnoimodal.KetNoi;

public class AdminDAO {
	public Admin checkLogin(String username, String password) throws Exception {
        KetNoi kn = new KetNoi();
        kn.ketNoi();

        String sql = "SELECT * FROM Admin WHERE username = ? AND password = ?";
        PreparedStatement stmt = kn.cn.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        Admin ad =null;
        if(rs.next()) {
        	int adminID = rs.getInt("adminID");
        	String hoTen = rs.getString("hoTen");
        	ad=new Admin(adminID,username,password,hoTen);
        	
        }
        rs.close();
        
        kn.cn.close();
        
        
        
        return ad;
    }
}
