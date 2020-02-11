package gr.codehub.RecruMe.VEG.controllers;

import gr.codehub.RecruMe.VEG.dtos.ApplicantDto;
import gr.codehub.RecruMe.VEG.exceptions.ApplicantNotFoundException;
import gr.codehub.RecruMe.VEG.exceptions.JobOfferNotFoundException;
import gr.codehub.RecruMe.VEG.models.Applicant;
import gr.codehub.RecruMe.VEG.models.JobOffer;
import gr.codehub.RecruMe.VEG.services.ApplicantExcelService;
import gr.codehub.RecruMe.VEG.services.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * ApplicantController used here:
 * - to provide the data of all applicants
 * - to create a new applicant
 * displaying the above via the corresponding HTTP responses as json files on the web.
 */

@RestController
@RequestMapping("/recrumeVEG/")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @Autowired
    private ApplicantExcelService applicantExcelService;

    /**
     * endpoint http://localhost:8080/recrumeVEG/applicants
     * @return all applicants
     */

    @GetMapping("applicants")
    public List<Applicant> readAll() {
        return applicantService.getAll();
    }

    /**
     * endpoint http://localhost:8080/recrumeVEG/applicant
     * create a new applicant
     * @param applicantDto
     * @return new applicant
     */

    @PostMapping("applicant")
    public Applicant newApplicant(@RequestBody ApplicantDto applicantDto) {
        return applicantService.save(applicantDto);
    }

    /**
     *endpoint http://localhost:8080/recrumeVEG/applicant/excel
     * get all applicants from excel file
     * @return applicant from excel
     * @throws JobOfferNotFoundException
     * @throws IOException
     */
    @GetMapping("applicant/excel")
    public List<Applicant> getApplicantExcel()
            throws JobOfferNotFoundException, IOException {
        return applicantExcelService.getApplicantExcel();
    }
}
