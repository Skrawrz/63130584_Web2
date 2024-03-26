package thiGK.ntu63130584.model;
import thiGK.ntu63130584.model.SinhVien;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
public class SinhVien {
    private String MSSV;
    private String Ten;
    private double Diem;


    public String getMSSV() {
		return MSSV;
	}
	public void setMSSV(String MSSV) {
		this.MSSV = MSSV;
	}

	public String getTen() {
		return Ten;
	}
	public void setTen(String Ten) {
		this.Ten = Ten;
	}
    
	public double getDiem() {
		return Diem;
	}
	public void setDiem(double Diem) {
		this.Diem = Diem;
	}

	public SinhVien(String MSSV, String Ten, double Diem) {
		this.MSSV = MSSV;
		this.Ten = Ten;
		this.Diem = Diem;
	}
}
