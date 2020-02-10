package gr.codehub.RecruMe.VEG.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;

    @OneToMany(mappedBy="skill")
    @JsonIgnore
    private List<ApplicantSkill> applicantSkills;

    @OneToMany(mappedBy="skill")
    @JsonIgnore
    private List<JobSkill> jobSkills;

    public Skill(String description) {
        this.description = description;
    }
}
