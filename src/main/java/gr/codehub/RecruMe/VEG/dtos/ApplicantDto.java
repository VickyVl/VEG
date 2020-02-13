package gr.codehub.RecruMe.VEG.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Entity ApplicantDto aggregates the data of the object to be transferred and served by the Post call,
 * when a new applicant is registered in the system.
 * Fundamental methods/tools imported from Lombok Library.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantDto {
    private String firstName;
    private String lastName;
    private String address;
    private String Region;
    private String educationLevel;
    private String level;

    private List<String> applicantSkillsDescriptions;
}
