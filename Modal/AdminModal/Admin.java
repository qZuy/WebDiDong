package AdminModal;

public class Admin {
    private int adminID;       // Mã Admin
    private String username;   // Tên đăng nhập
    private String password;   // Mật khẩu
    private String hoTen;      // Họ và tên

    // Constructor không tham số
    public Admin() {
    }

    // Constructor đầy đủ tham số
    public Admin(int adminID, String username, String password, String hoTen) {
        this.adminID = adminID;
        this.username = username;
        this.password = password;
        this.hoTen = hoTen;
    }

    // Getter và Setter
    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    // Phương thức toString để hiển thị thông tin Admin
    @Override
    public String toString() {
        return "Admin{" +
                "adminID=" + adminID +
                ", username='" + username + '\'' +
                ", hoTen='" + hoTen + '\'' +
                '}';
    }
}
