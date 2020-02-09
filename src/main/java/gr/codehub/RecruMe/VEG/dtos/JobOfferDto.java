package gr.codehub.RecruMe.VEG.dtos;

import gr.codehub.RecruMe.VEG.models.JobSkill;
import gr.codehub.RecruMe.VEG.models.Skill;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class JobOfferDto {
    private String titleOfPosition;
    private String region;
    private String educationLevel;
    private List<JobSkill> jobSkills;
}
