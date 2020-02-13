package gr.codehub.RecruMe.VEG.repositories;

import gr.codehub.RecruMe.VEG.models.ApplicantSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * ApplicantSkills Interface extends JpaRepository, is typed to the domain class and the ID type/primary key,
 * exposing a complete set of methods to manipulate the corresponding entity, i.e. the list of applicant's skills.
 * Provides reporting services by retrieving data of the most offered skills by applicants.
 */

import java.util.List;

@Repository
public interface ApplicantSkills extends JpaRepository<ApplicantSkill, Integer> {
    List<ApplicantSkill> findBySkillId(int id);

    @Query(value = "SELECT TOP 5 skill.description, COUNT (skill.description) FROM skill \n" +
            "INNER JOIN applicant_skill\n" +
            "ON skill.id = applicant_skill.skill_id\n" +
            "GROUP BY skill.description\n" +
            "ORDER BY COUNT (skill.description) DESC;", nativeQuery = true)
    List<Object[]> getTop5MostOfferedSkills();
}

