package gr.codehub.RecruMe.VEG.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Entity Job Skill defining the skills requested by the job retrieved from the existing database and associating
 * the job skill via JPA with a relational database table containing the corresponding fields.
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

public class JobSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * JPA ManyToOne relationship attributing many requested job skills to one job offer.
     * JsonIgnore used to ignore the logical property used in serialization and deserialization.
     */

    @ManyToOne
    @JsonIgnore
    private JobOffer jobOffer;

    /**
     * JPA ManyToOne relationship connecting each one of the job skills to the corresponding skill.
     * JsonIgnore used to ignore the logical property used in serialization and deserialization.
     */

    @ManyToOne
    @JsonIgnore
    private Skill skill;

}
