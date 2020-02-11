package gr.codehub.RecruMe.VEG.services;

import gr.codehub.RecruMe.VEG.exceptions.ApplicantNotFoundException;
import gr.codehub.RecruMe.VEG.models.Applicant;
import gr.codehub.RecruMe.VEG.models.ApplicantSkill;
import gr.codehub.RecruMe.VEG.models.Skill;
import gr.codehub.RecruMe.VEG.repositories.ApplicantSkills;
import gr.codehub.RecruMe.VEG.repositories.Applicants;
import gr.codehub.RecruMe.VEG.repositories.Skills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ApplicantSearchService {
    private Applicants applicantRepo;
    private Skills skillRepo;
    private ApplicantSkills applicantSkillRepo;

    @Autowired
    public ApplicantSearchService(Applicants applicantRepo , Skills skillRepo , ApplicantSkills applicantSkillRepo) {
        this.applicantRepo = applicantRepo;
        this.skillRepo = skillRepo;
        this.applicantSkillRepo = applicantSkillRepo;
    }
    public Applicant getApplicant(int id) throws ApplicantNotFoundException {

        try {
            Applicant applicant = applicantRepo.findById(id).get();
            return applicant;
        } catch (Exception e) {
            throw new ApplicantNotFoundException("Applicant id = " + id + " NOT FOUND");
        }

    }

    public List<Applicant> searchByName(String firstName) throws ApplicantNotFoundException {
        try {
            return
                    StreamSupport
                            .stream(applicantRepo.findAll().spliterator(), false)
                            .filter(applicant -> applicant.getFirstName().equalsIgnoreCase(firstName))
                            .collect(Collectors.toList());
        } catch (Exception e) {
            throw new ApplicantNotFoundException(firstName + " NOT FOUND");
        }
    }

    public List<Applicant> searchByRegion(String region) throws ApplicantNotFoundException {
        try {
            return
                    StreamSupport
                            .stream(applicantRepo.findAll().spliterator(), false)
                            .filter(applicant -> applicant.getRegion().equalsIgnoreCase(region))
                            .collect(Collectors.toList());
        } catch (Exception e) {
            throw new ApplicantNotFoundException("Region = " + region + " NOT FOUND");
        }
    }

    public List<Applicant> searchBySkill(String description) throws ApplicantNotFoundException {
        try {
            Skill skill = skillRepo.findByDescription(description);
            List<ApplicantSkill> applicantSkillsBySkillIdList = applicantSkillRepo.findBySkillId(skill.getId());

            List<Applicant> responseApplicantsList = new ArrayList<>();
            for(ApplicantSkill applicantSkill: applicantSkillsBySkillIdList){
                Optional<Applicant> applicantOptional = applicantRepo.findById(applicantSkill.getApplicant().getId());
                responseApplicantsList.add(applicantOptional.get());
            }
           return responseApplicantsList;
        } catch (Exception e) {
            throw new ApplicantNotFoundException("SKILL " + description + " NOT FOUND" + e);
        }
    }
}
