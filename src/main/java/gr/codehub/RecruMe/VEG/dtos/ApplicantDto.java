package gr.codehub.RecruMe.VEG.dtos;

import gr.codehub.RecruMe.VEG.models.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantDto {
    private String firstName;
    private String lastName;
    private String address;
    private String Region;
    private String educationLevel;
    private List<Skill> skills;
}
