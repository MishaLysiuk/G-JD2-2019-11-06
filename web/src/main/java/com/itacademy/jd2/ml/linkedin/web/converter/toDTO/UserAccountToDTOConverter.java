package com.itacademy.jd2.ml.linkedin.web.converter.toDTO;

import com.itacademy.jd2.ml.linkedin.entity.table.ILanguage;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;
import com.itacademy.jd2.ml.linkedin.web.dto.UserAccountDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserAccountToDTOConverter implements Function<IUserAccount, UserAccountDTO> {


    @Override
    public UserAccountDTO apply(IUserAccount entity) {
        final UserAccountDTO dto = new UserAccountDTO();
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        dto.setRole(entity.getRole());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setBirthday(entity.getBirthday());
        dto.setJobTitle(entity.getJobTitle());
        dto.setContactInfo(entity.getContactInfo());

        ILanguage motherTongue = entity.getMotherTongue();
        dto.setMotherTongueId(motherTongue.getId());
        dto.setMotherTongueName(motherTongue.getName());

        return dto;
    }
}
