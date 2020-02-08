package gr.codehub.RecruMe.VEG.repositories;

import gr.codehub.RecruMe.VEG.models.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface Applicants extends JpaRepository<Applicant, Integer> {
}
