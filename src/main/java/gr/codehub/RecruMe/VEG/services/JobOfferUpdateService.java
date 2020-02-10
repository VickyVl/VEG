package gr.codehub.RecruMe.VEG.services;

import gr.codehub.RecruMe.VEG.dtos.JobOfferDto;
import gr.codehub.RecruMe.VEG.exceptions.JobOfferNotFoundException;
import gr.codehub.RecruMe.VEG.models.ApplicantSkill;
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

@Service
public class JobOfferUpdateService {
    @Autowired
    private JobOffers jobOfferRepo;
    @Autowired
    private JobSkills jobSkillRepo;
    @Autowired
    private Skills skillRepo;
    @Autowired
    public JobOfferUpdateService(JobOffers jobOfferRepo) {
        this.jobOfferRepo = jobOfferRepo;
    }

    public JobOffer updateTitleOfPosition(int id, JobOfferDto jobOfferDto) throws JobOfferNotFoundException {
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

    public JobOffer educationLevel(int id, JobOfferDto jobOfferDto) throws JobOfferNotFoundException {
        JobOffer jobOffer = jobOfferRepo.findById(id).get();
        if (jobOffer == null) {
            throw new JobOfferNotFoundException("Job Offer id = " + id + " NOT FOUND");
        }

        jobOffer.setEducationLevel(jobOfferDto.getEducationLevel());
        return jobOfferRepo.save(jobOffer);
    }

    public JobOffer company(int id, JobOfferDto jobOfferDto) throws JobOfferNotFoundException {
        JobOffer jobOffer = jobOfferRepo.findById(id).get();
        if (jobOffer == null) {
            throw new JobOfferNotFoundException("Job Offer id = " + id + " NOT FOUND");
        }

        jobOffer.setCompany(jobOfferDto.getCompany());
        return jobOfferRepo.save(jobOffer);
    }

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
