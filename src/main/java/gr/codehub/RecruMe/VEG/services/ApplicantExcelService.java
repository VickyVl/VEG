package gr.codehub.RecruMe.VEG.services;

import gr.codehub.RecruMe.VEG.EnumTypes.LevelType;
import gr.codehub.RecruMe.VEG.models.Applicant;
import gr.codehub.RecruMe.VEG.models.ApplicantSkill;
import gr.codehub.RecruMe.VEG.models.Skill;
import gr.codehub.RecruMe.VEG.repositories.ApplicantSkills;
import gr.codehub.RecruMe.VEG.repositories.Applicants;
import gr.codehub.RecruMe.VEG.repositories.Skills;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ApplicantExcelService registers all applicants from the file into the database.
 */

@Service
public class ApplicantExcelService {
    @Autowired
    private Applicants applicantRepo;

    @Autowired
    private Skills skillRepo;

    @Autowired
    private ApplicantSkills applicantSkillRepo;

    /**
     * Show all applicants from excel
     * @return applicant
     * @throws IOException
     */

    public List<Applicant> getApplicantExcel() throws IOException {
        ApplicantExcel("dataforrecrume.xlsx");
        return applicantRepo.findAll();
    }

    /**
     * Read all applicants from excel file
     * @param excelFileName
     * @throws IOException
     */

    public void ApplicantExcel(String excelFileName) throws IOException {

        File file = ResourceUtils.getFile("classpath:"+excelFileName);
        FileInputStream excelFile = new FileInputStream(file);
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
            Cell levelCell = cellIterator.next();


            List<Skill> applicantSkills = new ArrayList<>();

            String description = "";
            while(cellIterator.hasNext()) {
                Cell descr =  cellIterator.next();
                String value = descr.getStringCellValue();
//                if (!value.trim().isEmpty()){
//                        if (!description.isEmpty()){
//                            description += ", ";
//                        }
//                    description += value;
                Skill foundSkill = skillRepo.findFirstByDescription(value);
                applicantSkills.add(foundSkill);
            }
            
            LevelType levelType = null;

            if (levelCell.getStringCellValue().equalsIgnoreCase("Junior")){
                levelType = LevelType.JUNIOR;
            }
            if (levelCell.getStringCellValue().equalsIgnoreCase("Mid")){
                levelType = LevelType.MID;
            }
            if (levelCell.getStringCellValue().equalsIgnoreCase("Senior")){
                levelType = LevelType.SENIOR;
            }
            

            Applicant applicant = new Applicant(
                    firstNameCell.getStringCellValue(),
                    lastNameCell.getStringCellValue(),
                    addressCell.getStringCellValue(),
                    regionCell.getStringCellValue(),
                    educationLevelCell.getStringCellValue(),
                    levelCell.getStringCellValue());

            applicant.setLevelType(levelType);
            applicant = applicantRepo.save(applicant);


            for (int i=0; i<applicantSkills.size(); i++){
                ApplicantSkill applicantSkill = new ApplicantSkill();
                applicantSkill.setApplicant(applicant);
                applicantSkill.setSkill(applicantSkills.get(i));
                applicantSkillRepo.save(applicantSkill);
            }
            applicant.setActive(true);
            applicantRepo.save(applicant);
        }
    }
}
