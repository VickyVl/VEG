package gr.codehub.RecruMe.VEG.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gr.codehub.RecruMe.VEG.enumType.LevelType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Entity Applicant defining each Applicant retrieved from the existing database and associating the Applicant via JPA
 * with a relational database table containing the corresponding fields. Fundamental methods/tools imported
 * from Lombok Library.
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

public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private String address;
    private String region;
    private String educationLevel;
    private String level;
    private LevelType levelType;

    /**
     * Column in Applicant's table defining the availability of the applicant and the corresponding value
     * in the database. Default 1 = active Applicant, i.e. available to be matched with potential job offer.
     */

    @Column(columnDefinition = "bit default 1")
    private boolean active;

    /**
     * JPA OneToMany relationship attributing to one applicant many applicant's skills.
     * MappedBy designating the applicant as the owner of the relationship.
     * JsonIgnore used to ignore the logical property used in serialization and deserialization.
     */

    @OneToMany(mappedBy = "applicant")
    @JsonIgnore
    private List<ApplicantSkill> applicantSkills;

    /**
     * Constructor of Applicant with fields:
     *
     * @param firstName
     * @param lastName
     * @param address
     * @param region
     * @param educationLevel
     * @param level
     */

    public Applicant(String firstName, String lastName, String address, String region, String educationLevel, String level) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.region = region;
        this.educationLevel = educationLevel;
        this.level = level;
    }
}
