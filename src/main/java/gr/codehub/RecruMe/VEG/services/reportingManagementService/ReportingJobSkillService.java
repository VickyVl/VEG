package gr.codehub.RecruMe.VEG.services.reportingManagementService;

import gr.codehub.RecruMe.VEG.repositories.JobSkills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ReportingJobSkillService implements methods for Reporting Services regarding job offer requested skills.
 */

@Service
public class ReportingJobSkillService {
    private JobSkills jobSkillsRepo;

    @Autowired
    public ReportingJobSkillService(JobSkills jobSkillsRepo) {
        this.jobSkillsRepo = jobSkillsRepo;
    }

    /**
     * Display top 5 most requested skills by job offers
     * @return a list of top 5 most requested skills.
     */

    public List<String> getTop5MostRequestedSkills(){
        List<Object[]> top5MostRequestedSkills = jobSkillsRepo.getTop5MostRequestedSkills();
        List<String> returnList = new ArrayList<>();
        for (Object[] o: top5MostRequestedSkills) {
            returnList.add((String) o[0]);
        }
        return returnList;
    }
}
