package gr.codehub.RecruMe.VEG.services;

import gr.codehub.RecruMe.VEG.dtos.ApplicantDto;
import gr.codehub.RecruMe.VEG.exceptions.ApplicantNotFoundException;
import gr.codehub.RecruMe.VEG.models.Applicant;
import gr.codehub.RecruMe.VEG.repositories.Applicants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

        return applicantRepo.save(applicant);
    }

    public List<Applicant> getAll() {
        return
                StreamSupport
                        .stream(applicantRepo.findAll().spliterator(), false)
                        .collect(Collectors.toList());

    }

    public Applicant getApplicant(int id) throws ApplicantNotFoundException {

        try {
            Applicant customer = applicantRepo.findById(id).get();
            return customer;
        } catch (Exception e) {
            throw new ApplicantNotFoundException("Applicant id = " + id + "not found");
        }

    }

    public List<Applicant> readByName(String firstName) throws ApplicantNotFoundException {
        try {
            return
                    StreamSupport
                            .stream(applicantRepo.findAll().spliterator(), false)
                            .filter(applicant -> applicant.getFirstName().equals(firstName))
                            .collect(Collectors.toList());
        } catch (Exception e) {
            throw new ApplicantNotFoundException("First Name = " + firstName);
        }
    }

    public Applicant updateOne(int id, ApplicantDto applicantDto) throws ApplicantNotFoundException {
        Applicant applicant = applicantRepo.findById(id).get();
        if (applicant == null) {
            throw new ApplicantNotFoundException("Customer id = " + id);
        }
        applicant.setAddress(applicantDto.getAddress());
//        if (applicantDto.getFirstName() != null)
//            applicant.setFirstName(applicantDto.getFirstName());

        return applicantRepo.save(applicant);
    }
}
