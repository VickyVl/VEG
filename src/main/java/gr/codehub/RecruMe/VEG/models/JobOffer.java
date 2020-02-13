package gr.codehub.RecruMe.VEG.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Entity Job offer defining each job offer retrieved from the existing database and associating
 * the job offer via JPA with a relational database table containing the corresponding fields.
 * Fundamental methods/tools imported from Lombok Library.
 * JPA annotations used to define the object's attributes and the relationship between the target object's table and
 * the source object's table.
 */

@Data
@NoArgsConstructor
@Entity

/**
 * JPA @Id annotation defines the object's id, corresponding to the primary key of the object's table.
 * @GeneratedValue annotation used to assign a generated sequence number by the system.
 */

public class JobOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String company;
    private String titleOfPosition;
    private String region;
    private String educationLevel;

    /**
     * Column in JobOffer table defining the status of the job offer and the corresponding value
     * in the database. Default 1 = active/unmatched job offer, i.e. available to be matched with potential applicant.
     */

    @Column(columnDefinition = "bit default 1")
    private boolean active;

    /**
     * JPA OneToMany relationship attributing to one job offer many requested job offer skills.
     * MappedBy designating the job offer as the owner of the relationship.
     * JsonIgnore used to ignore the logical property used in serialization and deserialization.
     */

    @OneToMany(mappedBy = "jobOffer")
    @JsonIgnore
    private List<JobSkill> jobSkills;

    /**
     * Constructor of job offer with fields:
     *
     * @param company
     * @param titleOfPosition
     * @param region
     * @param educationLevel
     */

    public JobOffer(String company, String titleOfPosition, String region, String educationLevel) {
        this.company = company;
        this.titleOfPosition = titleOfPosition;
        this.region = region;
        this.educationLevel = educationLevel;
    }
}
