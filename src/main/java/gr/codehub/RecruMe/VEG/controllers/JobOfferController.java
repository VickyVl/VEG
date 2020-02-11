package gr.codehub.RecruMe.VEG.controllers;

import gr.codehub.RecruMe.VEG.dtos.JobOfferDto;
import gr.codehub.RecruMe.VEG.exceptions.JobOfferNotFoundException;
import gr.codehub.RecruMe.VEG.exceptions.SkillNotFoundException;
import gr.codehub.RecruMe.VEG.models.JobOffer;
import gr.codehub.RecruMe.VEG.models.Skill;
import gr.codehub.RecruMe.VEG.services.JobOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * JobOfferController used here:
 * - to provide the data of all job offers
 * - to create a new job offer
 * displaying the above via the corresponding HTTP responses as json files on the web.
 */

@RestController
@RequestMapping("/recrumeVEG/")
public class JobOfferController {
    @Autowired
    private JobOfferService jobOfferService;

    /**
     * endpoint http://localhost:8080/recrumeVEG/joboffers
     * @return all job offers
     */

    @GetMapping("joboffers")
    public List<JobOffer> readAll( ) {
        return jobOfferService.getAll();
    }

    /**
     * endpoint http://localhost:8080/recrumeVEG/joboffer
     * create / insert new job offer
     * @param jobOfferDto
     * @return the new job offer
     */

    @PostMapping("joboffer")
    public JobOffer newJobOffer(@RequestBody JobOfferDto jobOfferDto) {
        return jobOfferService.save(jobOfferDto);
    }

    /**
     * endpoint http://localhost:8080/recrumeVEG/joboffer/excel
     * get all job offers from excel file
     * @return job offer from excel
     * @throws JobOfferNotFoundException
     * @throws IOException
     */
    @GetMapping("joboffer/excel")
    public List<JobOffer> getJobOfferExcel()
            throws JobOfferNotFoundException, IOException {
        return jobOfferService.getJobOfferExcel();
    }
}
