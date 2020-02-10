package gr.codehub.RecruMe.VEG.services;

import gr.codehub.RecruMe.VEG.dtos.SkillDto;
import gr.codehub.RecruMe.VEG.exceptions.ApplicantNotFoundException;
import gr.codehub.RecruMe.VEG.exceptions.JobOfferNotFoundException;
import gr.codehub.RecruMe.VEG.models.*;
import gr.codehub.RecruMe.VEG.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
    private Matches matchRepo;
    private Applicants applicantRepo;
    private JobOffers jobOfferRepo;
    private ApplicantSkills applicantSkillRepo;
    private JobSkills jobSkilllRepo;

    @Autowired
    public MatchService(Matches matchRepo, Applicants applicantRepo, JobOffers jobOfferRepo, ApplicantSkills applicantSkillRepo, JobSkills jobSkilllRepo) {
        this.matchRepo = matchRepo;
        this.applicantRepo = applicantRepo;
        this.jobOfferRepo = jobOfferRepo;
        this.applicantSkillRepo = applicantSkillRepo;
        this.jobSkilllRepo = jobSkilllRepo;
    }

    /*

    public Match doeMatch(SkillDto skillDto) throws Exception {

        if (skillDto == null) throw new Exception("SKILL  dto is null");
        Applicant applicant = applicantRepo.findById(skillDto.getApplicantId()).get();
        if (applicant == null) throw new ApplicantNotFoundException("applicant is not found");

        JobOffer jobOffer = jobOfferRepo.findById(skillDto.getJobOfferId()).get();
        if (applicant == null) throw new JobOfferNotFoundException("joboffer is not found");

        Match match = new Match();
        match.setApplicantSkill(applicant.getApplicantSkills().get());

//        if (skillDto.getDescription() == null)
//            throw new Exception("given product list is null");

        List<ApplicantSkill> applicantSkills = applicant.getApplicantSkills();
        List<JobSkill> jobSkills = jobOffer.getJobSkills();

        for (int i = 0; i < jobSkills.size(); i++) {
            for (int j = 0; j < applicantSkills.size(); j++) {
                applicantSkills.get(j)
            }
        }
//
    }
*/

}
