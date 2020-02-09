package gr.codehub.RecruMe.VEG.dtos;

import gr.codehub.RecruMe.VEG.models.ApplicantSkill;
import gr.codehub.RecruMe.VEG.models.JobSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SkillDto {
    private String description;

    private List<ApplicantSkill> applicantSkills;
    private List<JobSkill> jobSkills;
}
