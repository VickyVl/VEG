package gr.codehub.RecruMe.VEG.controllers.api;

import gr.codehub.RecruMe.VEG.exceptions.JobOfferNotFoundException;
import gr.codehub.RecruMe.VEG.models.JobOffer;
import gr.codehub.RecruMe.VEG.services.jobOfferManagementService.JobOfferSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * JobOfferSearchController used here to provide the data of all job offer search services
 * (by id, title of position, region, company, skill) by
 * displaying the above as json files on the web via HTTP responses.
 */

@RestController
@RequestMapping("/recrumeVEG/")
public class JobOfferSearchController {

    @Autowired
    private JobOfferSearchService jobOfferSearchService;

    /**
     * Display a job offer with a particular id
     * @param id
     * @return job offer by id
     * @throws JobOfferNotFoundException
     */

    @GetMapping("joboffer/{id}")
    public JobOffer getJobOffer(@PathVariable int id)
            throws JobOfferNotFoundException {

        return jobOfferSearchService.getJobOffer(id);
    }

    /**
     * Display job offers with a particular title of position
     * @param titleOfPosition
     * @return a list of job offers with the same title of position
     * @throws JobOfferNotFoundException
     */

    @GetMapping("joboffer/title/{titleOfPosition}")
    public List<JobOffer> getJobOffersByPosition(@PathVariable String titleOfPosition)
            throws JobOfferNotFoundException {
        return jobOfferSearchService.readByPosition(titleOfPosition);
    }

    /**
     * Display job offers in a particular region
     * @param region
     * @return a list of job offers in this region
     * @throws JobOfferNotFoundException
     */

    @GetMapping("joboffer/region/{region}")
    public List<JobOffer> getJobOffersByRegion(@PathVariable String region)
            throws JobOfferNotFoundException {
        return jobOfferSearchService.readByRegion(region);
    }

    /**
     * Display job offers of a particular company
     * @param company
     * @return all job offers of this company
     * @throws JobOfferNotFoundException
     */

    @GetMapping("joboffer/company/{company}")
    public List<JobOffer> getJobOffersByCompany(@PathVariable String company)
            throws JobOfferNotFoundException {
        return jobOfferSearchService.readByCompany(company);
    }

    /**
     * Display job offers with a particular skill
     * @param description
     * @return list of job offers requesting this skill
     * @throws JobOfferNotFoundException
     */
    @GetMapping("joboffer/skill/{description}")
    public List<JobOffer> getJobOffersBySkill(@PathVariable String description)
            throws JobOfferNotFoundException {
        return jobOfferSearchService.searchJobOffersBySkill(description);
    }
}
