package gr.codehub.RecruMe.VEG.repositories;

import gr.codehub.RecruMe.VEG.models.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JobOffers Interface extends JpaRepository, is typed to the domain class and the ID type/primary key,
 * exposing a complete set of methods to manipulate the corresponding entity, i.e. the job offer.
 */

@Repository
public interface JobOffers extends JpaRepository<JobOffer, Integer> {
}
