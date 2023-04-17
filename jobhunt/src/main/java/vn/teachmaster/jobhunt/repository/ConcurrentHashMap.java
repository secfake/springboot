package vn.teachmaster.jobhunt.repository;

import org.springframework.stereotype.Repository;
import vn.teachmaster.jobhunt.model.Employer;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ConcurrentHashMap {
    private List<Employer> employers;

    public ConcurrentHashMap() {
        employers = new ArrayList<>(List.of(
                new Employer("FPT","fpt@ftp.com.vn","088888888"),
                new Employer("CMC","cmc@cmc.com.vn","099999999")
        ));
    }

    public List<Employer> getEmployers() {
        return employers;
    }

    public void addEmployers(Employer employer) {
        this.employers.add(employer);
    }
}

