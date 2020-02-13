package gr.codehub.RecruMe.VEG.repositories;

import gr.codehub.RecruMe.VEG.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Skills Interface extends JpaRepository, is typed to the domain class and the ID type/primary key,
 * exposing a complete set of methods to manipulate the corresponding entity, i.e. skill.
 */

@Repository
public interface Skills extends JpaRepository<Skill, Integer> {
    Skill findFirstByDescription(String skillName);  //already given by Spring

    Skill findByDescription(String skillName);
}
