package gr.codehub.RecruMe.VEG.controllers.api;

import gr.codehub.RecruMe.VEG.exceptions.ApplicantNotFoundException;
import gr.codehub.RecruMe.VEG.exceptions.JobOfferNotFoundException;
import gr.codehub.RecruMe.VEG.exceptions.MatchedAlreadyException;
import gr.codehub.RecruMe.VEG.models.Match;
import gr.codehub.RecruMe.VEG.services.AutomaticMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * AutomaticMatchController used here to provide the data of a matching service.
 * The automatic match matches the job offer with the applicant possessing all the requested skills by the job offer.
 * Display the above via the corresponding HTTP response as json file on the web.
 */

@RestController
@RequestMapping("/recrumeVEG/")
public class AutomaticMatchController {
    @Autowired
    private AutomaticMatchService automaticMatchService;

    /**
     * Automatic Match of a job offer with an applicant
     * @param jobofferId
     * @return an automatic match of a job offer with an applicant whose skills fulfill all requested job skills
     * @throws MatchedAlreadyException
     * @throws JobOfferNotFoundException
     * @throws ApplicantNotFoundException
     */

    @GetMapping("auto/applicants/{jobofferId}")
    public List<Match> getMatch(@PathVariable int jobofferId)
            throws MatchedAlreadyException, JobOfferNotFoundException, ApplicantNotFoundException {
        return automaticMatchService.automaticMatch(jobofferId);
    }
}
