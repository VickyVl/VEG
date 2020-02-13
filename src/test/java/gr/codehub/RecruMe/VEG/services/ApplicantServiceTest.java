package gr.codehub.RecruMe.VEG.services;

import gr.codehub.RecruMe.VEG.exceptions.ApplicantNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ApplicantServiceTest {
    @Autowired
    private ApplicantService applicantService;

    @Test
    public void getAllTest() {
            assertEquals(10, applicantService.getAll().size(), "Error happened");

    }

}