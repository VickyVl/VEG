package gr.codehub.RecruMe.VEG.controllers;

import gr.codehub.RecruMe.VEG.dtos.ApplicantDto;
import gr.codehub.RecruMe.VEG.exceptions.ApplicantNotFoundException;
import gr.codehub.RecruMe.VEG.models.Applicant;
import gr.codehub.RecruMe.VEG.services.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    /**
     * endpoint http://localhost:8080/applicants
     * @return gets all applicants
     */
    @GetMapping("applicants")
    public List<Applicant> readAll() {
        return applicantService.getAll();
    }

    /**
     * create a new applicant
     * @param applicantDto
     * @return new applicant
     */
    @PostMapping("applicant")
    public Applicant newApplicant(@RequestBody ApplicantDto applicantDto) {
        return applicantService.save(applicantDto);
    }

}
