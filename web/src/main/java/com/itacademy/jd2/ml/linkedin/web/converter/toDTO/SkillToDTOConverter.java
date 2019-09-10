package com.itacademy.jd2.ml.linkedin.web.converter.toDTO;

import com.itacademy.jd2.ml.linkedin.entity.table.IGroupSkill;
import com.itacademy.jd2.ml.linkedin.entity.table.ISkill;
import com.itacademy.jd2.ml.linkedin.web.dto.SkillDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class SkillToDTOConverter implements Function<ISkill, SkillDTO> {

    @Override
    public SkillDTO apply(ISkill entity) {
        SkillDTO dto = new SkillDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());

        IGroupSkill group = entity.getGroup();
        dto.setGroupId(group.getId());
        dto.setGroupName(group.getName());

        return dto;
    }
}
