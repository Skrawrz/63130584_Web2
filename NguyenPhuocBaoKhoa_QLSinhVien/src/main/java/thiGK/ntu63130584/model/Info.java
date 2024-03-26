package thiGK.ntu63130584.model;
public class Info {
    private int MSSV;
    private String ten;
    private String lop;
    private String truong;

    public Info() {

    }

    public Info(int MSSV, String ten, String lop, String truong) {
        this.MSSV = MSSV;
        this.ten = ten;
        this.lop = lop;
        this.truong = truong;
    }

    public int getMSSV() {
        return MSSV;
    }

    public void setMSSV(int MSSV) {
        this.MSSV = MSSV;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }


    public String getTruong() {
        return truong;
    }

    public void setTruong(String truong) {
        this.truong = truong;
    }
}
