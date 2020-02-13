package gr.codehub.RecruMe.VEG.services;

import gr.codehub.RecruMe.VEG.exceptions.ApplicantNotFoundException;
import gr.codehub.RecruMe.VEG.exceptions.JobOfferNotFoundException;
import gr.codehub.RecruMe.VEG.exceptions.MatchedAlreadyException;
import gr.codehub.RecruMe.VEG.models.Applicant;
import gr.codehub.RecruMe.VEG.models.JobOffer;
import gr.codehub.RecruMe.VEG.models.Match;
import gr.codehub.RecruMe.VEG.EnumTypes.MatchType;
import gr.codehub.RecruMe.VEG.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManualMatchService {
    private Matches matchesRepo;
    private Applicants applicantRepo;
    private JobOffers jobOfferRepo;
    private ApplicantSkills applicantSkillRepo;
    private JobSkills jobSkilllRepo;

    @Autowired
    public ManualMatchService(Matches matchRepo, Applicants applicantRepo, JobOffers jobOfferRepo, ApplicantSkills applicantSkillRepo, JobSkills jobSkilllRepo) {
        this.matchesRepo = matchRepo;
        this.applicantRepo = applicantRepo;
        this.jobOfferRepo = jobOfferRepo;
        this.applicantSkillRepo = applicantSkillRepo;
        this.jobSkilllRepo = jobSkilllRepo;
    }

    public Applicant getApplicant(int id) throws ApplicantNotFoundException {
        try {
            Applicant applicant = applicantRepo.findById(id).get();
            return applicant;
        } catch (Exception e) {
            throw new ApplicantNotFoundException("Applicant id = " + id + " NOT FOUND");
        }
    }


    public JobOffer getJobOffer(int id) throws JobOfferNotFoundException {

        try {
            JobOffer jobOffer = jobOfferRepo.findById(id).get();
            return jobOffer;
        } catch (Exception e) {
            throw new JobOfferNotFoundException("Job Offer id = " + id + " NOT FOUND");
        }
    }

    public Match manualMatch(int applicantId, int jobOfferId) throws MatchedAlreadyException,
            JobOfferNotFoundException, ApplicantNotFoundException {
        Optional<JobOffer> job = jobOfferRepo.findById(jobOfferId);
        Optional<Applicant> app = applicantRepo.findById(applicantId);

        if (job.isEmpty()) throw new JobOfferNotFoundException("Sorry, job offer not found");
        if (app.isEmpty()) throw new ApplicantNotFoundException("Sorry, applicant not found");

        if (!app.get().isActive()) throw new MatchedAlreadyException("Already matched applicant");
        if (!job.get().isActive()) throw new MatchedAlreadyException("Already matched job");

        Match manualMatch = new Match();
        manualMatch.setApplicant(app.get());
        manualMatch.setJobOffer(job.get());
        manualMatch.setType(MatchType.MANUAL);
        matchesRepo.save(manualMatch);

        job.get().setActive(false);
        jobOfferRepo.save(job.get());

        app.get().setActive(false);
        applicantRepo.save(app.get());
        
        return manualMatch;
    }
}