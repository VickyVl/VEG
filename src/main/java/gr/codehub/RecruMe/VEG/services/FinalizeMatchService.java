package gr.codehub.RecruMe.VEG.services;

import gr.codehub.RecruMe.VEG.EnumTypes.MatchType;
import gr.codehub.RecruMe.VEG.exceptions.MatchNotFoundException;
import gr.codehub.RecruMe.VEG.models.Match;
import gr.codehub.RecruMe.VEG.repositories.Matches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * FinalizeMatchService implements methods in order to finalize an automatic or manual match
 * between an applicant and a job offer.
 */

@Service
public class FinalizeMatchService {
    @Autowired
    private Matches matchRepo;

    //finalizeMatch

    /**
     * Finalize an automatic/manual match between an applicant and a job offer
     * @param id
     * @return finalized match
     * @throws MatchNotFoundException
     */

    public Match finalizeMatch(int id) throws MatchNotFoundException {
        try {
            Match match = matchRepo.findAll().get(id);
            match.setType(MatchType.FINALIZED);
            matchRepo.save(match);
            return match;
        } catch (Exception e) {
            throw new MatchNotFoundException("MATCH NOT FOUNT");
        }
    }

    /**
     * Show a list of finalized matches between applicants and job offers
     * @return a list of finalized matches
     * @throws MatchNotFoundException
     */

    public List<Match> getFinalizedMatches() throws MatchNotFoundException {
        try {
           return matchRepo.getListOfFinalizedMatches();
        }catch (Exception e) {
            throw new MatchNotFoundException("MATCH NOT FOUNT");
        }
    }
}
