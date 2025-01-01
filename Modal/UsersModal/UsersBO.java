package UsersModal;

import java.util.ArrayList;

public class UsersBO {
    private UsersDAO usersDAO;
    
    public UsersBO() {
        this.usersDAO = new UsersDAO();
    }

    // Kiểm tra đăng nhập
    public Users checkLogin(String email, String password) throws Exception {
            return usersDAO.checkLogin(email, password);
        
    }

    // Tạo tài khoản mới
    public boolean createUser(String name, String email, String password) {
        try {
            usersDAO.createUser(name, email, password);
            return true; // Trả về true nếu không có ngoại lệ
        } catch (Exception e) {
            e.printStackTrace(); // Log lỗi
            return false; // Trả về false nếu xảy ra ngoại lệ
        }
    }

    // Lấy danh sách người dùng
    public ArrayList<Users> getAllUsers() {
        try {
            return usersDAO.getAllUsers();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public int countUsers() {
        try {
            return usersDAO.countUsers();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
}
