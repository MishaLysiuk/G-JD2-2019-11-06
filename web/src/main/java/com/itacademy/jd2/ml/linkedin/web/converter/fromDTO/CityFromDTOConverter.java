package com.itacademy.jd2.ml.linkedin.web.converter.fromDTO;

import com.itacademy.jd2.ml.linkedin.ICityService;
import com.itacademy.jd2.ml.linkedin.entity.table.ICity;
import com.itacademy.jd2.ml.linkedin.web.dto.CityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CityFromDTOConverter implements Function<CityDTO, ICity> {
    
    private ICityService cityService;

    @Autowired
    public CityFromDTOConverter(ICityService cityService) {
        this.cityService = cityService;
    }

    @Override
    public ICity apply(final CityDTO dto) {
        final ICity entity = cityService.createEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCountry(dto.getCountry());
        return entity;
    }
}
