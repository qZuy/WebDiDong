package AdminModal;

public class AdminBO {
private AdminDAO adDao;
    
    public AdminBO() {
        this.adDao = new AdminDAO();
    }

    // Kiểm tra đăng nhập
    public Admin checkLogin(String username, String password) throws Exception {
            return adDao.checkLogin(username, password);
        
    }
}
