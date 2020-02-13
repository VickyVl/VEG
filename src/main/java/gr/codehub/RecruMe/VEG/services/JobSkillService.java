package gr.codehub.RecruMe.VEG.services;

import gr.codehub.RecruMe.VEG.repositories.JobSkills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class JobSkillService {
    private JobSkills jobSkillsRepo;

    @Autowired
    public JobSkillService(JobSkills jobSkillsRepo) {
        this.jobSkillsRepo = jobSkillsRepo;
    }

    public List<String> getTop5MostRequestedSkills(){
        List<Object[]> top5MostRequestedSkills = jobSkillsRepo.getTop5MostRequestedSkills();
        List<String> returnList = new ArrayList<>();
        for (Object[] o: top5MostRequestedSkills) {
            returnList.add((String) o[0]);
        }
        return returnList;
    }
}
