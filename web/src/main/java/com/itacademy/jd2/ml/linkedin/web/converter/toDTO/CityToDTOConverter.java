package com.itacademy.jd2.ml.linkedin.web.converter.toDTO;

import com.itacademy.jd2.ml.linkedin.entity.table.ICity;
import com.itacademy.jd2.ml.linkedin.web.dto.CityDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CityToDTOConverter implements Function<ICity, CityDTO> {


    @Override
    public CityDTO apply(ICity entity) {
        final CityDTO dto = new CityDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
