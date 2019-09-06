package com.itacademy.jd2.ml.linkedin.web.converter.toDTO;

import com.itacademy.jd2.ml.linkedin.entity.table.ILanguage;
import com.itacademy.jd2.ml.linkedin.web.dto.LanguageDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class LanguageToDTO implements Function<ILanguage, LanguageDTO> {

    @Override
    public LanguageDTO apply(ILanguage entity) {
        LanguageDTO dto = new LanguageDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
