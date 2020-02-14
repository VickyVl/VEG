package gr.codehub.RecruMe.VEG.controllers.api;

import gr.codehub.RecruMe.VEG.dtos.ApplicantDto;
import gr.codehub.RecruMe.VEG.exceptions.ApplicantNotFoundException;
import gr.codehub.RecruMe.VEG.exceptions.ApplicantUpdateSkillException;
import gr.codehub.RecruMe.VEG.models.Applicant;
import gr.codehub.RecruMe.VEG.services.applicantManagementService.ApplicantUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ApplicantUpdateController used here to provide the data of all applicant update services
 * (of first name, last name, address, region, education level, activate/inactivate status, skill, level)
 * by displaying the above as json files on the web via HTTP responses.
*/

@RestController
@RequestMapping("/recrumeVEG/")
public class ApplicantUpdateController {

    @Autowired
    private ApplicantUpdateService applicantUpdateService;

    /**
     * Update applicant's first name
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
     * Update applicant's last name
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
     * Update applicant's address
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
     * Update applicant's region
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
     * Updates applicant's education level
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
     * Update applicant's activate status
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
     * Updates applicant's inactivate status
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
     * Update applicant's skill
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
    /**
     * Update applicant's level
     * @param id
     * @param applicantDto
     * @return updated applicant
     * @throws ApplicantNotFoundException
     * @throws ApplicantUpdateSkillException
     */
    @PutMapping("applicant/{id}/level")
    public Applicant updateLevel(@PathVariable int id,
                                 @RequestBody ApplicantDto applicantDto)
            throws ApplicantNotFoundException , ApplicantUpdateSkillException {
        return applicantUpdateService.updateLevel(id, applicantDto);
    }
}
