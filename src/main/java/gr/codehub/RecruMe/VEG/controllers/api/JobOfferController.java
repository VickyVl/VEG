package gr.codehub.RecruMe.VEG.controllers.api;

import gr.codehub.RecruMe.VEG.dtos.JobOfferDto;
import gr.codehub.RecruMe.VEG.models.JobOffer;
import gr.codehub.RecruMe.VEG.services.JobOfferExcelService;
import gr.codehub.RecruMe.VEG.services.JobOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * JobOfferController used here:
 * - to provide the data of all job offers
 * - to register a new job offer
 * - to display all job offers from the excel file
 * displaying the above via the corresponding HTTP responses as json files on the web.
 */

@RestController
@RequestMapping("/recrumeVEG/")
public class JobOfferController {
    @Autowired
    private JobOfferService jobOfferService;
    @Autowired
    private JobOfferExcelService jobOfferExcelService;

    /**
     * Display all job offers from database
     * @return all job offers
     */

    @GetMapping("joboffers")
    public List<JobOffer> readAll( ) {
        return jobOfferService.getAll();
    }

    /**
     * Register a new job offer
     * @param jobOfferDto
     * @return the new job offer
     */

    @PostMapping("joboffer")
    public JobOffer newJobOffer(@RequestBody JobOfferDto jobOfferDto) {
        return jobOfferService.save(jobOfferDto);
    }

    /**
     * Retrieve all job offers from excel file
     * @return job offers from excel
     * @throws IOException
     */

    @GetMapping("joboffer/excel")
    public List<JobOffer> getJobOfferExcel()
            throws IOException {
        return jobOfferExcelService.getJobOfferExcel();
    }
}
