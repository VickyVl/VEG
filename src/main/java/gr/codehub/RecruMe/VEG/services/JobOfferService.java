package gr.codehub.RecruMe.VEG.services;

import gr.codehub.RecruMe.VEG.dtos.ApplicantDto;
import gr.codehub.RecruMe.VEG.dtos.JobOfferDto;
import gr.codehub.RecruMe.VEG.exceptions.ApplicantNotFoundException;
import gr.codehub.RecruMe.VEG.exceptions.JobOfferNotFoundException;
import gr.codehub.RecruMe.VEG.models.Applicant;
import gr.codehub.RecruMe.VEG.models.JobOffer;
import gr.codehub.RecruMe.VEG.models.Skill;
import gr.codehub.RecruMe.VEG.repositories.JobOffers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class JobOfferService {
    @Autowired
    private JobOffers jobOfferRepo;

    public JobOffer save(JobOfferDto jobOfferDto) {
        JobOffer jobOffer = new JobOffer();
        jobOffer.setTitleOfPosition(jobOfferDto.getTitleOfPosition());
        jobOffer.setRegion(jobOfferDto.getRegion());
        jobOffer.setEducationLevel(jobOfferDto.getEducationLevel());
        // TO DO SET UP SKILLS

        List<Skill> skills = jobOfferDto.getSkills();

        jobOffer.setActive(true);

        return jobOfferRepo.save(jobOffer);
    }

    public List<JobOffer> getAll() {
        return
                StreamSupport
                        .stream(jobOfferRepo.findAll().spliterator(), false)
                        .collect(Collectors.toList());
    }

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
}

