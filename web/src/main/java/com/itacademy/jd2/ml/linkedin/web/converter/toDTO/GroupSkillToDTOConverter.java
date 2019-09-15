package com.itacademy.jd2.ml.linkedin.web.converter.toDTO;

import com.itacademy.jd2.ml.linkedin.entity.table.IGroupSkill;
import com.itacademy.jd2.ml.linkedin.web.dto.GroupSkillDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class GroupSkillToDTOConverter implements Function<IGroupSkill, GroupSkillDTO> {


    @Override
    public GroupSkillDTO apply(IGroupSkill entity) {
        final GroupSkillDTO dto = new GroupSkillDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
