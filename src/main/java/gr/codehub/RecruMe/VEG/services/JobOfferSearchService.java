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

    /**
     * show jobOffer by id
     * @param id
     * @return joboffer by id
     * @throws JobOfferNotFoundException
     */
    public JobOffer getJobOffer(int id) throws JobOfferNotFoundException {

        try {
            JobOffer jobOffer = jobOfferRepo.findById(id).get();
            return jobOffer;
        } catch (Exception e) {
            throw new JobOfferNotFoundException("Job Offer id = " + id + " NOT FOUND");
        }
    }

    /**
     * show jobOffer by titleOfPosition
     * @param titleOfPosition
     * @return jobOffer by titleOfPosition
     * @throws JobOfferNotFoundException
     */
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

    /**
     * show jobOffer by region
     * @param region
     * @return show jobOffer by region
     * @throws JobOfferNotFoundException
     */
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

    /**
     * show jobOffer by company
     * @param company
     * @return show jobOffer by company
     * @throws JobOfferNotFoundException
     */
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

    /**
     * show jobOffers by skill(description)
     * @param description
     * @return show jobOffers by skill(description)
     * @throws JobOfferNotFoundException
     */
    public List<JobOffer> searchJobOffersBySkill(String description) throws JobOfferNotFoundException {
        try {
            Skill skill = skillRepo.findByDescription(description);

            List<JobSkill> jobSkillsBySkillIdList = jobSkillRepo.findBySkillId(skill.getId());

            List<JobOffer> responseJobOffersList = new ArrayList<>();

            for(JobSkill jobSkill: jobSkillsBySkillIdList){
                responseJobOffersList.add(jobSkill.getJobOffer());
            }
            return responseJobOffersList;
        } catch (Exception e) {
            throw new JobOfferNotFoundException("SKILL " + description + " NOT FOUND" + e);
        }
    }
}
