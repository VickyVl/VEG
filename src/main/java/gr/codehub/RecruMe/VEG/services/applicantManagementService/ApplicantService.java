package gr.codehub.RecruMe.VEG.services.applicantManagementService;

import gr.codehub.RecruMe.VEG.enumType.LevelType;
import gr.codehub.RecruMe.VEG.dtos.ApplicantDto;
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

/**
 * ApplicantService implements methods for applicant functionalities (display all, register new applicant
 * save applicants' data).
 */

@Service
public class ApplicantService {
    private Applicants applicantRepo;
    private Skills skillRepo;
    private ApplicantSkills applicantSkillRepo;

    @Autowired
    public ApplicantService(Applicants applicantRepo, Skills skillRepo, ApplicantSkills applicantSkillRepo) {
        this.applicantRepo = applicantRepo;
        this.skillRepo = skillRepo;
        this.applicantSkillRepo = applicantSkillRepo;
    }

    /**
     * Register and save a new applicant
     * @param applicantDto
     * @return an applicant
     */

    public Applicant save(ApplicantDto applicantDto) {
        Applicant applicant = settingApplicantData(applicantDto);
        return applicantRepo.save(applicant);
    }

    /**
     * Show all applicants
     * @return all applicants
     */

    public List<Applicant> getAll() {
        Applicant applicant = new Applicant();
        return
                StreamSupport
                        .stream(applicantRepo.findAll().spliterator(), false)
                        .collect(Collectors.toList());
    }

    /**
     * Save applicant's data from applicantDto
     * @param applicantDto
     * @return an applicant
     */

    public Applicant settingApplicantData(ApplicantDto applicantDto) {
        Applicant applicant = new Applicant();
        applicant.setFirstName(applicantDto.getFirstName());
        applicant.setLastName(applicantDto.getLastName());
        applicant.setAddress(applicantDto.getAddress());
        applicant.setRegion(applicantDto.getRegion());
        applicant.setEducationLevel(applicantDto.getEducationLevel());
        applicant.setLevel(applicantDto.getLevel());
        applicant.setActive(true);

        LevelType levelType = findLevelType(applicantDto.getLevel());
        applicant.setLevelType(levelType);
        applicant.setActive(true);
        applicantRepo.save(applicant);
        List<String> skillsDescriptions = applicantDto.getApplicantSkillsDescriptions();
        List<ApplicantSkill> applicantSkills = new ArrayList<>();

        for (String d : skillsDescriptions) {

            ApplicantSkill as = new ApplicantSkill();
            as.setApplicant(applicant);
            Optional<Skill> foundSkill = skillRepo.findByDescription(d);
            if (!foundSkill.isPresent()){
                Skill newSkill = new Skill();
                newSkill.setDescription(d);
                skillRepo.save(newSkill);
                as.setSkill(newSkill);
            }
            else{
                as.setSkill(foundSkill.get());
            }
            as = applicantSkillRepo.save(as);
            applicantSkills.add(as);
        }
        applicant.setApplicantSkills(applicantSkills);
        return applicantRepo.save(applicant);
    }

    /**
     * Set applicant's enum level type (JUNIOR, MID, SENIOR)
     * @param description of the level
     * @return levelType
     */

    public LevelType findLevelType(String description) {
        LevelType levelType = null;

        if (description.equalsIgnoreCase("Junior")) {
            levelType = LevelType.JUNIOR;
        }
        if (description.equalsIgnoreCase("Mid")) {
            levelType = LevelType.MID;
        }
        if (description.equalsIgnoreCase("Senior")) {
            levelType = LevelType.SENIOR;
        }
        return levelType;
    }
}



