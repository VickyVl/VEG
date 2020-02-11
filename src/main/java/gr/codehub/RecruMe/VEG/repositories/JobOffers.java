package gr.codehub.RecruMe.VEG.repositories;

import gr.codehub.RecruMe.VEG.models.Applicant;
import gr.codehub.RecruMe.VEG.models.ApplicantSkill;
import gr.codehub.RecruMe.VEG.models.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobOffers extends JpaRepository<JobOffer, Integer> {
}
