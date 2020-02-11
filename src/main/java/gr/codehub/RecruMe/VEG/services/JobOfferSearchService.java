package gr.codehub.RecruMe.VEG.services;

import gr.codehub.RecruMe.VEG.exceptions.ApplicantNotFoundException;
import gr.codehub.RecruMe.VEG.exceptions.JobOfferNotFoundException;
import gr.codehub.RecruMe.VEG.models.*;
import gr.codehub.RecruMe.VEG.repositories.ApplicantSkills;
import gr.codehub.RecruMe.VEG.repositories.JobOffers;
import gr.codehub.RecruMe.VEG.repositories.JobSkills;
import gr.codehub.RecruMe.VEG.repositories.Skills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class JobOfferSearchService {

    private JobOffers jobOfferRepo;
    private Skills skillRepo;
    private JobSkills jobSkillRepo;


    @Autowired
    public JobOfferSearchService(JobOffers jobOfferRepo,Skills skillRepo,JobSkills jobSkillRepo) {
        this.jobOfferRepo = jobOfferRepo;
        this.skillRepo = skillRepo;
        this.jobSkillRepo = jobSkillRepo;
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


    public List<JobOffer> searchJobOffersBySkill(String description) throws JobOfferNotFoundException {
        try {
            Skill skill = skillRepo.findByDescription(description);
            List<JobSkill> jobSkillsBySkillIdList = jobSkillRepo.findBySkillId(skill.getId());

            List<JobOffer> responseJobOffersList = new ArrayList<>();

            for(JobSkill jobSkill: jobSkillsBySkillIdList){
                Optional<JobOffer> jobOfferOptional = jobOfferRepo.findById(jobSkill.getJobOffer().getId());
                responseJobOffersList.add(jobOfferOptional.get());
            }
            return responseJobOffersList;
        } catch (Exception e) {
            throw new JobOfferNotFoundException("SKILL " + description + " NOT FOUND" + e);
        }
    }
}
