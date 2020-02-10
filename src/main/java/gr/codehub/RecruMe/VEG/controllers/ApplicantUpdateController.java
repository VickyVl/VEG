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

/**
 * ApplicantUpdateController used here to provide the data of all applicant update services
 * (of first name, last name, address, region, education level, activate/inactivate status, skill)
 * displaying them as json files on the web via HTTP responses.
*/

@RestController
public class ApplicantUpdateController {

    @Autowired
    private ApplicantUpdateService applicantUpdateService;

    /**
     * endpoint http://localhost:8080/applicant/{id}/firstname
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

    /**
     * endpoint http://localhost:8080/applicant/{id}/lastname
     * updates applicant's lastname
     * @param id
     * @param applicantDto
     * @return updated applicant
     * @throws ApplicantNotFoundException
    */

    @PutMapping("applicant/{id}/lastname")
    public Applicant updateLastName(@PathVariable int id,
                                    @RequestBody ApplicantDto applicantDto)
            throws ApplicantNotFoundException {
        return applicantUpdateService.updateLastName(id, applicantDto);
    }

    /**
     * endpoint http://localhost:8080/applicant/{id}/address
     * updates applicant's address
     * @param id
     * @param applicantDto
     * @return updated applicant
     * @throws ApplicantNotFoundException
     */

    @PutMapping("applicant/{id}/address")
    public Applicant updateAddress(@PathVariable int id,
                                   @RequestBody ApplicantDto applicantDto)
            throws ApplicantNotFoundException {
        return applicantUpdateService.updateAddress(id, applicantDto);
    }

    /**
     * endpoint http://localhost:8080/applicant/{id}/region
     * updates applicant's region
     * @param id
     * @param applicantDto
     * @return updated applicant
     * @throws ApplicantNotFoundException
     */

    @PutMapping("applicant/{id}/region")
    public Applicant updateRegion(@PathVariable int id,
                                  @RequestBody ApplicantDto applicantDto)
            throws ApplicantNotFoundException {
        return applicantUpdateService.updateRegion(id, applicantDto);
    }

    /**
     * endpoint http://localhost:8080/applicant/{id}/educationlevel
     * updates applicant's educationlevel
     * @param id
     * @param applicantDto
     * @return updated applicant
     * @throws ApplicantNotFoundException
     */

    @PutMapping("applicant/{id}/educationlevel")
    public Applicant updateEducationLevel(@PathVariable int id,
                                          @RequestBody ApplicantDto applicantDto)
            throws ApplicantNotFoundException {
        return applicantUpdateService.updateEducationLevel(id, applicantDto);
    }

    /**
     * endpoint http://localhost:8080/applicant/{id}/activateStatus
     * updates applicant's activateStatus
     * @param id
     * @param applicantDto
     * @return updated applicant
     * @throws ApplicantNotFoundException
    */

    @PutMapping("applicant/{id}/activateStatus")
    public Applicant activateStatus(@PathVariable int id,
                                  @RequestBody ApplicantDto applicantDto)
            throws ApplicantNotFoundException {
        return applicantUpdateService.activateStatus(id, applicantDto);
    }

    /**
     * endpoint http://localhost:8080/applicant/{id}/inactivateStatus
     * updates applicant's inactivateStatus
     * @param id
     * @param applicantDto
     * @return updated applicant
     * @throws ApplicantNotFoundException
     */

    @PutMapping("applicant/{id}/inactivateStatus")
    public Applicant inactivateStatus(@PathVariable int id,
                                  @RequestBody ApplicantDto applicantDto)
            throws ApplicantNotFoundException {
        return applicantUpdateService.inactivateStatus(id, applicantDto);
    }

    /**
     * endpoint http://localhost:8080/applicant/{id}/skill
     * updates applicant's skill
     * @param id
     * @param applicantDto
     * @return updated applicant
     * @throws ApplicantNotFoundException
     */

    @PutMapping("applicant/{id}/skill")
    public Applicant updateApplicantSkill(@PathVariable int id,
                                          @RequestBody ApplicantDto applicantDto)
            throws ApplicantNotFoundException , ApplicantUpdateSkillException {
        return applicantUpdateService.updateApplicantSkill(id, applicantDto);
    }
}
