package gr.codehub.RecruMe.VEG.repositories;

import gr.codehub.RecruMe.VEG.models.ApplicantSkill;
import gr.codehub.RecruMe.VEG.models.JobOffer;
import gr.codehub.RecruMe.VEG.models.JobSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * JobSkills Interface extends JpaRepository, is typed to the domain class and the ID type/primary key,
 * exposing a complete set of methods to manipulate the corresponding entity, i.e. the list of job skills.
 * Provides reporting services by retrieving data of the most requested skills by job offers.
 */

@Repository
public interface JobSkills extends JpaRepository<JobSkill,Integer> {
    List<JobSkill> findBySkillId(int id);
    List<JobSkill> findByJobOfferId(int id);

    @Query(value = "SELECT TOP 5 skill.description, COUNT (skill.description) FROM skill \n" +
            "INNER JOIN job_skill\n" +
            "ON skill.id = job_skill.skill_id\n" +
            "GROUP BY skill.description\n" +
            "ORDER BY COUNT (skill.description) DESC;", nativeQuery = true)
    List<Object[]> getTop5MostRequestedSkills();
}
