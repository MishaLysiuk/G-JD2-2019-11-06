package com.itacademy.jd2.ml.linkedin.web.converter.toDTO;

import com.itacademy.jd2.ml.linkedin.entity.table.ILanguage;
import com.itacademy.jd2.ml.linkedin.entity.table.ILanguageLevel;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserLanguage;
import com.itacademy.jd2.ml.linkedin.web.dto.UserLanguageDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserLanguageToDTOConverter implements Function<IUserLanguage, UserLanguageDTO> {

    @Override
    public UserLanguageDTO apply(IUserLanguage entity) {
        final UserLanguageDTO dto = new UserLanguageDTO();
        dto.setId(entity.getId());

        ILanguage language = entity.getLanguage();
        if (language != null) {
            dto.setLanguageId(language.getId());
            dto.setLanguageName(language.getName());

            ILanguageLevel level = entity.getLevel();
            dto.setLevelId(level.getId());
            dto.setLevelName(level.getName());
        }

        return dto;
    }
}
