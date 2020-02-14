package gr.codehub.RecruMe.VEG.controllers.api;

import gr.codehub.RecruMe.VEG.exceptions.ApplicantNotFoundException;
import gr.codehub.RecruMe.VEG.exceptions.JobOfferNotFoundException;
import gr.codehub.RecruMe.VEG.exceptions.MatchNotFoundException;
import gr.codehub.RecruMe.VEG.exceptions.MatchedAlreadyException;
import gr.codehub.RecruMe.VEG.models.Match;
import gr.codehub.RecruMe.VEG.services.matchManagementService.AutomaticMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The AutomaticMatchController matches the job offer with the applicants possessing all the skills requested
 * by the job offer and displays the above via the corresponding HTTP response as json file on the web.
 */

@RestController
@RequestMapping("/recrumeVEG/")
public class AutomaticMatchController {
    @Autowired
    private AutomaticMatchService automaticMatchService;

    /**
     * Automatic Match of a job offer with applicants whose skills fulfill all requested job skills
     * @param jobofferId
     * @return all automatic matches of a job offer with applicants
     * @throws MatchedAlreadyException
     * @throws JobOfferNotFoundException
     * @throws ApplicantNotFoundException
     */

    @GetMapping("auto/applicants/{jobofferId}")
    public List<Match> getMatch(@PathVariable int jobofferId)
            throws MatchedAlreadyException, JobOfferNotFoundException, ApplicantNotFoundException {
        return automaticMatchService.automaticMatch(jobofferId);
    }

    /**
     * Automatic Match of a job offer with one applicant whose skills fulfill all requested job skills
     * @param jobofferId
     * @return one automatic matches of a job offer with one applicant
     * @throws MatchedAlreadyException
     * @throws JobOfferNotFoundException
     * @throws ApplicantNotFoundException
     */

    @GetMapping("auto/applicant/{jobofferId}")
    public Match getOneMatch(@PathVariable int jobofferId)
            throws MatchedAlreadyException, JobOfferNotFoundException, ApplicantNotFoundException, MatchNotFoundException {
        return automaticMatchService.automaticMatchForOne(jobofferId);
    }
}
