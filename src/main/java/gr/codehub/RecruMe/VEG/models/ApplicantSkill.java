package gr.codehub.RecruMe.VEG.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Entity ApplicantSkill defining each Applicant's skills retrieved from the existing database and associating
 * the ApplicantSkill via JPA with a relational database table containing the corresponding fields.
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

public class ApplicantSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * JPA ManyToOne relationship attributing many applicant skills to one applicant.
     * JsonIgnore used to ignore the logical property used in serialization and deserialization.
     */

    @ManyToOne
    @JsonIgnore
    private Applicant applicant;

    /**
     * JPA ManyToOne relationship connecting each one of the applicant skills to the corresponding skill.
     * JsonIgnore used to ignore the logical property used in serialization and deserialization.
     */

    @ManyToOne
    @JsonIgnore
    private Skill skill;
}
