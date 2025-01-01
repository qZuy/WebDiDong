package CartModal;

public class Cart {
    private int id;          // Mã sản phẩm
    private String name;     // Tên sản phẩm
    private float gia;       // Giá sản phẩm
    private int soluong;     // Số lượng

    public Cart(int id, String name, float gia, int soluong) {
        this.id = id;
        this.name = name;
        this.gia = gia;
        this.soluong = soluong;
    }

    // Getters và setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    // Tính thành tiền (giá * số lượng)
    public float getThanhTien() {
        return gia * soluong;
    }
}
