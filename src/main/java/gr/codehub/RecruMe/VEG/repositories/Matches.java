package gr.codehub.RecruMe.VEG.repositories;

import gr.codehub.RecruMe.VEG.models.JobSkill;
import gr.codehub.RecruMe.VEG.models.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Match Interface extends JpaRepository, is typed to the domain class and the ID type/primary key,
 * exposing a complete set of methods to manipulate the corresponding entity.
 * Provides reporting services by retrieving data of the proposed matches of applicants - job offers.
 */

@Repository
public interface Matches extends JpaRepository<Match, Integer> {

    @Query(value = "SELECT * FROM MATCH\n" +
            "WHERE type = '0' OR type = '1' ;", nativeQuery = true)
    List<Object[]> getListOfProposedMatches();

    @Query(value = "SELECT * FROM MATCH WHERE type = '2' ;", nativeQuery = true)
    List<Match> getListOfFinalizedMatches();

}
