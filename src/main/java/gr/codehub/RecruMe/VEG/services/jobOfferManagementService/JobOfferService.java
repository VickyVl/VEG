package gr.codehub.RecruMe.VEG.services.jobOfferManagementService;

import gr.codehub.RecruMe.VEG.dtos.JobOfferDto;
import gr.codehub.RecruMe.VEG.models.JobOffer;
import gr.codehub.RecruMe.VEG.models.JobSkill;
import gr.codehub.RecruMe.VEG.models.Skill;
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

/**
 * JobOfferService implements methods for job offer functionalities (display all, register new job offer
 * and save the job offer data).
 */

@Service
public class JobOfferService {
    private JobOffers jobOfferRepo;
    private Skills skillRepo;
    private JobSkills jobSkillRepo;

    @Autowired
    public JobOfferService(JobOffers jobOfferRepo, Skills skillRepo, JobSkills jobSkillRepo) {
        this.jobOfferRepo = jobOfferRepo;
        this.skillRepo = skillRepo;
        this.jobSkillRepo = jobSkillRepo;
    }

    /**
     * Register and save job offer data from jobOfferDto
     * @param jobOfferDto
     * @return a jobOffer
     */

    public JobOffer save(JobOfferDto jobOfferDto) {
        JobOffer jobOffer = new JobOffer();
        jobOffer.setCompany(jobOfferDto.getCompany());
        jobOffer.setTitleOfPosition(jobOfferDto.getTitleOfPosition());
        jobOffer.setRegion(jobOfferDto.getRegion());
        jobOffer.setEducationLevel(jobOfferDto.getEducationLevel());
        jobOffer.setActive(true);

        List<String> skillsDescriptions = jobOfferDto.getJobOfferSkillsDescriptions();
        List<JobSkill> jobOfferSkills = new ArrayList<>();

        jobOffer = jobOfferRepo.save(jobOffer);

        for (String d : skillsDescriptions){
            Optional<Skill> foundSkill = skillRepo.findByDescription(d);
            JobSkill js = new JobSkill();
            js.setJobOffer(jobOffer);
            if (!foundSkill.isPresent()){
                Skill jobSkill = new Skill();
                jobSkill.setDescription(d);
                jobSkill = skillRepo.save(jobSkill);
                js.setSkill(jobSkill);
            }
            else {
                js.setSkill(foundSkill.get());
            }
            jobOfferSkills.add(js);
            js = jobSkillRepo.save(js);
        }

        jobOffer.setJobSkills(jobOfferSkills);
        return jobOfferRepo.save(jobOffer);
    }

    /**
     * Display all job offers from Job Offer Repository
     * @return all job offers
     */

    public List<JobOffer> getAll() {
        return
                StreamSupport
                        .stream(jobOfferRepo.findAll().spliterator(), false)
                        .collect(Collectors.toList());
    }
}

