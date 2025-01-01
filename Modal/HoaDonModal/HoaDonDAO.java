package HoaDonModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import ketnoimodal.KetNoi;

public class HoaDonDAO {
	public int Them(int id, Date NgayMua) throws Exception{
		KetNoi kn=new KetNoi();
		kn.ketNoi();
		String sql="INSERT INTO HoaDon (id,NgayMua , trangthai) VALUES (?, ?, 0)";
		
		PreparedStatement cmd =kn.cn.prepareStatement(sql);
		cmd.setInt(1,id);
		cmd.setDate(2, new java.sql.Date(NgayMua.getTime()));
		int kq=cmd.executeUpdate();
		cmd.close();kn.cn.close();
		return kq;
	}
	public int mahd() throws Exception{
		KetNoi kn=new KetNoi();
		kn.ketNoi();
		String sql="select TOP(1) mahd from Hoadon ORDER BY mahd DESC";
		
		PreparedStatement cmd =kn.cn.prepareStatement(sql);
		ResultSet rs=cmd.executeQuery();
		
		int kq=0;
		if(rs.next()) 
			kq=rs.getInt(1);
		cmd.close();kn.cn.close();
		return kq;
	}
	public int countHoaDon() throws Exception {
        int count = 0;
        KetNoi kn = new KetNoi();
        kn.ketNoi();

        String sql = "SELECT COUNT(*) AS total FROM Hoadon where trangthai = 0";
        PreparedStatement stmt = kn.cn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            count = rs.getInt("total");
        }

        rs.close();
        stmt.close();
        kn.cn.close();

        return count;
    }
}
