package gr.codehub.RecruMe.VEG.controllers;

import gr.codehub.RecruMe.VEG.dtos.ApplicantDto;
import gr.codehub.RecruMe.VEG.dtos.JobOfferDto;
import gr.codehub.RecruMe.VEG.exceptions.ApplicantNotFoundException;
import gr.codehub.RecruMe.VEG.exceptions.JobOfferNotFoundException;
import gr.codehub.RecruMe.VEG.models.Applicant;
import gr.codehub.RecruMe.VEG.models.JobOffer;
import gr.codehub.RecruMe.VEG.services.JobOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobOfferController {
    @Autowired
    private JobOfferService jobOfferService;

    @GetMapping("joboffers")
    public List<JobOffer> readAll( ) {
        return jobOfferService.getAll();
    }

    @PostMapping("joboffer")
    public JobOffer newJobOffer(@RequestBody JobOfferDto jobOfferDto) {
        return jobOfferService.save(jobOfferDto);
    }

    @GetMapping("joboffer/{id}")
    public JobOffer getJobOffer(@PathVariable int id)
            throws ApplicantNotFoundException, JobOfferNotFoundException {

        return jobOfferService.getJobOffer(id);
    }

    @GetMapping("joboffer/title/{titleOfPosition}")
    public List<JobOffer> getJobOffersByPosition(@PathVariable String titleOfPosition)
            throws JobOfferNotFoundException {
        return jobOfferService.readByPosition(titleOfPosition);
    }

    @PutMapping("joboffer/{id}")
    public JobOffer updateOne(@PathVariable int id,
                               @RequestBody JobOfferDto jobOfferDto)
            throws JobOfferNotFoundException {
        return jobOfferService.updateOne(id, jobOfferDto);
    }
}
