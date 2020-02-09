package gr.codehub.RecruMe.VEG.services;

import gr.codehub.RecruMe.VEG.models.Applicant;
import gr.codehub.RecruMe.VEG.models.JobOffer;
import gr.codehub.RecruMe.VEG.models.Skill;
import gr.codehub.RecruMe.VEG.repositories.ApplicantExcel;
import gr.codehub.RecruMe.VEG.repositories.JobOfferExcel;
import gr.codehub.RecruMe.VEG.repositories.SkillExcel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Qualifier("mkyong")
@Service
public class ExcelService {

    public ApplicantExcel getApplicant() {
        try {
            return new ApplicantExcel("applicant.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Applicant getApplicantByCode(int code) throws IOException {
        ApplicantExcel applicants = new ApplicantExcel("applicant.xlsx");

        return applicants.getApplicantByCode(code);
    }

    public JobOfferExcel getJobOffer() {
        try {
            return new JobOfferExcel("joboffer.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JobOffer getJobOfferByCode(int code) throws IOException {
        JobOfferExcel jobOffers = new JobOfferExcel("joboffer.xlsx");

        return jobOffers.getJobOfferByCode(code);
    }

    public SkillExcel getSkill() {
        try {
            return new SkillExcel("skill.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Skill getSkillByCode(int code) throws IOException {
        SkillExcel skills = new SkillExcel("skill.xlsx");

        return skills.getSkillByCode(code);
    }
}
