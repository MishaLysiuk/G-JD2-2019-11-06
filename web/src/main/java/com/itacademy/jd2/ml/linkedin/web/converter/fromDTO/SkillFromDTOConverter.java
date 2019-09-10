package com.itacademy.jd2.ml.linkedin.web.converter.fromDTO;

import com.itacademy.jd2.ml.linkedin.IGroupSkillService;
import com.itacademy.jd2.ml.linkedin.ISkillService;
import com.itacademy.jd2.ml.linkedin.entity.table.IGroupSkill;
import com.itacademy.jd2.ml.linkedin.entity.table.ISkill;
import com.itacademy.jd2.ml.linkedin.web.dto.SkillDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class SkillFromDTOConverter implements Function<SkillDTO, ISkill> {

    private ISkillService skillService;
    private IGroupSkillService groupService;

    @Autowired
    public SkillFromDTOConverter(ISkillService skillService, IGroupSkillService groupService) {
        this.skillService = skillService;
        this.groupService = groupService;
    }

    @Override
    public ISkill apply(SkillDTO dto) {
        ISkill entity = skillService.createEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());

        IGroupSkill group = groupService.createEntity();
        group.setId(dto.getGroupId());
        entity.setGroup(group);

        return entity;
    }
}
