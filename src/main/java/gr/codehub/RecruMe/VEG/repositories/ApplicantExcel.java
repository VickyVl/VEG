package gr.codehub.RecruMe.VEG.repositories;

import gr.codehub.RecruMe.VEG.models.Applicant;
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
public class ApplicantExcel {

    private List<Applicant> applicants;

    public ApplicantExcel() {
        applicants = new ArrayList<>();
    }

    public ApplicantExcel(String excelFileName) throws IOException {
        this();
        FileInputStream excelFile = new FileInputStream(new File(excelFileName));
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet datatypeSheet = workbook.getSheetAt(0);
        Iterator<Row> row = datatypeSheet.iterator();

        row.next();
        while (row.hasNext()) {
            Row currentRow = row.next();
            Iterator<Cell> cellIterator = currentRow.iterator();

            Cell firstNameCell = cellIterator.next();
            Cell lastNameCell = cellIterator.next();
            Cell addressCell = cellIterator.next();
            Cell regionCell = cellIterator.next();
            Cell educationLevelCell = cellIterator.next();
            Applicant applicant = new Applicant(
                    firstNameCell.getStringCellValue(),
                    lastNameCell.getStringCellValue(),
                    addressCell.getStringCellValue(),
                    regionCell.getStringCellValue(),
                    educationLevelCell.getStringCellValue());
            applicants.add(applicant);
        }
    }

    public Applicant getApplicantByCode(int code) {
        return applicants
                .stream()
                .filter(applicant -> applicant.getId() == code)
                .findFirst()
                .get();
    }
}