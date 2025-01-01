package HoaDonModal;

import java.util.Date;

public class HoaDonBO {
	HoaDonDAO hddao= new HoaDonDAO();
	public int Them(int id, Date NgayMua) throws Exception{
		return hddao.Them(id,NgayMua);
	}
	public int mahd() throws Exception{
		return hddao.mahd();
	}
	public int countHoaDon() {
        try {
            return hddao.countHoaDon();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
	