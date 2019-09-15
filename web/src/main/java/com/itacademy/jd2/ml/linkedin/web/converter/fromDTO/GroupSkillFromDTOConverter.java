package com.itacademy.jd2.ml.linkedin.web.converter.fromDTO;

import com.itacademy.jd2.ml.linkedin.IGroupSkillService;
import com.itacademy.jd2.ml.linkedin.entity.table.IGroupSkill;
import com.itacademy.jd2.ml.linkedin.web.dto.GroupSkillDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class GroupSkillFromDTOConverter implements Function<GroupSkillDTO, IGroupSkill> {

    private IGroupSkillService groupSkillService;

    @Autowired
    public GroupSkillFromDTOConverter(IGroupSkillService groupSkillService) {
        this.groupSkillService = groupSkillService;
    }

    @Override
    public IGroupSkill apply(GroupSkillDTO dto) {
        final IGroupSkill entity = groupSkillService.createEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }
}
