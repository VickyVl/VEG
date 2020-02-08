package gr.codehub.RecruMe.VEG.repositories;

import gr.codehub.RecruMe.VEG.models.JobOffer;
import gr.codehub.RecruMe.VEG.models.JobSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSkills extends JpaRepository<JobSkill,Integer> {
}
