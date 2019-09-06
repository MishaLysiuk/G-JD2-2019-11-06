package com.itacademy.jd2.ml.linkedin.web.converter.fromDTO;

import com.itacademy.jd2.ml.linkedin.ILanguageService;
import com.itacademy.jd2.ml.linkedin.entity.table.ILanguage;
import com.itacademy.jd2.ml.linkedin.web.dto.LanguageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class LanguageFromDTO implements Function<LanguageDTO, ILanguage> {

    private ILanguageService languageService;

    @Autowired
    public LanguageFromDTO(ILanguageService languageService) {
        this.languageService = languageService;
    }

    @Override
    public ILanguage apply(LanguageDTO dto) {
        ILanguage entity = languageService.createEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }
}
