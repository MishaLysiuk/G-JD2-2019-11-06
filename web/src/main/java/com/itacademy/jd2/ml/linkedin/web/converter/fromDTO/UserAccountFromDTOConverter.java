package com.itacademy.jd2.ml.linkedin.web.converter.fromDTO;

import com.itacademy.jd2.ml.linkedin.ILanguageService;
import com.itacademy.jd2.ml.linkedin.IUserAccountService;
import com.itacademy.jd2.ml.linkedin.entity.table.ILanguage;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;
import com.itacademy.jd2.ml.linkedin.web.dto.UserAccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserAccountFromDTOConverter implements Function<UserAccountDTO, IUserAccount> {

    private IUserAccountService userAccountService;
    private ILanguageService languageService;

    @Autowired
    public UserAccountFromDTOConverter(IUserAccountService userAccountService, ILanguageService languageService) {
        this.userAccountService = userAccountService;
        this.languageService = languageService;
    }

    @Override
    public IUserAccount apply(final UserAccountDTO dto) {
        final IUserAccount entity = userAccountService.createEntity();
        entity.setId(dto.getId());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setRole(dto.getRole());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setBirthday(dto.getBirthday());
        entity.setJobTitle(dto.getJobTitle());
        entity.setContactInfo(dto.getContactInfo());

        ILanguage motherTongue = languageService.createEntity();
        motherTongue.setId(dto.getMotherTongueId());
        entity.setMotherTongue(motherTongue);

        return entity;
    }

}
