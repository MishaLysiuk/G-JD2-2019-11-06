package com.itacademy.jd2.ml.linkedin.web.converter;

import com.itacademy.jd2.ml.linkedin.entity.table.ICountry;
import com.itacademy.jd2.ml.linkedin.web.dto.CountryDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CountryToDTOConverter implements Function<ICountry, CountryDTO> {


    @Override
    public CountryDTO apply(ICountry entity) {
        final CountryDTO dto = new CountryDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setRegion(entity.getRegion());
        return dto;
    }
}
