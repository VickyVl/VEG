package gr.codehub.RecruMe.VEG.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Entity JobOfferDto aggregates the data of the object to be transferred and served by the Post call,
 * when a new job offer is registered in the system.
 * Fundamental methods/tools imported from Lombok Library.
 */

@Data
@NoArgsConstructor
public class JobOfferDto {
    private String company;
    private String titleOfPosition;
    private String region;
    private String educationLevel;

    private List<String> jobOfferSkillsDescriptions;
}
