package ProductsModal;



public class Products {
    private int maDT;
    private String tenDT;
    private int soLuong;
    private float gia; 
    private int maLoaiDT;
    private String anh1;
    private String anh2;
    private String anh3;
    private String manHinh;
    private String heDieuHanh;
    private String cameraTruoc;
    private String cameraSau;
    private String cpu;
    private String gpu;
    private String ram;
    private String rom;
    private String pin;

    // Constructor
    public Products() {}

    public Products(int maDT, String tenDT, int soLuong, float gia, int maLoaiDT, String anh1, String anh2, 
                    String anh3, String manHinh, String heDieuHanh, String cameraTruoc, String cameraSau, 
                    String cpu, String gpu, String ram, String rom, String pin) {
        this.maDT = maDT;
        this.tenDT = tenDT;
        this.soLuong = soLuong;
        this.gia = gia;
        this.maLoaiDT = maLoaiDT;
        this.anh1 = anh1;
        this.anh2 = anh2;
        this.anh3 = anh3;
        this.manHinh = manHinh;
        this.heDieuHanh = heDieuHanh;
        this.cameraTruoc = cameraTruoc;
        this.cameraSau = cameraSau;
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.rom = rom;
        this.pin = pin;
    }

	public int getMaDT() {
		return maDT;
	}

	public void setMaDT(int maDT) {
		this.maDT = maDT;
	}

	public String getTenDT() {
		return tenDT;
	}

	public void setTenDT(String tenDT) {
		this.tenDT = tenDT;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public float getGia() {
		return gia;
	}

	public void setGia(float gia) {
		this.gia = gia;
	}

	public int getMaLoaiDT() {
		return maLoaiDT;
	}

	public void setMaLoaiDT(int maLoaiDT) {
		this.maLoaiDT = maLoaiDT;
	}

	public String getAnh1() {
		return anh1;
	}

	public void setAnh1(String anh1) {
		this.anh1 = anh1;
	}

	public String getAnh2() {
		return anh2;
	}

	public void setAnh2(String anh2) {
		this.anh2 = anh2;
	}

	public String getAnh3() {
		return anh3;
	}

	public void setAnh3(String anh3) {
		this.anh3 = anh3;
	}

	public String getManHinh() {
		return manHinh;
	}

	public void setManHinh(String manHinh) {
		this.manHinh = manHinh;
	}

	public String getHeDieuHanh() {
		return heDieuHanh;
	}

	public void setHeDieuHanh(String heDieuHanh) {
		this.heDieuHanh = heDieuHanh;
	}

	public String getCameraTruoc() {
		return cameraTruoc;
	}

	public void setCameraTruoc(String cameraTruoc) {
		this.cameraTruoc = cameraTruoc;
	}

	public String getCameraSau() {
		return cameraSau;
	}

	public void setCameraSau(String cameraSau) {
		this.cameraSau = cameraSau;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getGpu() {
		return gpu;
	}

	public void setGpu(String gpu) {
		this.gpu = gpu;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getRom() {
		return rom;
	}

	public void setRom(String rom) {
		this.rom = rom;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

   
}
