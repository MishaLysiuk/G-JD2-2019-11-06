package com.itacademy.jd2.ml.linkedin.web.converter;

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
        dto.setRoleId(entity.getRoleId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setBirthday(entity.getBirthday());
        dto.setJobTitle(entity.getJobTitle());
        dto.setContactInfo(entity.getContactInfo());
        dto.setMotherTongue(entity.getMotherTongue());
        dto.setCreated(entity.getCreated());
        dto.setUpdated(entity.getUpdated());
        return dto;
    }
}
