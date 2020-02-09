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
//        applicant.setSkills(applicantDto.getSkills());
        // TO DO SET UP SKILLS
        applicant.setActive(true);
        return applicantRepo.save(applicant);
    }

    public List<Applicant> getAll() {
        Applicant applicant = new Applicant();
        List<ApplicantSkill> applicantSkills = applicant.getApplicantSkills();

        applicant.getApplicantSkills();
        for (int i=0; i<applicantSkills.size(); i++){
            applicantSkills.get(i).getApplicant();
        }
        return
                StreamSupport
                        .stream(applicantRepo.findAll().spliterator(), false)
                        .collect(Collectors.toList());

    }

//    public Applicant getApplicant(int id) throws ApplicantNotFoundException {
//
//        try {
//            Applicant applicant = applicantRepo.findById(id).get();
//            return applicant;
//        } catch (Exception e) {
//            throw new ApplicantNotFoundException("Applicant id = " + id + " NOT FOUND");
//        }
//
//    }

//    public List<Applicant> readByName(String firstName) throws ApplicantNotFoundException {
//        try {
//            return
//                    StreamSupport
//                            .stream(applicantRepo.findAll().spliterator(), false)
//                            .filter(applicant -> applicant.getFirstName().equalsIgnoreCase(firstName))
//                            .collect(Collectors.toList());
//        } catch (Exception e) {
//            throw new ApplicantNotFoundException("First Name = " + firstName);
//        }
//    }

}
