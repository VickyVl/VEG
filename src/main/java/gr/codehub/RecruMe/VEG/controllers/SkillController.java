package gr.codehub.RecruMe.VEG.controllers;

import gr.codehub.RecruMe.VEG.dtos.SkillDto;
import gr.codehub.RecruMe.VEG.exceptions.SkillNotFoundException;
import gr.codehub.RecruMe.VEG.models.Skill;
import gr.codehub.RecruMe.VEG.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SkillController {
    @Autowired
    private SkillService skillService;

    @PostMapping("skill")
    public Skill newSkill(@RequestBody SkillDto skillDto) {
        return skillService.save(skillDto);
    }

    @GetMapping("skills")
    public List<Skill> readAll( ) {
        return skillService.getAll();
    }

    @GetMapping("skill/{id}")
    public Skill getSkill(@PathVariable int id)
            throws SkillNotFoundException, SkillNotFoundException {

        return skillService.getSkill(id);
    }

    @GetMapping("skill/description/{description}")
    public List<Skill> getSkillByDescription(@PathVariable String description)
            throws SkillNotFoundException {
        return skillService.readByDescription(description);
    }

    @PutMapping("skill/{id}")
    public Skill updateOne(@PathVariable int id,
                              @RequestBody SkillDto skillDto)
            throws SkillNotFoundException {
        return skillService.updateOne(id, skillDto);
    }
}
