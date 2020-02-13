package gr.codehub.RecruMe.VEG.controllers.api;

import gr.codehub.RecruMe.VEG.exceptions.ApplicantNotFoundException;
import gr.codehub.RecruMe.VEG.models.Applicant;
import gr.codehub.RecruMe.VEG.services.ApplicantSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ApplicantSearchController used here to provide the data of all applicant search services
 * (by id, first name, region, skill description, level) by
 * displaying the above as json files on the web via HTTP responses.
 */

@RestController
@RequestMapping("/recrumeVEG/")
public class ApplicantSearchController {
    @Autowired
    private ApplicantSearchService applicantSearchService;

    /**
     * Display an applicant by id
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
     * Display applicants with a particular first name
     * @param firstName
     * @return a list of applicants by first name
     * @throws ApplicantNotFoundException
     */

    @GetMapping("applicants/name/{firstName}")
    public List<Applicant> getApplicantsByName(@PathVariable String firstName)
            throws ApplicantNotFoundException {
        return applicantSearchService.searchByName(firstName);
    }

    /**
     * Display applicants in a particular region
     * @param region
     * @return a list of applicants by region
     * @throws ApplicantNotFoundException
     */

    @GetMapping("applicants/region/{region}")
    public List<Applicant> searchApplicantsByRegion(@PathVariable String region)
            throws ApplicantNotFoundException {
        return applicantSearchService.searchByRegion(region);
    }

    /**
     * Display applicants with a particular skill description
     * @param description
     * @return a list of applicants searched by skill
     * @throws ApplicantNotFoundException
     */

    @GetMapping("applicants/skill/{description}")
    public List<Applicant> searchApplicantsBySkill(@PathVariable String description)
            throws ApplicantNotFoundException {
        return applicantSearchService.searchBySkill(description);
    }
    /**
     * Display applicants with a particular level
     * @param level
     * @return a list of applicants with this level
     * @throws ApplicantNotFoundException
     */
    @GetMapping("applicants/level/{level}")
    public List<Applicant> searchApplicantsByLevel(@PathVariable String level)
            throws ApplicantNotFoundException {
        return applicantSearchService.searchByLevel(level);
    }
}
