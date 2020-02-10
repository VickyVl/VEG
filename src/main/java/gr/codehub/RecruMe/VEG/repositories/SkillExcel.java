package gr.codehub.RecruMe.VEG.repositories;

import gr.codehub.RecruMe.VEG.models.Skill;
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
public class SkillExcel {


    private List<Skill> skills;
    @Autowired
    private Skills skillRepo;

    public SkillExcel() {
        skills = new ArrayList<>();
    }

    public SkillExcel(String excelFileName) throws IOException {
        this();
        FileInputStream excelFile = new FileInputStream(new File(excelFileName));
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet datatypeSheet = workbook.getSheetAt(0);
        Iterator<Row> row = datatypeSheet.iterator();

        row.next();
        while (row.hasNext()) {
            Row currentRow = row.next();
            Iterator<Cell> cellIterator = currentRow.iterator();

            Cell descriptionCell = cellIterator.next();

            Skill skill = new Skill(descriptionCell.getStringCellValue());

            skills.add(skill);
            skillRepo.save(skill);
        }
    }

    public Skill getSkillByCode(int code) {
        return skills
                .stream()
                .filter(skill -> skill.getId() == code)
                .findFirst()
                .get();
    }
}
