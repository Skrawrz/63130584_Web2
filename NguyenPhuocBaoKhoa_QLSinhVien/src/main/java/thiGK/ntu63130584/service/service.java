package thiGK.ntu63130584.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import thiGK.ntu63130584.model.Info;

@Service
public class service {

    
    private final List<Info> info = new ArrayList<>();

   
    public service() {
        info.add(new Info(1, "Nguyen Van A", "K63", "NTU"));
        info.add(new Info(2, "Tran Thi B", "K63", "NTU"));
        info.add(new Info(3, "Le Van C", "K63", "NTU"));
    }

    public List<Info> getAllStudents() {
        return info;
    }

    public Info findByCode(int MSSV) {
        for (Info info : info) {
            if (info.getMSSV() == MSSV) {
                return info;
            }
        }
        return null;
    }

    public void addInfo(Info infos) {
        info.add(infos);
    }
}
