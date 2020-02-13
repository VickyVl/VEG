package gr.codehub.RecruMe.VEG.services;

import gr.codehub.RecruMe.VEG.exceptions.ApplicantNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplicantSearchServiceTest {
    @Autowired
    private ApplicantSearchService applicantSearchService;

    @Test
    public void getApplicantTest() throws ApplicantNotFoundException {
        try {
            assertEquals(1, applicantSearchService.getApplicant(1).getId(), "Error happened");

        } catch (Exception e) {
            throw new ApplicantNotFoundException("APPLICANT NOT FOUND");
        }
    }

    @Test
    public void searchByNameTest() throws ApplicantNotFoundException{
        try {
            assertEquals(1, applicantSearchService.searchByName("Dimitris").size(), "Error happened");

        } catch (Exception e) {
            throw new ApplicantNotFoundException("APPLICANT NOT FOUND");
        }
    }

    @Test
    public void searchByRegionTest()throws ApplicantNotFoundException{
        try {
            assertEquals(0, applicantSearchService.searchByRegion("Skg").size(), "Error happened");

        } catch (Exception e) {
            throw new ApplicantNotFoundException("APPLICANT NOT FOUND");
        }
    }

    @Test
    public void searchBySkillTest()throws ApplicantNotFoundException{
        try {
            assertEquals(1, applicantSearchService.searchBySkill("Graphics").size(), "Error happened");

        } catch (Exception e) {
            throw new ApplicantNotFoundException("APPLICANT NOT FOUND");
        }
    }

    @Test
    public void searchByLevelTest()throws ApplicantNotFoundException{
        try {
            assertEquals(4, applicantSearchService.searchByLevel("Junior").size(), "Error happened");

        } catch (Exception e) {
            throw new ApplicantNotFoundException("APPLICANT NOT FOUND");
        }
    }



}