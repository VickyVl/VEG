package gr.codehub.RecruMe.VEG.services;

import gr.codehub.RecruMe.VEG.dtos.SkillDto;
import gr.codehub.RecruMe.VEG.exceptions.SkillNotFoundException;
import gr.codehub.RecruMe.VEG.models.Skill;
import gr.codehub.RecruMe.VEG.repositories.Skills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SkillService {
    private Skills skillRepo;

    @Autowired
    public SkillService(Skills skillRepo) {
        this.skillRepo = skillRepo;
    }

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

}
