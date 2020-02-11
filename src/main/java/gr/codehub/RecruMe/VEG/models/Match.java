package gr.codehub.RecruMe.VEG.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private MatchType type;

    @OneToOne
    @JsonIgnore
    private Applicant applicant;

    @OneToOne
    @JsonIgnore
    private JobOffer jobOffer;

}