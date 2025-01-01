package AssessModal;

public class Assess {
    private int id;
    private int userId;
    private int maDT;
    private byte rating;
    private String comment;
    private String createdAt;

    // Constructor
    public Assess(int userId, int maDT, byte rating, String comment) {
        this.userId = userId;
        this.maDT = maDT;
        this.rating = rating;
        this.comment = comment;
    }

    public Assess(int id, int userId, int maDT, byte rating, String comment, String createdAt) {
        this.id = id;
        this.userId = userId;
        this.maDT = maDT;
        this.rating = rating;
        this.comment = comment;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMaDT() {
        return maDT;
    }

    public void setMaDT(int maDT) {
        this.maDT = maDT;
    }

    public byte getRating() {
        return rating;
    }

    public void setRating(byte rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
