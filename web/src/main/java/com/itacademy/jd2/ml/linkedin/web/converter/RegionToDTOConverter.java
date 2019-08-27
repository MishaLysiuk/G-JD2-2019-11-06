package com.itacademy.jd2.ml.linkedin.web.converter;

import com.itacademy.jd2.ml.linkedin.entity.table.IRegion;
import com.itacademy.jd2.ml.linkedin.web.dto.RegionDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RegionToDTOConverter implements Function<IRegion, RegionDTO> {


    @Override
    public RegionDTO apply(IRegion entity) {
        final RegionDTO dto = new RegionDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
