package com.itacademy.jd2.ml.linkedin.web.converter;

import com.itacademy.jd2.ml.linkedin.IRegionService;
import com.itacademy.jd2.ml.linkedin.entity.table.IRegion;
import com.itacademy.jd2.ml.linkedin.web.dto.RegionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RegionFromDTOConverter implements Function<RegionDTO, IRegion> {
    
    private IRegionService regionService;

    @Autowired
    public RegionFromDTOConverter(IRegionService regionService) {
        this.regionService = regionService;
    }

    @Override
    public IRegion apply(final RegionDTO dto) {
        final IRegion entity = regionService.createEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }
}
