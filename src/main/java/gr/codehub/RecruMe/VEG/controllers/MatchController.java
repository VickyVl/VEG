package gr.codehub.RecruMe.VEG.controllers;

import gr.codehub.RecruMe.VEG.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchController {
    @Autowired
    private MatchService matchService;
}
