package gr.codehub.RecruMe.VEG.services;

import gr.codehub.RecruMe.VEG.repositories.JobSkills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class JobSkillService {
    private JobSkills jobSkillsRepo;

    @Autowired
    public JobSkillService(JobSkills jobSkillsRepo) {
        this.jobSkillsRepo = jobSkillsRepo;
    }
}
