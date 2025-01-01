package ChiTietHoaDonModal;

public class CthdBO {
	CthdDAO ctdao = new CthdDAO();
	public int Them(int mahd, int MaDT, int SoLuongMua) throws Exception{
		return ctdao.Them(mahd,MaDT,SoLuongMua);
	}
}
