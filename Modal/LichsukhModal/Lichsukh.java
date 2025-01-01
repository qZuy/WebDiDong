package LichsukhModal;

public class Lichsukh {
    private int id; // int
    private int mahd; // int
    private String ngaymua; // datetime (định dạng String trong Java)
    private int madt; // int
    private String tendt; // nvarchar(255)
    private double gia; // float
    private int soluong; // int
    private double tong; // float
    private boolean trangthai; // bit (boolean trong Java)

    // Constructor
    public Lichsukh(int id, int mahd, String ngaymua, int madt, String tendt, double gia, int soluong, double tong, boolean trangthai) {
        this.id = id;
        this.mahd = mahd;
        this.ngaymua = ngaymua;
        this.madt = madt;
        this.tendt = tendt;
        this.gia = gia;
        this.soluong = soluong;
        this.tong = tong;
        this.trangthai = trangthai;
    }

    // Getters và Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getMahd() { return mahd; }
    public void setMahd(int mahd) { this.mahd = mahd; }

    public String getNgaymua() { return ngaymua; }
    public void setNgaymua(String ngaymua) { this.ngaymua = ngaymua; }

    public int getMadt() { return madt; }
    public void setMadt(int madt) { this.madt = madt; }

    public String getTendt() { return tendt; }
    public void setTendt(String tendt) { this.tendt = tendt; }

    public double getGia() { return gia; }
    public void setGia(double gia) { this.gia = gia; }

    public int getSoluong() { return soluong; }
    public void setSoluong(int soluong) { this.soluong = soluong; }

    public double getTong() { return tong; }
    public void setTong(double tong) { this.tong = tong; }

    public boolean isTrangthai() { return trangthai; }
    public void setTrangthai(boolean trangthai) { this.trangthai = trangthai; }
}

