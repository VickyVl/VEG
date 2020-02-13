package gr.codehub.RecruMe.VEG.services;

import gr.codehub.RecruMe.VEG.repositories.ApplicantSkills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicantSkillService {
    private ApplicantSkills applicantSkillRepo;

    @Autowired
    public ApplicantSkillService(ApplicantSkills applicantSkillRepo) {
        this.applicantSkillRepo = applicantSkillRepo;
    }

    public List<String> getTop5MostOfferedSkills(){
        List<Object[]> top5MostOfferedSkills = applicantSkillRepo.getTop5MostOfferedSkills();
        List<String> returnList = new ArrayList<>();
        for (Object[] o: top5MostOfferedSkills) {
            returnList.add((String) o[0]);
        }
        return returnList;
    }
}
