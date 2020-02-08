package gr.codehub.RecruMe.VEG.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private String address;
    private String Region;
    private String educationLevel;

    @Column(columnDefinition = "bit default 1")
    private boolean active;

/*    @OneToMany(mappedBy = "applicant", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ApplicantSkill> applicantSkills;*/

}
