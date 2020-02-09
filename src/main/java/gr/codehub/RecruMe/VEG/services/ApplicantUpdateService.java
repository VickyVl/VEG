package gr.codehub.RecruMe.VEG.services;

import gr.codehub.RecruMe.VEG.dtos.ApplicantDto;
import gr.codehub.RecruMe.VEG.exceptions.ApplicantNotFoundException;
import gr.codehub.RecruMe.VEG.models.Applicant;
import gr.codehub.RecruMe.VEG.models.ApplicantSkill;
import gr.codehub.RecruMe.VEG.repositories.Applicants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantUpdateService {

    @Autowired
    private Applicants applicantRepo;

    public Applicant updateFirstName(int id, ApplicantDto applicantDto) throws ApplicantNotFoundException {
        Applicant applicant = applicantRepo.findById(id).get();
        if (applicant == null) {
            throw new ApplicantNotFoundException("Applicant id = " + id + " NOT FOUND");
        }
        applicant.setFirstName(applicantDto.getFirstName());

        return applicantRepo.save(applicant);
    }

    public Applicant updateLastName(int id, ApplicantDto applicantDto) throws ApplicantNotFoundException {
        Applicant applicant = applicantRepo.findById(id).get();
        if (applicant == null) {
            throw new ApplicantNotFoundException("Applicant id = " + id + " NOT FOUND");
        }
        applicant.setLastName(applicantDto.getLastName());

        return applicantRepo.save(applicant);
    }

    public Applicant updateAddress(int id, ApplicantDto applicantDto) throws ApplicantNotFoundException {
        Applicant applicant = applicantUpdateRepo.findById(id).get();
        if (applicant == null) {
            throw new ApplicantNotFoundException("Applicant id = " + id + " NOT FOUND");
        }
        applicant.setAddress(applicantDto.getAddress());

        return applicantUpdateRepo.save(applicant);
    }

    public Applicant updateRegion(int id, ApplicantDto applicantDto) throws ApplicantNotFoundException {
        Applicant applicant = applicantUpdateRepo.findById(id).get();
        if (applicant == null) {
            throw new ApplicantNotFoundException("Applicant id = " + id + " NOT FOUND");
        }
        applicant.setRegion(applicantDto.getRegion());

        return applicantUpdateRepo.save(applicant);
    }

    public Applicant updateEducationLevel(int id, ApplicantDto applicantDto) throws ApplicantNotFoundException {
        Applicant applicant = applicantUpdateRepo.findById(id).get();
        if (applicant == null) {
            throw new ApplicantNotFoundException("Applicant id = " + id + " NOT FOUND");
        }
        applicant.setEducationLevel(applicantDto.getEducationLevel());

        return applicantUpdateRepo.save(applicant);
    }

    public Applicant updateStatus(int id, ApplicantDto applicantDto) throws ApplicantNotFoundException {
        Applicant applicant = applicantUpdateRepo.findById(id).get();
        if (applicant == null) {
            throw new ApplicantNotFoundException("Applicant id = " + id + " NOT FOUND");
        }
        applicant.setActive(false);

        return applicantUpdateRepo.save(applicant);
    }

    public Applicant updateApplicantSkill(int id, ApplicantDto applicantDto) throws ApplicantNotFoundException {
            Applicant applicant = applicantUpdateRepo.findById(id).get();
        if (applicant == null) {
            throw new ApplicantNotFoundException("Applicant id = " + id + " NOT FOUND");
        }
        List<ApplicantSkill> applicantSkills = applicantDto.getApplicantSkills();
        applicant.setApplicantSkills(applicantSkills);

        return applicantUpdateRepo.save(applicant);
    }
}
