package gr.codehub.RecruMe.VEG.services;

import gr.codehub.RecruMe.VEG.dtos.SkillDto;
import gr.codehub.RecruMe.VEG.exceptions.SkillNotFoundException;
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
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SkillService {
    @Autowired
    private Skills skillRepo;

    public Skill save(SkillDto skillDto) {
        Skill skill = new Skill();
        skill.setDescription(skillDto.getDescription());

        return skillRepo.save(skill);
    }

    public List<Skill> getAll() {
        return
                StreamSupport
                        .stream(skillRepo.findAll().spliterator(), false)
                        .collect(Collectors.toList());
    }

    public Skill getSkill(int id) throws SkillNotFoundException {
        try {
            Skill skill = skillRepo.findById(id).get();
            return skill;
        } catch (Exception e) {
            throw new SkillNotFoundException("Skill id = " + id + " NOT FOUND");
        }
    }

    public List<Skill> readByDescription(String description) throws SkillNotFoundException {
        try {
            return
                    StreamSupport
                            .stream(skillRepo.findAll().spliterator(), false)
                            .filter(jobOffer -> jobOffer.getDescription().equalsIgnoreCase(description))
                            .collect(Collectors.toList());
        } catch (Exception e) {
            throw new SkillNotFoundException("Description = " + description + " NOT FOUND");
        }
    }

    public Skill updateOne(int id, SkillDto skillDto) throws SkillNotFoundException {
        Skill skill = skillRepo.findById(id).get();
        if (skill == null) {
            throw new SkillNotFoundException("Description id = " + id);
        }
        skill.setDescription(skillDto.getDescription());

        return skillRepo.save(skill);
    }

    public List<Skill> getSkillExcel() throws IOException {
         SkillExcel("dataforrecrume.xlsx");
        return skillRepo.findAll();
    }


    public void SkillExcel(String excelFileName ) throws IOException {

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
            skillRepo.save(skill);

        }
    }



}
