package thiGK.ntu63130584.service;
import org.springframework.stereotype.Service;
import thiGK.ntu63130584.model.SinhVien;
import java.util.ArrayList;
import java.util.List;

@Service
public class SinhVienService {
    private List<SinhVien> danhSach = new ArrayList<>();

    public SinhVienService() {
        danhSach.add(new SinhVien("1", "Nguyễn Văn B", 10));
        danhSach.add(new SinhVien("2", "Nguyễn Văn A", 8));
    }

    public SinhVien timKiem(String ma) {
        return danhSach.stream()
                .filter(sv -> sv.getMSSV().equals(ma))
                .findFirst()
                .orElse(null);
    }

    public List<SinhVien> layDanhSach() {
        return new ArrayList<>(danhSach);
    }

    public void themSinhVien(SinhVien sinhVien) {
        danhSach.add(sinhVien);
    }
}
