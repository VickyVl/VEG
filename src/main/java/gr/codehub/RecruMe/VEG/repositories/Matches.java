package gr.codehub.RecruMe.VEG.repositories;

import gr.codehub.RecruMe.VEG.models.Applicant;
import gr.codehub.RecruMe.VEG.models.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Matches extends JpaRepository<Match, Integer> {

//    @Query(value = "SELECT applicant_skill.applicant_skill_id, job_skill.job_skill_id " +
//            "FROM applicant_skill INNER JOIN job_skill ON applicant_skill.id = job_skill.id", nativeQuery = true)
//    List<Match[]> getMatch();

}
