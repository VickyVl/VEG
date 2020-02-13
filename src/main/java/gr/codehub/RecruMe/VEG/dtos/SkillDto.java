package gr.codehub.RecruMe.VEG.dtos;

import gr.codehub.RecruMe.VEG.models.ApplicantSkill;
import gr.codehub.RecruMe.VEG.models.JobSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Entity SkillDto aggregates the data of the object to be transferred and served by the Post call,
 * when a new skill is registered in the system.
 * Fundamental methods/tools imported from Lombok Library.
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SkillDto {
    private String description;

    private int applicantId;
    private int jobOfferId;

    private List<ApplicantSkill> applicantSkills;
    private List<JobSkill> jobSkills;
}
