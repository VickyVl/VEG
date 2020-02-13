package gr.codehub.RecruMe.VEG.controllers.api;

import gr.codehub.RecruMe.VEG.exceptions.ApplicantNotFoundException;
import gr.codehub.RecruMe.VEG.exceptions.JobOfferNotFoundException;
import gr.codehub.RecruMe.VEG.exceptions.MatchedAlreadyException;
import gr.codehub.RecruMe.VEG.models.Match;
import gr.codehub.RecruMe.VEG.services.ManualMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recrumeVEG/")
public class ManualMatchController {
    @Autowired
    private ManualMatchService ManualMatchService;

    /**
     * endpoint http://localhost:8080/recrumeVEG/applicant/{applicantId}/joboffer/{jobofferId}
     * make the manual match of an applicant with the job offer
     * @param applicantId
     * @param jobofferId
     * @return the manual match of an applicant with the job offer
     * @throws MatchedAlreadyException
     * @throws JobOfferNotFoundException
     * @throws ApplicantNotFoundException
     */
    @GetMapping("applicant/{applicantId}/joboffer/{jobofferId}")
    public Match getMatch(@PathVariable int applicantId, @PathVariable int jobofferId)
            throws MatchedAlreadyException, JobOfferNotFoundException, ApplicantNotFoundException {
        return ManualMatchService.manualMatch(applicantId, jobofferId);
    }
}
