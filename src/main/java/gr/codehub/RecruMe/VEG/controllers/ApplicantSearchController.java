package gr.codehub.RecruMe.VEG.controllers;

import gr.codehub.RecruMe.VEG.exceptions.ApplicantNotFoundException;
import gr.codehub.RecruMe.VEG.models.Applicant;
import gr.codehub.RecruMe.VEG.services.ApplicantSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ApplicantSearchController used here to provide the data of all applicant search services
 * (by id, first name, region) displaying them as json files on the web via HTTP responses.
 */

@RestController
public class ApplicantSearchController {
    @Autowired
    private ApplicantSearchService applicantSearchService;

    /**
     * endpoint http://localhost:8080/applicant/{id}
     * @param id
     * @return applicant by id
     * @throws ApplicantNotFoundException
     */

    @GetMapping("applicant/{id}")
    public Applicant getApplicant(@PathVariable int id)
            throws ApplicantNotFoundException {

        return applicantSearchService.getApplicant(id);
    }

    /**
     * endpoint http://localhost:8080/applicants/name/{firstName}
     * @param firstName
     * @return list of applicants by first name
     * @throws ApplicantNotFoundException
     */

    @GetMapping("applicants/name/{firstName}")
    public List<Applicant> getApplicantsByName(@PathVariable String firstName)
            throws ApplicantNotFoundException {
        return applicantSearchService.searchByName(firstName);
    }

    /**
     * endpoint http://localhost:8080/applicants/region/{region}
     * @param region
     * @return list of applicants by region
     * @throws ApplicantNotFoundException
     */

    @GetMapping("applicants/region/{region}")
    public List<Applicant> searchApplicantsByRegion(@PathVariable String region)
            throws ApplicantNotFoundException {
        return applicantSearchService.searchByRegion(region);
    }

    /**
     * endpoint http://localhost:8080/applicants/skill/{description}
     * @param description of the skill
     * @return all applicants that has the skill by description skill
     * @throws ApplicantNotFoundException
     */
    @GetMapping("applicants/skill/{description}")
    public List<Applicant> searchApplicantsBySkill(@PathVariable String description)
            throws ApplicantNotFoundException {
        return applicantSearchService.searchBySkill(description);
    }
}
