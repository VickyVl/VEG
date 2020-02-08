package gr.codehub.RecruMe.VEG.services;

import gr.codehub.RecruMe.VEG.repositories.ApplicantSkills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicantSkillService {
    @Autowired
    private ApplicantSkills applicantSkillsRepo;

}
