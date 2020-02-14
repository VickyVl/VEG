package gr.codehub.RecruMe.VEG.services.jobOfferManagementService;

import gr.codehub.RecruMe.VEG.dtos.JobOfferDto;
import gr.codehub.RecruMe.VEG.exceptions.JobOfferNotFoundException;
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

/**
 * JobOfferUpdateService implements methods for updating the job offer data.
 * (title of position, status, region, education level, company, skill)
 */

@Service
public class JobOfferUpdateService {
    private JobOffers jobOfferRepo;
    private JobSkills jobSkillRepo;
    private Skills skillRepo;

    @Autowired
    public JobOfferUpdateService(JobOffers jobOfferRepo, JobSkills jobSkillRepo, Skills skillRepo) {
        this.jobOfferRepo = jobOfferRepo;
        this.jobSkillRepo = jobSkillRepo;
        this.skillRepo = skillRepo;
    }

    /**
     * Update the title of the position of a job offer
     * @param id
     * @param jobOfferDto
     * @return job offer with updated title of position
     * @throws JobOfferNotFoundException
     */

    public JobOffer updateTitleOfPosition(int id, JobOfferDto jobOfferDto) throws JobOfferNotFoundException {
        JobOffer jobOffer = jobOfferRepo.findById(id).get();
        if (jobOffer == null) {
            throw new JobOfferNotFoundException("Title Of Position id = " + id);
        }
        jobOffer.setTitleOfPosition(jobOfferDto.getTitleOfPosition());

        return jobOfferRepo.save(jobOffer);
    }

    /**
     * Update the status of a job offer from inactive to active
     * @param id
     * @param jobOfferDto
     * @return job offer with updated status
     * @throws JobOfferNotFoundException
     */

    public JobOffer activateStatus(int id, JobOfferDto jobOfferDto) throws JobOfferNotFoundException {
        JobOffer jobOffer = jobOfferRepo.findById(id).get();
        if (jobOffer == null) {
            throw new JobOfferNotFoundException("Job Offer id = " + id + " NOT FOUND");
        }
        jobOffer.setActive(true);

        return jobOfferRepo.save(jobOffer);
    }

    /**
     * Update the status of a job offer from active to inactive
     * @param id
     * @param jobOfferDto
     * @return job offer with updated status
     * @throws JobOfferNotFoundException
     */

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

    /**
     * Update the region of a job offer
     * @param id
     * @param jobOfferDto
     * @return job offer with updated region
     * @throws JobOfferNotFoundException
     */

    public JobOffer updateRegion(int id, JobOfferDto jobOfferDto) throws JobOfferNotFoundException {
        JobOffer jobOffer = jobOfferRepo.findById(id).get();
        if (jobOffer == null) {
            throw new JobOfferNotFoundException("Job Offer id = " + id + " NOT FOUND");
        }

        jobOffer.setRegion(jobOfferDto.getRegion());
        return jobOfferRepo.save(jobOffer);
    }

    /**
     * Update the education level of a job offer
     * @param id
     * @param jobOfferDto
     * @return job offer with updated education level
     * @throws JobOfferNotFoundException
     */

    public JobOffer educationLevel(int id, JobOfferDto jobOfferDto) throws JobOfferNotFoundException {
        JobOffer jobOffer = jobOfferRepo.findById(id).get();
        if (jobOffer == null) {
            throw new JobOfferNotFoundException("Job Offer id = " + id + " NOT FOUND");
        }

        jobOffer.setEducationLevel(jobOfferDto.getEducationLevel());
        return jobOfferRepo.save(jobOffer);
    }

    /**
     * Update the company offering the job
     * @param id
     * @param jobOfferDto
     * @return job offer with updated company
     * @throws JobOfferNotFoundException
     */

    public JobOffer company(int id, JobOfferDto jobOfferDto) throws JobOfferNotFoundException {
        JobOffer jobOffer = jobOfferRepo.findById(id).get();
        if (jobOffer == null) {
            throw new JobOfferNotFoundException("Job Offer id = " + id + " NOT FOUND");
        }

        jobOffer.setCompany(jobOfferDto.getCompany());
        return jobOfferRepo.save(jobOffer);
    }

    /**
     * Update the skill of a job offer
     * @param id
     * @param jobOfferDto
     * @return job offer with updated skill
     * @throws JobOfferNotFoundException
     */

    public JobOffer updateJobOfferSkill(int id, JobOfferDto jobOfferDto) throws JobOfferNotFoundException {
        JobOffer jobOffer = jobOfferRepo.findById(id).get();
        if (jobOffer == null) {
            throw new JobOfferNotFoundException("Job Offer id = " + id + " NOT FOUND");
        }

        List<String> skillsDescriptions = jobOfferDto.getJobOfferSkillsDescriptions();
        List<JobSkill> jobOfferSkills = new ArrayList<>();

        for (String d : skillsDescriptions){
            Skill foundSkill = skillRepo.findFirstByDescription(d);
            JobSkill js = new JobSkill();
            js.setJobOffer(jobOffer);
            js.setSkill(foundSkill);

            js = jobSkillRepo.save(js);
            jobOfferSkills.add(js);
        }

        jobOffer.setJobSkills(jobOfferSkills);
        return jobOfferRepo.save(jobOffer);
    }
}
