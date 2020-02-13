package gr.codehub.RecruMe.VEG.services;

import gr.codehub.RecruMe.VEG.EnumTypes.MatchType;
import gr.codehub.RecruMe.VEG.exceptions.ApplicantNotFoundException;
import gr.codehub.RecruMe.VEG.exceptions.JobOfferNotFoundException;
import gr.codehub.RecruMe.VEG.exceptions.MatchedAlreadyException;
import gr.codehub.RecruMe.VEG.models.Applicant;
import gr.codehub.RecruMe.VEG.models.JobOffer;
import gr.codehub.RecruMe.VEG.models.Match;
import gr.codehub.RecruMe.VEG.repositories.Applicants;
import gr.codehub.RecruMe.VEG.repositories.JobOffers;
import gr.codehub.RecruMe.VEG.repositories.Matches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * ManualMatchService implements methods for Matching Services.
 * Manual Match returned when an applicant is matched with a job offer manually.
 */

@Service
public class ManualMatchService {
    private Matches matchesRepo;
    private Applicants applicantRepo;
    private JobOffers jobOfferRepo;

    @Autowired
    public ManualMatchService(Matches matchRepo, Applicants applicantRepo, JobOffers jobOfferRepo) {
        this.matchesRepo = matchRepo;
        this.applicantRepo = applicantRepo;
        this.jobOfferRepo = jobOfferRepo;
    }

    /**
     * Display a manual match
     * @param jobOfferId
     * @return match of applicant and job offer
     * @throws MatchedAlreadyException
     * @throws JobOfferNotFoundException
     * @throws ApplicantNotFoundException
     */

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