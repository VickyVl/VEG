package gr.codehub.RecruMe.VEG.repositories;

import gr.codehub.RecruMe.VEG.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Skills extends JpaRepository<Skill, Integer> {
    Skill findFirstByDescription(String skillName); //already qyery by spring

    Skill findByDescription(String skillName);
}
