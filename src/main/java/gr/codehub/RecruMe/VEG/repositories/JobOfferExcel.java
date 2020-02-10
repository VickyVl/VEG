package gr.codehub.RecruMe.VEG.repositories;

import gr.codehub.RecruMe.VEG.models.JobOffer;
import lombok.Data;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Data
public class JobOfferExcel {


    private List<JobOffer> jobOffers;
    @Autowired
    private JobOffers jobOfferRepo;

    public JobOfferExcel() {
        jobOffers = new ArrayList<>();
    }

    public JobOfferExcel(String excelFileName) throws IOException {
        this();
        FileInputStream excelFile = new FileInputStream(new File(excelFileName));
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet datatypeSheet = workbook.getSheetAt(0);
        Iterator<Row> row = datatypeSheet.iterator();

        row.next(); //reads the headers
        while (row.hasNext()) {
            Row currentRow = row.next();
            Iterator<Cell> cellIterator = currentRow.iterator();

            Cell companyCell = cellIterator.next();
            Cell titleOfPositionCell = cellIterator.next();
            Cell regionCell = cellIterator.next();
            Cell educationLevelCell = cellIterator.next();

            JobOffer jobOffer = new JobOffer(
                    companyCell.getStringCellValue(),
                    titleOfPositionCell.getStringCellValue(),
                    regionCell.getStringCellValue(),
                    educationLevelCell.getStringCellValue());

            jobOffers.add(jobOffer);
            jobOfferRepo.save(jobOffer);

        }
    }

    public JobOffer getJobOfferByCode(int code) {
        return jobOffers
                .stream()
                .filter(jobOffer -> jobOffer.getId() == code)
                .findFirst()
                .get();
    }
}
