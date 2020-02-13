package gr.codehub.RecruMe.VEG.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Entity Skill defining each skill retrieved from the existing database and associating the skill via JPA
 * with a relational database table containing the corresponding fields.
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

public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;

    /**
     * JPA OneToMany relationship connecting one skill to the corresponding skill offered by many applicants.
     * MappedBy designating the skill as the owner of the relationship.
     * JsonIgnore used to ignore the logical property used in serialization and deserialization.
     */

    @OneToMany(mappedBy = "skill")
    @JsonIgnore
    private List<ApplicantSkill> applicantSkills;

    /**
     * JPA OneToMany relationship connecting one skill to the corresponding skill requested by many job offers.
     * JsonIgnore used to ignore the logical property used in serialization and deserialization.
     */

    @OneToMany(mappedBy = "skill")
    @JsonIgnore
    private List<JobSkill> jobSkills;

    /**
     * Constructor for Skill with one field:
     *
     * @param description
     */

    public Skill(String description) {
        this.description = description;
    }

    /**
     * Checks if a skill id equals to another
     *
     * @param o
     * @return skill.id
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return id == skill.id;
    }

    /**
     * Java Object hashCode() is a native method returning the integer hash code value of the object.
     * Checks if two objects are equal according to equals() method. If so, their hash code must be the same.
     * @return a unique id number allocated to the objects.
     */

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
