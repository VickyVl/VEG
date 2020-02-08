package gr.codehub.RecruMe.VEG.models;//package gr.codehub.RecruMe.VEG.models;
//
//import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import gr.codehub.RecruMe.VEG.models.Skill;
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
    @Column(columnDefinition = "bit default 1")
    private String titleOfPosition;
    private String region;
    private String educationLevel;



/*    @OneToMany(mappedBy = "job_offer", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    @ManyToMany
    private List<JobSkill> jobSkills;*/
}
