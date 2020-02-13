package gr.codehub.RecruMe.VEG.services;

import gr.codehub.RecruMe.VEG.models.Skill;
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
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * SkillExcelService registers all skills from the file into the database.
 */

@Service
public class SkillExcelService {
    private Skills skillRepo;

    @Autowired
    public SkillExcelService(Skills skillRepo) {
        this.skillRepo = skillRepo;
    }

    /**
     * Show all skills from excel
     * @return skills
     * @throws IOException
     */

    public List<Skill> getSkillExcel() throws IOException {
        SkillExcel("dataforrecrume.xlsx");
        return skillRepo.findAll();
    }

    public void SkillExcel(String excelFileName) throws IOException {

        File file = ResourceUtils.getFile("classpath:"+excelFileName);
        FileInputStream excelFile = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet datatypeSheet = workbook.getSheetAt(2);
        Iterator<Row> row = datatypeSheet.iterator();

        row.next();

        while (row.hasNext()) {
            Row currentRow = row.next();
            Iterator<Cell> cellIterator = currentRow.iterator();
            Cell description =  cellIterator.next();
            Skill skill = new Skill(description.getStringCellValue());
            Optional<Skill> foundSkill = skillRepo.findByDescription(skill.getDescription());
            if (!foundSkill.isPresent()){
                skillRepo.save(skill);
            }

        }
    }
}
