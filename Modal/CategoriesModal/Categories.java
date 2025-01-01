package CategoriesModal;

public class Categories {
    private int maLoaiDT;
    private String tenLoaiDT;

    // Constructor
    public Categories() {}

    public Categories(int maLoaiDT, String tenLoaiDT) {
        this.maLoaiDT = maLoaiDT;
        this.tenLoaiDT = tenLoaiDT;
    }

    // Getter và Setter
    public int getMaLoaiDT() {
        return maLoaiDT;
    }

    public void setMaLoaiDT(int maLoaiDT) {
        this.maLoaiDT = maLoaiDT;
    }

    public String getTenLoaiDT() {
        return tenLoaiDT;
    }

    public void setTenLoaiDT(String tenLoaiDT) {
        this.tenLoaiDT = tenLoaiDT;
    }
}
