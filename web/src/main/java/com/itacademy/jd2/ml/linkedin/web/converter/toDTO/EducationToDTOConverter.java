package com.itacademy.jd2.ml.linkedin.web.converter.toDTO;

import com.itacademy.jd2.ml.linkedin.entity.table.*;
import com.itacademy.jd2.ml.linkedin.web.dto.EducationDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class EducationToDTOConverter implements Function<IEducation, EducationDTO> {


    @Override
    public EducationDTO apply(IEducation entity) {
        final EducationDTO dto = new EducationDTO();
        dto.setId(entity.getId());
        dto.setUniversity(entity.getUniversity());
        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());
        dto.setAddress(entity.getAddress());

        ISpeciality speciality = entity.getSpeciality();

        if (speciality != null) {
            dto.setSpecialityId(speciality.getId());
            dto.setSpecialityName(speciality.getName());

            IDegree degree = entity.getDegree();
            dto.setDegreeId(degree.getId());
            dto.setDegreeName(degree.getName());


            ICity city = entity.getCity();
            dto.setCityId(city.getId());

            /*ICountry country = city.getCountry();
            dto.setCountryId(country.getId());

            IRegion region = country.getRegion();
            dto.setRegionId(region.getId());*/
        }

        return dto;
    }
}
