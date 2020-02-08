package gr.codehub.RecruMe.VEG.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

/*    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicant_skill_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private ApplicantSkill applicantSkill;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_skill_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private JobSkill jobSkill;*/
}
