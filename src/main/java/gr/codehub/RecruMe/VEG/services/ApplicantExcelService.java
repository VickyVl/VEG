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
import java.util.Optional;

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
     *
     * @return applicant
     * @throws IOException
     */

    public List<Applicant> getApplicantExcel() throws IOException {
        ApplicantExcel("dataforrecrume.xlsx");
        return applicantRepo.findAll();
    }

    /**
     * Read all applicants from excel file
     *
     * @param excelFileName
     * @throws IOException
     */

    public void ApplicantExcel(String excelFileName) throws IOException {

        File file = ResourceUtils.getFile("classpath:" + excelFileName);
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
            while (cellIterator.hasNext()) {
                Cell descr = cellIterator.next();
                String value = descr.getStringCellValue();
                description = value;
                Optional<Skill> foundSkill = skillRepo.findByDescription(value);
                if (!foundSkill.isPresent()){
                    Skill newSkill = new Skill();
                    newSkill.setDescription(value);
                    skillRepo.save(newSkill);
                    applicantSkills.add(newSkill);
                }
                else {

                    applicantSkills.add(foundSkill.get());
                }
            }
            Applicant applicant = setApplicantFromExcel(firstNameCell.getStringCellValue(), lastNameCell.getStringCellValue(), addressCell.getStringCellValue(), regionCell.getStringCellValue(), educationLevelCell.getStringCellValue(), levelCell.getStringCellValue(), applicantSkills);

        }
    }

    /**
     * sets applicant's level type (JUNIOR, MID, SENIOR)
     *
     * @param description of the level
     * @return a LevelType
     */
    public LevelType findLevelType(String description) {
        LevelType levelType = null;

        if (description.equalsIgnoreCase("Junior")) {
            levelType = LevelType.JUNIOR;
        }
        if (description.equalsIgnoreCase("Mid")) {
            levelType = LevelType.MID;
        }
        if (description.equalsIgnoreCase("Senior")) {
            levelType = LevelType.SENIOR;
        }
        return levelType;
    }

    /**
     * sets an applicant that reads from an excel file
     *
     * @param firstName
     * @param lastName
     * @param address
     * @param region
     * @param educationLevel
     * @param level
     * @param applicantSkills
     * @return
     */

    public Applicant setApplicantFromExcel(String firstName, String lastName, String address, String region, String educationLevel, String level, List<Skill> applicantSkills) {
        Applicant applicant = new Applicant(
                firstName,
                lastName,
                address,
                region,
                educationLevel,
                level);

        LevelType levelType = findLevelType(level);

        applicant.setLevelType(levelType);
        applicant = applicantRepo.save(applicant);

        for (int i = 0; i < applicantSkills.size(); i++) {
            ApplicantSkill applicantSkill = new ApplicantSkill();
            applicantSkill.setApplicant(applicant);
            applicantSkill.setSkill(applicantSkills.get(i));
            applicantSkillRepo.save(applicantSkill);
        }
        applicant.setActive(true);
        return applicantRepo.save(applicant);
    }
}
