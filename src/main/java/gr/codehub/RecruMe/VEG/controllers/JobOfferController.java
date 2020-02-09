package gr.codehub.RecruMe.VEG.controllers;

import gr.codehub.RecruMe.VEG.dtos.JobOfferDto;
import gr.codehub.RecruMe.VEG.exceptions.JobOfferNotFoundException;
import gr.codehub.RecruMe.VEG.models.JobOffer;
import gr.codehub.RecruMe.VEG.services.JobOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobOfferController {
    @Autowired
    private JobOfferService jobOfferService;

    /**
     * endpoint http://localhost:8080/joboffers
     * @return all job offers
     */
    @GetMapping("joboffers")
    public List<JobOffer> readAll( ) {
        return jobOfferService.getAll();
    }

    /**
     * create / insert new job offer
     * @param jobOfferDto
     * @return the new job offer
     */
    @PostMapping("joboffer")
    public JobOffer newJobOffer(@RequestBody JobOfferDto jobOfferDto) {
        return jobOfferService.save(jobOfferDto);
    }

    /**
     * endpoint http://localhost:8080/joboffer/{id}
     * @param id
     * @return get job offer bby id
     * @throws JobOfferNotFoundException
     */
    @GetMapping("joboffer/{id}")
    public JobOffer getJobOffer(@PathVariable int id)
            throws JobOfferNotFoundException {

        return jobOfferService.getJobOffer(id);
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
        return jobOfferService.readByPosition(titleOfPosition);
    }

}
