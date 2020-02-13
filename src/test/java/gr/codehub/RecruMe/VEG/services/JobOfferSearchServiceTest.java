package gr.codehub.RecruMe.VEG.services;

import gr.codehub.RecruMe.VEG.exceptions.JobOfferNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class JobOfferSearchServiceTest {
    @Autowired
    private JobOfferSearchService jobOfferSearchService;

    @Test
    void getJobOfferTest() throws JobOfferNotFoundException {
        try {
            assertEquals(1, jobOfferSearchService.getJobOffer(1).getId(), "Error happened");
        } catch (Exception e) {
            throw new JobOfferNotFoundException("Job Offer NOT FOUND");
        }
    }

    @Test
    void readByPositionTest() throws JobOfferNotFoundException {
        try {
            assertEquals(1, jobOfferSearchService.readByPosition("Developer").size(), "Error happened");
        } catch (Exception e) {
            throw new JobOfferNotFoundException("Job Offer NOT FOUND");
        }
    }

    @Test
    void readByRegionTest() throws JobOfferNotFoundException {
        try {
            assertEquals(0, jobOfferSearchService.readByRegion("Skg").size(), "Error happened");
        } catch (Exception e) {
            throw new JobOfferNotFoundException("Job Offer NOT FOUND");
        }
    }
    @Test
    void readByCompanyTest()  throws JobOfferNotFoundException {
        try {
            assertEquals(1, jobOfferSearchService.readByCompany("CodeHub").size(), "Error happened");
        } catch (Exception e) {
            throw new JobOfferNotFoundException("Job Offer NOT FOUND");
        }
    }
    @Test
    void searchJobOffersBySkillTest() throws JobOfferNotFoundException {
        try {
            assertEquals(1, jobOfferSearchService.searchJobOffersBySkill("C").size(), "Error happened");
        } catch (Exception e) {
            throw new JobOfferNotFoundException("Job Offer NOT FOUND");
        }
    }
}