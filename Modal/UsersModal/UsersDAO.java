package UsersModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ketnoimodal.KetNoi;

public class UsersDAO {

    // Phương thức kiểm tra đăng nhập
    public Users checkLogin(String email, String password) throws Exception {
        KetNoi kn = new KetNoi();
        kn.ketNoi();

        String sql = "SELECT * FROM Users WHERE email = ? AND password = ?";
        PreparedStatement stmt = kn.cn.prepareStatement(sql);
        stmt.setString(1, email);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        Users us =null;
        if(rs.next()) {
        	int id = rs.getInt("id");
        	String name = rs.getString("name");
        	us=new Users(id,name,email,password);
        	
        }
        rs.close();
        
        kn.cn.close();
        
        
        
        return us;
    }

    // Phương thức tạo tài khoản
    public void createUser(String name, String email, String password) throws Exception {
        KetNoi kn = new KetNoi();
        kn.ketNoi();

        String sql = "INSERT INTO Users (name, email, password) VALUES (?, ?, ?)";
        PreparedStatement stmt = kn.cn.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, email);
        stmt.setString(3, password);
        stmt.executeUpdate();

        stmt.close();
        kn.cn.close();

    }
    

    // Phương thức lấy danh sách người dùng
    public ArrayList<Users> getAllUsers() throws Exception {
        ArrayList<Users> userList = new ArrayList<>();
        KetNoi kn = new KetNoi();
        kn.ketNoi();

        String sql = "SELECT * FROM Users";
        PreparedStatement stmt = kn.cn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Users user = new Users(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("password")
            );
            userList.add(user);
        }

        rs.close();
        stmt.close();
        kn.cn.close();

        return userList;
    }
    
    public int countUsers() throws Exception {
        int count = 0;
        KetNoi kn = new KetNoi();
        kn.ketNoi();

        String sql = "SELECT COUNT(*) AS total FROM Users";
        PreparedStatement stmt = kn.cn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            count = rs.getInt("total");
        }

        rs.close();
        stmt.close();
        kn.cn.close();

        return count;
    }
}

