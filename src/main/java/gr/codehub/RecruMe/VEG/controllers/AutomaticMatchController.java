package gr.codehub.RecruMe.VEG.controllers;

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

@RestController
@RequestMapping("/recrumeVEG/")
public class AutomaticMatchController {
    @Autowired
    private AutomaticMatchService automaticMatchService;

    /**
     *
     * @param jobofferId
     * @return a list of match applicants with
     * @throws MatchedAlreadyException
     * @throws JobOfferNotFoundException
     * @throws ApplicantNotFoundException
     */
    @GetMapping("auto/applicant/{jobofferId}")
    public List<Match> getMatch(@PathVariable int jobofferId)
            throws MatchedAlreadyException, JobOfferNotFoundException, ApplicantNotFoundException {
        return automaticMatchService.automaticMatch(jobofferId);
    }
}
