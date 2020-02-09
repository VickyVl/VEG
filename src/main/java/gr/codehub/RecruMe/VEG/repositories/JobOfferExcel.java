package gr.codehub.RecruMe.VEG.repositories;

import gr.codehub.RecruMe.VEG.models.JobOffer;
import lombok.Data;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Data
public class JobOfferExcel {


    private List<JobOffer> jobOffers;

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

            Cell titleOfPositionCell = cellIterator.next();
            Cell regionCell = cellIterator.next();
            Cell educationLevelCell = cellIterator.next();

            JobOffer jobOffer = new JobOffer(
                    titleOfPositionCell.getStringCellValue(),
                    regionCell.getStringCellValue(),
                    educationLevelCell.getStringCellValue());

            jobOffers.add(jobOffer);
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