package gr.codehub.RecruMe.VEG.services;

import gr.codehub.RecruMe.VEG.EnumTypes.MatchType;
import gr.codehub.RecruMe.VEG.exceptions.JobOfferNotFoundException;
import gr.codehub.RecruMe.VEG.exceptions.MatchNotFoundException;
import gr.codehub.RecruMe.VEG.models.Match;
import gr.codehub.RecruMe.VEG.repositories.Matches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FinalizeMatchService {
    @Autowired
    private Matches matchRepo;

    //finalizeMatch
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

    public List<Match> getFinalizedMatches() throws MatchNotFoundException {
        try {
           return matchRepo.getListOfFinalizedMatches();
        }catch (Exception e) {
            throw new MatchNotFoundException("MATCH NOT FOUNT");
        }
    }
}
