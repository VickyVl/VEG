package gr.codehub.RecruMe.VEG.controllers;

import gr.codehub.RecruMe.VEG.dtos.JobOfferDto;
import gr.codehub.RecruMe.VEG.exceptions.JobOfferNotFoundException;
import gr.codehub.RecruMe.VEG.models.JobOffer;
import gr.codehub.RecruMe.VEG.services.JobOfferService;
import gr.codehub.RecruMe.VEG.services.JobOfferUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobOfferUpdateController {
    @Autowired
    private JobOfferUpdateService jobOfferUpdateService;

    //TITLE OF POSITION
    @PutMapping("joboffer/{id}/title")
    public JobOffer updateOne(@PathVariable int id,
                              @RequestBody JobOfferDto jobOfferDto)
            throws JobOfferNotFoundException {
        return jobOfferUpdateService.updateOne(id, jobOfferDto);
    }

    @PutMapping("joboffer/{id}/activatestatus")
    public JobOffer activateStatus(@PathVariable int id,
                              @RequestBody JobOfferDto jobOfferDto)
            throws JobOfferNotFoundException {
        return jobOfferUpdateService.activateStatus(id, jobOfferDto);
    }

    @PutMapping("joboffer/{id}/inactivatestatus")
    public JobOffer inactivateStatus(@PathVariable int id,
                                 @RequestBody JobOfferDto jobOfferDto)
            throws JobOfferNotFoundException {
        return jobOfferUpdateService.inactivateStatus(id, jobOfferDto);
    }

    //REGION
    @PutMapping("joboffer/{id}/region")
    public JobOffer updateRegion(@PathVariable int id,
                                     @RequestBody JobOfferDto jobOfferDto)
            throws JobOfferNotFoundException {
        return jobOfferUpdateService.updateRegion(id, jobOfferDto);
    }

    //EDUCATION LEVEL
    @PutMapping("joboffer/{id}/educationLevel")
    public JobOffer educationLevel(@PathVariable int id,
                                 @RequestBody JobOfferDto jobOfferDto)
            throws JobOfferNotFoundException {
        return jobOfferUpdateService.educationLevel(id, jobOfferDto);
    }
}
