package gr.codehub.RecruMe.VEG.services.matchManagementService;

import gr.codehub.RecruMe.VEG.enumType.MatchType;
import gr.codehub.RecruMe.VEG.exceptions.ApplicantNotFoundException;
import gr.codehub.RecruMe.VEG.exceptions.JobOfferNotFoundException;
import gr.codehub.RecruMe.VEG.exceptions.MatchNotFoundException;
import gr.codehub.RecruMe.VEG.exceptions.MatchedAlreadyException;
import gr.codehub.RecruMe.VEG.models.*;
import gr.codehub.RecruMe.VEG.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * AutomaticMatchService implements methods for Matching Services.
 * Automatic Match returned once all job offer requested skills are fulfilled by the applicant's skills.
 */

@Service
public class AutomaticMatchService {
    private Matches matchesRepo;
    private Applicants applicantRepo;
    private JobOffers jobOfferRepo;
    private ApplicantSkills applicantSkills;
    private JobSkills jobSkills;

    @Autowired
    public AutomaticMatchService(Matches matchRepo, Applicants applicantRepo, JobOffers jobOfferRepo,
                                 ApplicantSkills applicantSkills, JobSkills jobSkills) {
        this.matchesRepo = matchRepo;
        this.applicantRepo = applicantRepo;
        this.jobOfferRepo = jobOfferRepo;
        this.applicantSkills = applicantSkills;
        this.jobSkills = jobSkills;
    }

    /**
     * Display automatic matches for a job offer
     * @param jobOfferId
     * @return matches of applicants if all requested job offer skills are fulfilled by the applicants' skills
     * @throws MatchedAlreadyException
     * @throws JobOfferNotFoundException
     * @throws ApplicantNotFoundException
     */

    public List<Match> automaticMatch(int jobOfferId) throws MatchedAlreadyException,
            JobOfferNotFoundException, ApplicantNotFoundException {
        List<Match> foundMatches = new ArrayList<>();
        List<JobSkill> jobSkillsFound = jobSkills.findByJobOfferId(jobOfferId);
        List<Skill> jobOfferSkills = new ArrayList<>();
        for (JobSkill js : jobSkillsFound) {
            jobOfferSkills.add(js.getSkill());
        }
        List<Applicant> applicants = applicantRepo.findAll();
        List<ApplicantSkill> applicantSkillsList = applicantSkills.findAll();
        //because there is no cascade
        for (Applicant app : applicants) {
            for (ApplicantSkill applicantSkill : applicantSkillsList) {
                if (applicantSkill.getApplicant().getId() == app.getId()) {
                    app.getApplicantSkills().add(applicantSkill);
                }
            }
        }
        for (Applicant applicant : applicants) {
            List<Skill> applicantSkills = new ArrayList<>();
            for (ApplicantSkill as : applicant.getApplicantSkills()) {
                applicantSkills.add(as.getSkill());
            }
            if (applicantSkills.containsAll(jobOfferSkills)) {
                Match match = new Match();
                applicant.setActive(false);
                applicantRepo.save(applicant);
                match.setApplicant(applicant);
                JobOffer jobOffer = new JobOffer();
                Optional<JobOffer> foundJobOfferOptional = jobOfferRepo.findById(jobOfferId);
                JobOffer foundJobOffer = foundJobOfferOptional.get();
                foundJobOffer.setActive(false);
                jobOfferRepo.save(foundJobOffer);
                jobOffer.setId(jobOfferId);
                match.setJobOffer(jobOffer);
                match.setType(MatchType.AUTOMATIC);
                match = matchesRepo.save(match);
                foundMatches.add(match);
            }
        }
        return foundMatches;
    }

    /**
     * Display one automatic match for a job offer
     * @param jobOfferId
     * @return a match with one applicant whose skills fulfill all requested job offer skills
     * @throws MatchedAlreadyException
     * @throws JobOfferNotFoundException
     * @throws ApplicantNotFoundException
     * @throws MatchNotFoundException
     */
    public Match automaticMatchForOne(int jobOfferId) throws MatchedAlreadyException,
            JobOfferNotFoundException, ApplicantNotFoundException, MatchNotFoundException {
        Match match = new Match();
        List<JobSkill> jobSkillslist = jobSkills.findByJobOfferId(jobOfferId);
        Optional<JobOffer> jobOffer = jobOfferRepo.findById(jobOfferId);
        List<Skill> jobSkills = new ArrayList<>();
        for (JobSkill j : jobSkillslist) {
            jobSkills.add(j.getSkill());
        }
        Applicant app = new Applicant();
        for (Applicant a : applicantRepo.findAll()) {
            List<Skill> applicantSkills = new ArrayList<>();
            for (ApplicantSkill as : a.getApplicantSkills()) {
                applicantSkills.add(as.getSkill());
            }
            if (applicantSkills.containsAll(jobSkills)) {
                app = a;
                match.setApplicant(a);
                match.setJobOffer(jobOffer.get());
                match.setType(MatchType.AUTOMATIC);
                matchesRepo.save(match);
                break;
            }
        }
        return match;
    }
}


