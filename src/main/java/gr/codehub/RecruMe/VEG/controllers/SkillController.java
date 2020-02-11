package gr.codehub.RecruMe.VEG.controllers;

import gr.codehub.RecruMe.VEG.dtos.SkillDto;
import gr.codehub.RecruMe.VEG.exceptions.ApplicantNotFoundException;
import gr.codehub.RecruMe.VEG.exceptions.SkillNotFoundException;
import gr.codehub.RecruMe.VEG.models.Skill;
import gr.codehub.RecruMe.VEG.services.SkillExcelService;
import gr.codehub.RecruMe.VEG.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


/**
 * SkillController used here:
 * - to provide the data of all skills
 * - to create a new skill
 * - to search skill by id and description
 * - to update the description of a skill
 * displaying the above via the corresponding HTTP responses as json files on the web.
 */

@RestController
@RequestMapping("/recrumeVEG/")
public class SkillController {
    @Autowired
    private SkillService skillService;
    @Autowired
    private SkillExcelService skillExcelService;

    /**
     * endpoint http://localhost:8080/recrumeVEG/applicant
     * create a new skill
     * @param skillDto
     * @return new skill
     */

    @PostMapping("skill")
    public Skill newSkill(@RequestBody SkillDto skillDto) {
        return skillService.save(skillDto);
    }

    /**
     * endpoint http://localhost:8080/recrumeVEG/applicants
     * @return all skills
     */

    @GetMapping("skills")
    public List<Skill> readAll( ) {
        return skillService.getAll();
    }

    /**
     * endpoint http://localhost:8080/recrumeVEG/skill/{id}
     * @param id
     * @return skill by id
     * @throws SkillNotFoundException
     */

    @GetMapping("skill/{id}")
    public Skill getSkill(@PathVariable int id)
            throws SkillNotFoundException, SkillNotFoundException {

        return skillService.getSkill(id);
    }

    /**
     * endpoint http://localhost:8080/recrumeVEG/skill/description/{description}
     * @param description
     * @return skill by description
     * @throws SkillNotFoundException
     */

    @GetMapping("skill/description/{description}")
    public List<Skill> getSkillByDescription(@PathVariable String description)
            throws SkillNotFoundException {
        return skillService.readByDescription(description);
    }

    /**
     * endpoint http://localhost:8080/recrumeVEG/skill/{id}/description
     * updates description of skill
     * @param id
     * @param skillDto
     * @return updated skill
     * @throws SkillNotFoundException
     */

    @PutMapping("skill/{id}/description")
    public Skill updateOne(@PathVariable int id,
                              @RequestBody SkillDto skillDto)
            throws SkillNotFoundException {
        return skillService.updateOne(id, skillDto);
    }

    /**
     * endpoint http://localhost:8080/recrumeVEG/skill/excel
     * get all skills from excel file
     * @return skill from excel
     * @throws SkillNotFoundException
     * @throws IOException
     */
    @GetMapping("skill/excel")
    public List<Skill> getSkillExcel()
            throws SkillNotFoundException, IOException {
        return skillExcelService.getSkillExcel();
    }
}
