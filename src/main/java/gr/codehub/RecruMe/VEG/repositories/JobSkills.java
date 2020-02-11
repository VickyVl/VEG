package gr.codehub.RecruMe.VEG.repositories;

import gr.codehub.RecruMe.VEG.models.ApplicantSkill;
import gr.codehub.RecruMe.VEG.models.JobOffer;
import gr.codehub.RecruMe.VEG.models.JobSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSkills extends JpaRepository<JobSkill,Integer> {
    List<JobSkill> findBySkillId(int id);
    List<JobSkill> findByJobOfferId(int id);
}
