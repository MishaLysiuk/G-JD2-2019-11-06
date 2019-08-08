package com.itacademy.jd2.ml.linkedin.web.converter;

import com.itacademy.jd2.ml.linkedin.IUserAccountService;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;
import com.itacademy.jd2.ml.linkedin.web.dto.UserAccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserAccountFromDTOConverter implements Function<UserAccountDTO, IUserAccount> {

    private IUserAccountService userAccountService;

    @Autowired
    public UserAccountFromDTOConverter(IUserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @Override
    public IUserAccount apply(final UserAccountDTO dto) {
        final IUserAccount entity = userAccountService.createEntity();
        entity.setId(dto.getId());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setRoleId(dto.getRoleId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setBirthday(dto.getBirthday());
        entity.setIndustryId(dto.getIndustryId());
        entity.setPositionId(dto.getPositionId());
        entity.setContactInfo(dto.getContactInfo());
        entity.setMotherTongue(dto.getMotherTongue());
        return entity;
    }

}
