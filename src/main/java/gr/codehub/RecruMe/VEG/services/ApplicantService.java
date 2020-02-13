package gr.codehub.RecruMe.VEG.services;

import gr.codehub.RecruMe.VEG.EnumTypes.LevelType;
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
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ApplicantService {

    @Autowired
    private Applicants applicantRepo;

    @Autowired
    public ApplicantService(Applicants applicantRepo) {
        this.applicantRepo = applicantRepo;
    }

    @Autowired
    private Skills skillRepo;

    @Autowired
    private ApplicantSkills applicantSkillRepo;


    /**
     * Make and save a new applicant
     * @param applicantDto
     * @return applicant
     */
    public Applicant save(ApplicantDto applicantDto) {
        Applicant applicant = settingApplicantData(applicantDto);
        return  applicantRepo.save(applicant);
    }

    /**
     * Show all applicants
     * @return all applicant
     */
    public List<Applicant> getAll() {
        Applicant applicant = new Applicant();
        return
                StreamSupport
                        .stream(applicantRepo.findAll().spliterator(), false)
                        .collect(Collectors.toList());
    }

    /**
     * setting/saving applicant's data from applicantDto
     * @param applicantDto
     * @return an applicant
     */
    public Applicant settingApplicantData(ApplicantDto applicantDto){
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

        for (String d : skillsDescriptions){
            Skill foundSkill = skillRepo.findFirstByDescription(d);
            ApplicantSkill as = new ApplicantSkill();
            as.setApplicant(applicant);
            as.setSkill(foundSkill);
            as = applicantSkillRepo.save(as);
            applicantSkills.add(as);
        }
        applicant.setApplicantSkills(applicantSkills);
        return  applicantRepo.save(applicant);
    }



    /**
     * sets applicant's level type (JUNIOR, MID, SENIOR)
     * @param description of the level
     * @return a LevelType
     */
    public LevelType findLevelType(String description){
        LevelType levelType = null;

        if (description.equalsIgnoreCase("Junior")){
            levelType = LevelType.JUNIOR;
        }
        if (description.equalsIgnoreCase("Mid")){
            levelType = LevelType.MID;
        }
        if (description.equalsIgnoreCase("Senior")){
            levelType = LevelType.SENIOR;
        }
        return levelType;
    }

}



