package gr.codehub.RecruMe.VEG.controllers.api;

import gr.codehub.RecruMe.VEG.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recrumeVEG/")
public class ReportingController {
    @Autowired
    private JobSkillService jobSkillService;

    @GetMapping("top5MostRequestedSkills")
    public List<String> getTop5MostRequestedSkills() {
        return jobSkillService.getTop5MostRequestedSkills();
    }

    @Autowired
    private ApplicantSkillService applicantSkillService;

    @GetMapping("top5MostOfferedSkills")
    public List<String> getTop5MostOfferedSkills() {
        return applicantSkillService.getTop5MostOfferedSkills();
    }

    @Autowired
    private ListMatchService listMatchService;

    @GetMapping("listOfProposedMatches")
    public List<String> getListOfProposedMatches() {
        return listMatchService.getListOfProposedMatched();
    }
}
//    @Autowired
//    private AutomaticMatchService automaticMatchService;
//    private ManualMatchService manualMatchService
//
//    @GetMapping("listOfFinalizedMatches")
//    public List<String> getListOfFinalizedMatches(){
//        return listMatchService.getListOfProposedMatched();
//    }
//}
