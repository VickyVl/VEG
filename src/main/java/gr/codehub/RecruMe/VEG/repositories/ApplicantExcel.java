package gr.codehub.RecruMe.VEG.repositories;

import gr.codehub.RecruMe.VEG.models.Applicant;
import gr.codehub.RecruMe.VEG.models.ApplicantSkill;
import lombok.Data;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Data
public class ApplicantExcel {

    private List<Applicant> applicants;
    @Autowired
    private Applicants applicantRepo;

    public ApplicantExcel() {
        applicants = new ArrayList<>();
    }

    public ApplicantExcel(String excelFileName) throws IOException {
        this();

        applicants = new ArrayList<>();
        File file = ResourceUtils.getFile("classpath:"+excelFileName);
        FileInputStream excelFile = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet datatypeSheet = workbook.getSheetAt(1);
        Iterator<Row> row = datatypeSheet.iterator();

        row.next();
        while (row.hasNext()) {
            Row currentRow = row.next();
            Iterator<Cell> cellIterator = currentRow.iterator();

            String description = "";
            Cell descr =  cellIterator.next();
            String value = descr.getStringCellValue();

            /*if (!value.trim().isEmpty()){
                if (!applicants.isEmpty()){
                    description += ", ";
                }
                description += value;
            }*/

            Cell firstNameCell = cellIterator.next();
            Cell lastNameCell = cellIterator.next();
            Cell addressCell = cellIterator.next();
            Cell regionCell = cellIterator.next();
            Cell educationLevelCell = cellIterator.next();
            //Cell skillCell = cellIterator.next();
            Applicant applicant = new Applicant(
                    firstNameCell.getStringCellValue(),
                    lastNameCell.getStringCellValue(),
                    addressCell.getStringCellValue(),
                    regionCell.getStringCellValue(),
                    educationLevelCell.getStringCellValue());
            //skillCell.getStringCellValue());
                  //  applicantSkill.setDescription(skillCell.getStringCellValue());
            applicants.add(applicant);
            applicantRepo.save(applicant);
        }
    }
}