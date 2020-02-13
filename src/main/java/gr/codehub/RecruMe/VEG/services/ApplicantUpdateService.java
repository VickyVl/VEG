package gr.codehub.RecruMe.VEG.services;

import gr.codehub.RecruMe.VEG.EnumTypes.LevelType;
import gr.codehub.RecruMe.VEG.dtos.ApplicantDto;
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

/**
 * ApplicantUpdateService implements methods for updating the applicants' data.
 * (update first name, last name, address, region, educational level, status, skill).
 */

@Service
public class ApplicantUpdateService {
    private Skills skillRepo;
    private Applicants applicantRepo;
    private ApplicantSkills applicantSkillRepo;

    @Autowired
    public ApplicantUpdateService(Skills skillRepo, Applicants applicantRepo, ApplicantSkills applicantSkillRepo) {
        this.skillRepo = skillRepo;
        this.applicantRepo = applicantRepo;
        this.applicantSkillRepo = applicantSkillRepo;
    }

    /**
     * Update the first name of an applicant
     * @param id
     * @param applicantDto
     * @return applicant with updated first name
     * @throws ApplicantNotFoundException
     */

    public Applicant updateFirstName(int id, ApplicantDto applicantDto) throws ApplicantNotFoundException {
        Applicant applicant = applicantRepo.findById(id).get();
        if (applicant == null) {
            throw new ApplicantNotFoundException("Applicant id = " + id + " NOT FOUND");
        }
        applicant.setFirstName(applicantDto.getFirstName());

        return applicantRepo.save(applicant);
    }

    /**
     * Update the last name of an applicant
     * @param id
     * @param applicantDto
     * @return applicant with updated last name
     * @throws ApplicantNotFoundException
     */

    public Applicant updateLastName(int id, ApplicantDto applicantDto) throws ApplicantNotFoundException {
        Applicant applicant = applicantRepo.findById(id).get();
        if (applicant == null) {
            throw new ApplicantNotFoundException("Applicant id = " + id + " NOT FOUND");
        }
        applicant.setLastName(applicantDto.getLastName());

        return applicantRepo.save(applicant);
    }

    /**
     * Update the address of an applicant
     * @param id
     * @param applicantDto
     * @return applicant with updated address
     * @throws ApplicantNotFoundException
     */
    public Applicant updateAddress(int id, ApplicantDto applicantDto) throws ApplicantNotFoundException {
        Applicant applicant = applicantRepo.findById(id).get();
        if (applicant == null) {
            throw new ApplicantNotFoundException("Applicant id = " + id + " NOT FOUND");
        }
        applicant.setAddress(applicantDto.getAddress());

        return applicantRepo.save(applicant);
    }

    /**
     * Update the region of an applicant
     * @param id
     * @param applicantDto
     * @return applicant with updated region
     * @throws ApplicantNotFoundException
     */
    public Applicant updateRegion(int id, ApplicantDto applicantDto) throws ApplicantNotFoundException {
        Applicant applicant = applicantRepo.findById(id).get();
        if (applicant == null) {
            throw new ApplicantNotFoundException("Applicant id = " + id + " NOT FOUND");
        }
        applicant.setRegion(applicantDto.getRegion());

        return applicantRepo.save(applicant);
    }

    /**
     * Update the education level of an applicant
     * @param id
     * @param applicantDto
     * @return applicant with updated education level
     * @throws ApplicantNotFoundException
     */

    public Applicant updateEducationLevel(int id, ApplicantDto applicantDto) throws ApplicantNotFoundException {
        Applicant applicant = applicantRepo.findById(id).get();
        if (applicant == null) {
            throw new ApplicantNotFoundException("Applicant id = " + id + " NOT FOUND");
        }
        applicant.setEducationLevel(applicantDto.getEducationLevel());

        return applicantRepo.save(applicant);
    }

    /**
     * Change the status of an applicant from inactive to active
     * @param id
     * @param applicantDto
     * @return applicant with active status
     * @throws ApplicantNotFoundException
     */
    public Applicant activateStatus(int id, ApplicantDto applicantDto) throws ApplicantNotFoundException {
        Applicant applicant = applicantRepo.findById(id).get();
        if (applicant == null) {
            throw new ApplicantNotFoundException("Applicant id = " + id + " NOT FOUND");
        }
        applicant.setActive(true);

        return applicantRepo.save(applicant);
    }

    /**
     * Change the status of an applicant from active to inactive
     * @param id
     * @param applicantDto
     * @return applicant with inactive status
     * @throws ApplicantNotFoundException
     */

    public Applicant inactivateStatus(int id, ApplicantDto applicantDto) throws ApplicantNotFoundException {
        Applicant applicant = applicantRepo.findById(id).get();
        if (applicant == null) {
            throw new ApplicantNotFoundException("Applicant id = " + id + " NOT FOUND");
        }
        applicant.setActive(false);

        return applicantRepo.save(applicant);
    }

    /**
     * Update the skill of an applicant
     * @param id
     * @param applicantDto
     * @return applicant with updated skill
     * @throws ApplicantNotFoundException
     */

    public Applicant updateApplicantSkill(int id, ApplicantDto applicantDto) throws ApplicantNotFoundException {
        Applicant applicant = applicantRepo.findById(id).get();
        if (applicant == null) {
            throw new ApplicantNotFoundException("Applicant id = " + id + " NOT FOUND");
        }
        List<String> skillsDescriptions = applicantDto.getApplicantSkillsDescriptions();
        List<ApplicantSkill> applicantSkills = new ArrayList<>();
        for (String d : skillsDescriptions) {
            Skill foundSkill = skillRepo.findFirstByDescription(d);
            ApplicantSkill as = new ApplicantSkill();
            as.setApplicant(applicant);
            as.setSkill(foundSkill);
            as = applicantSkillRepo.save(as);
            applicantSkills.add(as);
        }
        applicant.setApplicantSkills(applicantSkills);
        return applicantRepo.save(applicant);
    }

    /**
     * Update the level of an applicant
     * @param id
     * @param applicantDto
     * @return applicant with updated level
     * @throws ApplicantNotFoundException
     */
    public Applicant updateLevel(int id, ApplicantDto applicantDto) throws ApplicantNotFoundException {
        Applicant applicant = applicantRepo.findById(id).get();
        if (applicant == null) {
            throw new ApplicantNotFoundException("Applicant id = " + id + " NOT FOUND");
        }
        applicant.setLevel(applicantDto.getLevel());
        applicant.setLevelType(findLevelType(applicantDto.getLevel()));
        return applicantRepo.save(applicant);
    }

    /**
     * Set applicant's enum level type (JUNIOR, MID, SENIOR)
     * @param description of the level
     * @return LevelType
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
