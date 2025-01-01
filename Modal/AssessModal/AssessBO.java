package AssessModal;

import java.util.ArrayList;

public class AssessBO {
	AssessDAO adao = new AssessDAO();
	public ArrayList<Assess> getAllAssess(int maDT) throws Exception {
        return adao.getAllAssess(maDT);
    }
	public void addAssess(int userId, int maDT, byte rating, String comment, String createdAt) throws Exception {    
	    adao.addAssess(userId, maDT, rating, comment, createdAt);
	}
}
