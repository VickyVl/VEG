package gr.codehub.RecruMe.VEG.services;

import gr.codehub.RecruMe.VEG.dtos.JobOfferDto;
import gr.codehub.RecruMe.VEG.exceptions.JobOfferNotFoundException;
import gr.codehub.RecruMe.VEG.models.JobOffer;
import gr.codehub.RecruMe.VEG.repositories.JobOffers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobOfferUpdateService {
    @Autowired
    private JobOffers jobOfferRepo;

    public JobOffer updateOne(int id, JobOfferDto jobOfferDto) throws JobOfferNotFoundException {
        JobOffer jobOffer = jobOfferRepo.findById(id).get();
        if (jobOffer == null) {
            throw new JobOfferNotFoundException("Title Of Position id = " + id);
        }
        jobOffer.setTitleOfPosition(jobOfferDto.getTitleOfPosition());

        return jobOfferRepo.save(jobOffer);
    }

    public JobOffer activateStatus(int id, JobOfferDto jobOfferDto) throws JobOfferNotFoundException {
        JobOffer jobOffer = jobOfferRepo.findById(id).get();
        if (jobOffer == null) {
            throw new JobOfferNotFoundException("Job Offer id = " + id + " NOT FOUND");
        }
        jobOffer.setActive(true);

        return jobOfferRepo.save(jobOffer);
    }

    public JobOffer inactivateStatus(int id, JobOfferDto jobOfferDto) throws JobOfferNotFoundException {
        JobOffer jobOffer = jobOfferRepo.findById(id).get();
        if (jobOffer == null) {
            throw new JobOfferNotFoundException("Job Offer id = " + id + " NOT FOUND");
        }

        //        if (applicantDto.getFirstName() != null)
//            applicant.setFirstName(applicantDto.getFirstName());
        jobOffer.setActive(false);
        return jobOfferRepo.save(jobOffer);
    }

    public JobOffer updateRegion(int id, JobOfferDto jobOfferDto) throws JobOfferNotFoundException {
        JobOffer jobOffer = jobOfferRepo.findById(id).get();
        if (jobOffer == null) {
            throw new JobOfferNotFoundException("Job Offer id = " + id + " NOT FOUND");
        }

        jobOffer.setRegion(jobOfferDto.getRegion());
        return jobOfferRepo.save(jobOffer);
    }

    //educationLevel
    public JobOffer educationLevel(int id, JobOfferDto jobOfferDto) throws JobOfferNotFoundException {
        JobOffer jobOffer = jobOfferRepo.findById(id).get();
        if (jobOffer == null) {
            throw new JobOfferNotFoundException("Job Offer id = " + id + " NOT FOUND");
        }

        jobOffer.setEducationLevel(jobOfferDto.getEducationLevel());
        return jobOfferRepo.save(jobOffer);
    }


}
