package gr.codehub.RecruMe.VEG.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gr.codehub.RecruMe.VEG.EnumTypes.MatchType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Entity Match displaying via JPA the type of the match between the Applicant and the Job Offer.
 * Fundamental methods/tools imported from Lombok Library.
 * JPA annotations used to define the object's attributes and the relationship between the target object's tables and
 * the source object's table.
 */

@Data
@NoArgsConstructor
@Entity
public class Match {

    /**
     * JPA @Id annotation defines the object's id, corresponding to the primary key of the object's table.
     * @GeneratedValue annotation used to assign a generated sequence number by the system.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private MatchType type;

    /**
     * JPA OneToOne relationship attributing one match type to one applicant.
     * JsonIgnore used to ignore the logical property used in serialization and deserialization.
     */

    @OneToOne
    @JsonIgnore
    private Applicant applicant;

    /**
     * JPA OneToOne relationship attributing one match type to one job offer.
     * JsonIgnore used to ignore the logical property used in serialization and deserialization.
     */

    @OneToOne
    @JsonIgnore
    private JobOffer jobOffer;

}