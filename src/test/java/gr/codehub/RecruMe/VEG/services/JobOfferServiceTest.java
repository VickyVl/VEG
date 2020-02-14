package gr.codehub.RecruMe.VEG.services;

import gr.codehub.RecruMe.VEG.services.jobOfferManagementService.JobOfferService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class JobOfferServiceTest {
    @Autowired
    private JobOfferService jobOfferService;

    @Test
    void getAll() {
        assertEquals(6, jobOfferService.getAll().size(),"Error happened");
    }
}