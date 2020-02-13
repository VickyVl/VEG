package gr.codehub.RecruMe.VEG.controllers.api;

import gr.codehub.RecruMe.VEG.dtos.ApplicantDto;
import gr.codehub.RecruMe.VEG.exceptions.ApplicantNotFoundException;
import gr.codehub.RecruMe.VEG.exceptions.MatchNotFoundException;
import gr.codehub.RecruMe.VEG.models.Applicant;
import gr.codehub.RecruMe.VEG.models.Match;
import gr.codehub.RecruMe.VEG.services.FinalizeMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recrumeVEG/")
public class FinalizeMatchController {
    @Autowired
    private FinalizeMatchService finalizeMatchService;

    @PutMapping("match/finalize/{id}")
    public Match finalizeMatches(@PathVariable int id)
            throws  MatchNotFoundException {
        return finalizeMatchService.finalizeMatch(id);
    }
}
