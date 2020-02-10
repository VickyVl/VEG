package gr.codehub.RecruMe.VEG.services;

import gr.codehub.RecruMe.VEG.exceptions.JobOfferNotFoundException;
import gr.codehub.RecruMe.VEG.models.JobOffer;
import gr.codehub.RecruMe.VEG.repositories.JobOffers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class JobOfferSearchService {

    @Autowired
    private JobOffers jobOfferRepo;

    public JobOffer getJobOffer(int id) throws JobOfferNotFoundException {

        try {
            JobOffer jobOffer = jobOfferRepo.findById(id).get();
            return jobOffer;
        } catch (Exception e) {
            throw new JobOfferNotFoundException("Job Offer id = " + id + " NOT FOUND");
        }
    }

    public List<JobOffer> readByPosition(String titleOfPosition) throws JobOfferNotFoundException {
        try {
            return
                    StreamSupport
                            .stream(jobOfferRepo.findAll().spliterator(), false)
                            .filter(jobOffer -> jobOffer.getTitleOfPosition().equalsIgnoreCase(titleOfPosition))
                            .collect(Collectors.toList());
        } catch (Exception e) {
            throw new JobOfferNotFoundException("Title Of Position = " + titleOfPosition + " NOT FOUNT");
        }
    }

    public List<JobOffer> readByRegion(String region) throws JobOfferNotFoundException {
        try {
            return
                    StreamSupport
                            .stream(jobOfferRepo.findAll().spliterator(), false)
                            .filter(jobOffer -> jobOffer.getRegion().equalsIgnoreCase(region))
                            .collect(Collectors.toList());
        } catch (Exception e) {
            throw new JobOfferNotFoundException("Region = " + region + " NOT FOUNT");
        }
    }

    public List<JobOffer> readByCompany(String company) throws JobOfferNotFoundException {
        try {
            return
                    StreamSupport
                            .stream(jobOfferRepo.findAll().spliterator(), false)
                            .filter(jobOffer -> jobOffer.getCompany().equalsIgnoreCase(company))
                            .collect(Collectors.toList());
        } catch (Exception e) {
            throw new JobOfferNotFoundException("Company = " + company + " NOT FOUNT");
        }
    }
}
