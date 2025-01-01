package LichsukhModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ketnoimodal.KetNoi;

public class LichsukhDAO {
    public List<Lichsukh> getlsid(int userId) throws Exception {
        KetNoi kn = new KetNoi();
        kn.ketNoi();

        String sql = "SELECT * FROM LichSuMuaHangKH WHERE id = ?";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        cmd.setInt(1, userId);

        ResultSet rs = cmd.executeQuery();
        List<Lichsukh> lichsukhList = new ArrayList<>();

        while (rs.next()) {
            Lichsukh lichsukh = new Lichsukh(
                rs.getInt("id"),
                rs.getInt("mahd"),
                rs.getString("ngaymua"),
                rs.getInt("madt"),
                rs.getString("tendt"),
                rs.getDouble("gia"),
                rs.getInt("soluong"),
                rs.getDouble("tong"),
                rs.getBoolean("trangthai")
            );
            lichsukhList.add(lichsukh);
        }

        rs.close();
        cmd.close();
        kn.cn.close();

        return lichsukhList;
    }
    public List<Lichsukh> getls() throws Exception {
        KetNoi kn = new KetNoi();
        kn.ketNoi();

        String sql = "SELECT * FROM LichSuMuaHangKH where trangthai =0 ";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        

        ResultSet rs = cmd.executeQuery();
        List<Lichsukh> lichsukhList = new ArrayList<>();

        while (rs.next()) {
            Lichsukh lichsukh = new Lichsukh(
                rs.getInt("id"),
                rs.getInt("mahd"),
                rs.getString("ngaymua"),
                rs.getInt("madt"),
                rs.getString("tendt"),
                rs.getDouble("gia"),
                rs.getInt("soluong"),
                rs.getDouble("tong"),
                rs.getBoolean("trangthai")
            );
            lichsukhList.add(lichsukh);
        }

        rs.close();
        cmd.close();
        kn.cn.close();

        return lichsukhList;
    }
    
    public boolean xacNhanDonHang(int mahd) throws Exception {
        KetNoi kn = new KetNoi();
        kn.ketNoi();

        String sql = "UPDATE Hoadon " +
                     "SET trangthai = 1 " +
                     "WHERE mahd = ?";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        cmd.setInt(1, mahd);

        int n = cmd.executeUpdate();
        cmd.close();
        kn.cn.close();

        return n > 0;
    }
}