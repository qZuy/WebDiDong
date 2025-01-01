package LichsukhModal;

import java.util.List;

public class LichsukhBO {
	private LichsukhDAO lichsukhDAO = new LichsukhDAO();

    
    public List<Lichsukh> getlsid(int userId) throws Exception {
        return lichsukhDAO.getlsid(userId);
    }
    public List<Lichsukh> getls() throws Exception {
        return lichsukhDAO.getls();
    }
    public boolean xacNhanDonHang(int mahd) throws Exception {
        return lichsukhDAO.xacNhanDonHang(mahd);
    }
}
