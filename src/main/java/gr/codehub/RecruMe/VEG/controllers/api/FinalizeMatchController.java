package gr.codehub.RecruMe.VEG.controllers.api;

import gr.codehub.RecruMe.VEG.exceptions.MatchNotFoundException;
import gr.codehub.RecruMe.VEG.models.Match;
import gr.codehub.RecruMe.VEG.services.FinalizeMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The FinalizedMatchController defines an automatic or manual match between an applicant - job offer as finalized
 * and displays the above via the corresponding HTTP response as json file on the web.
 */

@RestController
@RequestMapping("/recrumeVEG/")
public class FinalizeMatchController {
    @Autowired
    private FinalizeMatchService finalizeMatchService;

    /**
     * Set an automatic or manual match of applicant - job offer as finalized
     * @param id
     * @return finalized match of applicant - job offer
     * @throws MatchNotFoundException
     */

    @PutMapping("match/finalize/{id}")
    public Match finalizeMatches(@PathVariable int id)
            throws  MatchNotFoundException {
        return finalizeMatchService.finalizeMatch(id);
    }
}
