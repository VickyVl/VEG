package gr.codehub.RecruMe.VEG.models;

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

    private String titleOfPosition;
    private String region;
    private String educationLevel;

    @ManyToMany
    private List<Skill> skills;
}
