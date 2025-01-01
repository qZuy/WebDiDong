package AssessModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ketnoimodal.KetNoi;

public class AssessDAO {
    
	public ArrayList<Assess> getAllAssess(int maDT) throws Exception {
	    ArrayList<Assess> assess = new ArrayList<>();
	    KetNoi kn = new KetNoi();
	    kn.ketNoi();
	    String sql = "SELECT * FROM DanhGia WHERE maDT = ?";
	    PreparedStatement cmd = kn.cn.prepareStatement(sql);
	    cmd.setInt(1, maDT);  

	    ResultSet rs = cmd.executeQuery();

	    while (rs.next()) {
	        assess.add(new Assess(rs.getInt("id"), rs.getInt("user_id"),rs.getInt("maDT"), rs.getByte("rating"), rs.getString("comment"), rs.getString("created_at")));
	    }

	    rs.close();
	    kn.cn.close();
	    return assess;
	}

    
    public void addAssess(int userId,int maDT, byte rating, String comment, String createAt) throws Exception {
        KetNoi kn = new KetNoi();
        kn.ketNoi();

        String sql = "INSERT INTO DanhGia (user_id, MaDT, rating, comment, created_at) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);

        cmd.setInt(1, userId);
        cmd.setInt(2, maDT);
        cmd.setByte(3, rating);
        cmd.setString(4, comment);
        cmd.setString(5, createAt);

        cmd.executeUpdate();
        kn.cn.close();
        
    }
}
