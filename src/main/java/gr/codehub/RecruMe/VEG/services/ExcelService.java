package gr.codehub.RecruMe.VEG.services;

import gr.codehub.RecruMe.VEG.repositories.ApplicantExcel;
import gr.codehub.RecruMe.VEG.repositories.JobOfferExcel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Qualifier("mkyong")
@Service
public class ExcelService {

    public ApplicantExcel getApplicant() {
        String excelFileName = "resources/dataforrecrume.xlsx";
        try {
            return new ApplicantExcel(excelFileName);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JobOfferExcel getJobOffer() {
        String excelFileName = "resources/dataforrecrume.xlsx";
        try {
            return new JobOfferExcel(excelFileName);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

//    public SkillExcel getSkill() {
//        String excelFileName = "resources/dataforrecrume.xlsx";
//        try {
//            return new SkillExcel(excelFileName);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}
