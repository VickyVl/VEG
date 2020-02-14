package gr.codehub.RecruMe.VEG.controllers.api;

import gr.codehub.RecruMe.VEG.dtos.ApplicantDto;
import gr.codehub.RecruMe.VEG.models.Applicant;
import gr.codehub.RecruMe.VEG.services.applicantManagementService.ApplicantExcelService;
import gr.codehub.RecruMe.VEG.services.applicantManagementService.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * ApplicantController used here:
 * - to provide the data of all applicants
 * - to register a new applicant
 * - to display all applicants from the excel file
 * displaying all the above via the corresponding HTTP responses as json files on the web.
 */

@RestController
@RequestMapping("/recrumeVEG/")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @Autowired
    private ApplicantExcelService applicantExcelService;

    /**
     * Display all applicants from database
     * @return all applicants
     */

    @GetMapping("applicants")
    public List<Applicant> readAll() {
        return applicantService.getAll();
    }

    /**
     * register a new applicant
     * @param applicantDto
     * @return new applicant
     */

    @PostMapping("applicant")
    public Applicant newApplicant(@RequestBody ApplicantDto applicantDto) {
        return applicantService.save(applicantDto);
    }

    /**
     * Retrieve all applicants from excel file
     * @return applicants from excel
     * @throws IOException
     */

    @GetMapping("applicant/excel")
    public List<Applicant> getApplicantExcel()
            throws IOException {
        return applicantExcelService.getApplicantExcel();
    }
}
