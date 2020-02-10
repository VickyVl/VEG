package gr.codehub.RecruMe.VEG.services;

import gr.codehub.RecruMe.VEG.dtos.ApplicantDto;
import gr.codehub.RecruMe.VEG.dtos.JobOfferDto;
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
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class JobOfferService {
    @Autowired
    private JobOffers jobOfferRepo;

    @Autowired
    private Skills skillRepo;
    @Autowired
    private JobSkills jobSkillRepo;

    @Autowired
    public JobOfferService(JobOffers jobOfferRepo) {
        this.jobOfferRepo = jobOfferRepo;
    }

    public JobOffer save(JobOfferDto jobOfferDto) {
        JobOffer jobOffer = new JobOffer();
        jobOffer.setCompany(jobOfferDto.getCompany());
        jobOffer.setTitleOfPosition(jobOfferDto.getTitleOfPosition());
        jobOffer.setRegion(jobOfferDto.getRegion());
        jobOffer.setEducationLevel(jobOfferDto.getEducationLevel());

        List<String> skillsDescriptions = jobOfferDto.getJobOfferSkillsDescriptions();
        List<JobSkill> jobOfferSkills = new ArrayList<>();

        jobOffer = jobOfferRepo.save(jobOffer);

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

    public List<JobOffer> getAll() {
        return
                StreamSupport
                        .stream(jobOfferRepo.findAll().spliterator(), false)
                        .collect(Collectors.toList());
    }
}

