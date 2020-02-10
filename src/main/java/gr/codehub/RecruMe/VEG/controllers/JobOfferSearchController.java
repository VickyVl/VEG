package gr.codehub.RecruMe.VEG.controllers;

import gr.codehub.RecruMe.VEG.exceptions.JobOfferNotFoundException;
import gr.codehub.RecruMe.VEG.models.JobOffer;
import gr.codehub.RecruMe.VEG.services.JobOfferSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobOfferSearchController {

    @Autowired
    private JobOfferSearchService jobOfferSearchService;

    /**
     * endpoint http://localhost:8080/joboffer/{id}
     * @param id
     * @return get job offer by id
     * @throws JobOfferNotFoundException
     */
    @GetMapping("joboffer/{id}")
    public JobOffer getJobOffer(@PathVariable int id)
            throws JobOfferNotFoundException {

        return jobOfferSearchService.getJobOffer(id);
    }

    /**
     * endpoint http://localhost:8080/joboffer/title/{titleOfPosition}
     * @param titleOfPosition
     * @return all joboffers with the same title of position
     * @throws JobOfferNotFoundException
     */
    @GetMapping("joboffer/title/{titleOfPosition}")
    public List<JobOffer> getJobOffersByPosition(@PathVariable String titleOfPosition)
            throws JobOfferNotFoundException {
        return jobOfferSearchService.readByPosition(titleOfPosition);
    }

    /**
     * endpoint http://localhost:8080/joboffer/region/{region}
     * @param region
     * @return all joboffers with the same region
     * @throws JobOfferNotFoundException
     */
    @GetMapping("joboffer/region/{region}")
    public List<JobOffer> getJobOffersByRegion(@PathVariable String region)
            throws JobOfferNotFoundException {
        return jobOfferSearchService.readByRegion(region);
    }

    @GetMapping("joboffer/region/{company}")
    public List<JobOffer> getJobOffersByCompany(@PathVariable String region)
            throws JobOfferNotFoundException {
        return jobOfferSearchService.readByCompany(region);
    }
}
