package gr.codehub.RecruMe.VEG.models;//package gr.codehub.RecruMe.VEG.models;
//
//import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class JobOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String company;
    private String titleOfPosition;
    private String region;
    private String educationLevel;

    @Column(columnDefinition = "bit default 1")
    private boolean active;

    @OneToMany(mappedBy = "jobOffer" )
    @JsonIgnore
    private List<JobSkill> jobSkills;

    public JobOffer(String company, String titleOfPosition, String region, String educationLevel) {
        this.company = company;
        this.titleOfPosition = titleOfPosition;
        this.region = region;
        this.educationLevel = educationLevel;
    }
}
