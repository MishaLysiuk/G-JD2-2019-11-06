package com.itacademy.jd2.ml.linkedin.web.converter.fromDTO;

import com.itacademy.jd2.ml.linkedin.ICountryService;
import com.itacademy.jd2.ml.linkedin.entity.table.ICountry;
import com.itacademy.jd2.ml.linkedin.web.dto.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CountryFromDTOConverter implements Function<CountryDTO, ICountry> {
    
    private ICountryService countryService;

    @Autowired
    public CountryFromDTOConverter(ICountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public ICountry apply(final CountryDTO dto) {
        final ICountry entity = countryService.createEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }
}
