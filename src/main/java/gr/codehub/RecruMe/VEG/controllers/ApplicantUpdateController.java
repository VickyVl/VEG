package gr.codehub.RecruMe.VEG.controllers;

import gr.codehub.RecruMe.VEG.dtos.ApplicantDto;
import gr.codehub.RecruMe.VEG.exceptions.ApplicantNotFoundException;
import gr.codehub.RecruMe.VEG.exceptions.ApplicantUpdateSkillException;
import gr.codehub.RecruMe.VEG.models.Applicant;
import gr.codehub.RecruMe.VEG.services.ApplicantUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicantUpdateController {

    @Autowired
    private ApplicantUpdateService applicantUpdateService;

    /**
     * updates applicant's firstname
     * @param id
     * @param applicantDto
     * @return updated applicant
     * @throws ApplicantNotFoundException
     */
    @PutMapping("applicant/{id}/firstname")
    public Applicant updateFirstName(@PathVariable int id,
                                     @RequestBody ApplicantDto applicantDto)
            throws ApplicantNotFoundException {
        return applicantUpdateService.updateFirstName(id, applicantDto);
    }

    @PutMapping("applicant/{id}/lastname")
    public Applicant updateLastName(@PathVariable int id,
                                    @RequestBody ApplicantDto applicantDto)
            throws ApplicantNotFoundException {
        return applicantUpdateService.updateLastName(id, applicantDto);
    }

    @PutMapping("applicant/{id}/address")
    public Applicant updateAddress(@PathVariable int id,
                                   @RequestBody ApplicantDto applicantDto)
            throws ApplicantNotFoundException {
        return applicantUpdateService.updateAddress(id, applicantDto);
    }

    @PutMapping("applicant/{id}/region")
    public Applicant updateRegion(@PathVariable int id,
                                  @RequestBody ApplicantDto applicantDto)
            throws ApplicantNotFoundException {
        return applicantUpdateService.updateRegion(id, applicantDto);
    }

    @PutMapping("applicant/{id}/educationlevel")
    public Applicant updateEducationLevel(@PathVariable int id,
                                          @RequestBody ApplicantDto applicantDto)
            throws ApplicantNotFoundException {
        return applicantUpdateService.updateEducationLevel(id, applicantDto);
    }

    @PutMapping("applicant/{id}/status")
    public Applicant updateStatus(@PathVariable int id,
                                  @RequestBody ApplicantDto applicantDto)
            throws ApplicantNotFoundException {
        return applicantUpdateService.updateStatus(id, applicantDto);
    }
    @PutMapping("applicant/{id}/skill")
    public Applicant updateApplicantSkill(@PathVariable int id,
                                  @RequestBody ApplicantDto applicantDto)
            throws ApplicantNotFoundException , ApplicantUpdateSkillException {
        return applicantUpdateService.updateApplicantSkill(id, applicantDto);
    }
}
