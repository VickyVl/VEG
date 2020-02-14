package gr.codehub.RecruMe.VEG.services.reportingManagementService;

import gr.codehub.RecruMe.VEG.repositories.ApplicantSkills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * ReportingApplicantSkillService implements methods for Reporting Services regarding applicants' skills.
 */

@Service
public class ReportingApplicantSkillService {
    private ApplicantSkills applicantSkillRepo;

    @Autowired
    public ReportingApplicantSkillService(ApplicantSkills applicantSkillRepo) {
        this.applicantSkillRepo = applicantSkillRepo;
    }

    /**
     * Display top 5 most offered skills by applicants
     * @return a list of top 5 most offered skills.
     */

    public List<String> getTop5MostOfferedSkills(){
        List<Object[]> top5MostOfferedSkills = applicantSkillRepo.getTop5MostOfferedSkills();
        List<String> returnList = new ArrayList<>();
        for (Object[] o: top5MostOfferedSkills) {
            returnList.add((String) o[0]);
        }
        return returnList;
    }
}
