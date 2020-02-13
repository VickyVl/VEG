package gr.codehub.RecruMe.VEG.controllers.api;

import gr.codehub.RecruMe.VEG.dtos.SkillDto;
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
 * - to register a new skill
 * - to search skill by id and description
 * - to update the description of a skill
 * - to display all skills from the excel file
 * displaying all the above via the corresponding HTTP responses as json files on the web.
 */

@RestController
@RequestMapping("/recrumeVEG/")
public class SkillController {
    @Autowired
    private SkillService skillService;
    @Autowired
    private SkillExcelService skillExcelService;

    /**
     * Register a new skill
     * @param skillDto
     * @return new skill
     */

    @PostMapping("skill")
    public Skill newSkill(@RequestBody SkillDto skillDto) {
        return skillService.save(skillDto);
    }

    /**
     * Display all skills from database
     * @return all skills
     */

    @GetMapping("skills")
    public List<Skill> readAll( ) {
        return skillService.getAll();
    }

    /**
     * Display a skill with a particular id
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
     * Display a skill with a particular description
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
     * Update description of skill
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
     * Retrieve all skills from excel file
     * @return skills from excel
     * @throws IOException
     */

    @GetMapping("skill/excel")
    public List<Skill> getSkillExcel()
            throws IOException {
        return skillExcelService.getSkillExcel();
    }
}
