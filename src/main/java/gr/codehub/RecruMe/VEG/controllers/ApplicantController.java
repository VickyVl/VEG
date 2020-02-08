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

    @GetMapping("applicants")
    public List<Applicant> readAll( ) {
        return applicantService.getAll();
    }

    @PostMapping("applicant")
    public Applicant newApplicant(@RequestBody ApplicantDto applicantDto) {
        return applicantService.save(applicantDto);
    }

    @GetMapping("applicant/{id}")
    public Applicant getApplicant(@PathVariable int id)
            throws ApplicantNotFoundException {

        return applicantService.getApplicant(id);
    }

    //applicant/{name}
    @GetMapping("applicants/name/{firstName}")
    public List<Applicant> getApplicantsByName( @PathVariable String firstName)
            throws ApplicantNotFoundException {
        return applicantService.readByName(firstName);
    }

    @PutMapping("applicant/{id}")
    public Applicant updateOne(@PathVariable int id,
                              @RequestBody ApplicantDto applicantDto)
            throws ApplicantNotFoundException {
        return applicantService.updateOne(id, applicantDto);
    }

}
