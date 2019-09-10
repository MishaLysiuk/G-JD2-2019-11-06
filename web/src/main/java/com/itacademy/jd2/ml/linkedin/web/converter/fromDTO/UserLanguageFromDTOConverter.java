package com.itacademy.jd2.ml.linkedin.web.converter.fromDTO;

import com.itacademy.jd2.ml.linkedin.ILanguageLevelService;
import com.itacademy.jd2.ml.linkedin.ILanguageService;
import com.itacademy.jd2.ml.linkedin.IUserLanguageService;
import com.itacademy.jd2.ml.linkedin.entity.table.ILanguage;
import com.itacademy.jd2.ml.linkedin.entity.table.ILanguageLevel;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserLanguage;
import com.itacademy.jd2.ml.linkedin.web.dto.UserLanguageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserLanguageFromDTOConverter implements Function<UserLanguageDTO, IUserLanguage>{

    private IUserLanguageService userLanguageService;
    private ILanguageService languageService;
    private ILanguageLevelService levelService;

    @Autowired
    public UserLanguageFromDTOConverter(IUserLanguageService userLanguageService, ILanguageService languageService, ILanguageLevelService levelService) {
        this.userLanguageService = userLanguageService;
        this.languageService = languageService;
        this.levelService = levelService;
    }

    @Override
    public IUserLanguage apply(UserLanguageDTO dto) {
        IUserLanguage entity = userLanguageService.createEntity();

        entity.setId(dto.getId());

        ILanguage language = languageService.createEntity();
        language.setId(dto.getLanguageId());
        entity.setLanguage(language);

        ILanguageLevel level = levelService.createEntity();
        level.setId(dto.getLevelId());
        entity.setLevel(level);

        return entity;
    }
}
