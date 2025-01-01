package ChiTietHoaDonModal;

import java.sql.PreparedStatement;

import ketnoimodal.KetNoi;

public class CthdDAO {
	public int Them(int mahd,int MaDT, int SoLuongMua) throws Exception{
		KetNoi kn=new KetNoi();
		kn.ketNoi();
		String sql="INSERT INTO Chitiethoadon(mahd,MaDT , SoLuongMua) VALUES (?, ?, ?)";
		
		PreparedStatement cmd =kn.cn.prepareStatement(sql);
		cmd.setInt(1, mahd);
		cmd.setInt(2,MaDT);
		cmd.setInt(3, SoLuongMua);

		int kq=cmd.executeUpdate();
		cmd.close();kn.cn.close();
		return kq;
	}
}
