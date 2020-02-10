package gr.codehub.RecruMe.VEG.services;

import gr.codehub.RecruMe.VEG.dtos.ApplicantDto;
import gr.codehub.RecruMe.VEG.exceptions.ApplicantNotFoundException;
import gr.codehub.RecruMe.VEG.models.Applicant;
import gr.codehub.RecruMe.VEG.models.ApplicantSkill;
import gr.codehub.RecruMe.VEG.repositories.ApplicantSkills;
import gr.codehub.RecruMe.VEG.repositories.Applicants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ApplicantService {

    @Autowired
    private Applicants applicantRepo;

    public Applicant save(ApplicantDto applicantDto) {
        Applicant applicant = new Applicant();
        applicant.setFirstName(applicantDto.getFirstName());
        applicant.setLastName(applicantDto.getLastName());
        applicant.setAddress(applicantDto.getAddress());
        applicant.setRegion(applicantDto.getRegion());
        applicant.setEducationLevel(applicantDto.getEducationLevel());
        applicant.setActive(true);

        List<ApplicantSkill> applicantSkills = applicantDto.getApplicantSkills();

        applicant.setApplicantSkills(applicantSkills);
        applicant.setActive(true);
        applicant = applicantRepo.save(applicant);

        for (int i=0; i<applicantSkills.size(); i++){
            applicantSkills.get(i).setApplicant(applicant);
        }
        return  applicantRepo.save(applicant);
    }

    public List<Applicant> getAll() {
        Applicant applicant = new Applicant();
//        List<ApplicantSkill> applicantSkills = applicant.getApplicantSkills();
//
//        applicant.getApplicantSkills();
//        for (int i=0; i<applicantSkills.size(); i++){
//            applicantSkills.get(i).setApplicant(applicant);
//        }
        return
                StreamSupport
                        .stream(applicantRepo.findAll().spliterator(), false)
                        .collect(Collectors.toList());
    }


}
