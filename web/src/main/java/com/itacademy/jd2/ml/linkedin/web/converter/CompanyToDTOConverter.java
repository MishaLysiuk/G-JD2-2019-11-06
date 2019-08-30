package com.itacademy.jd2.ml.linkedin.web.converter;

import com.itacademy.jd2.ml.linkedin.entity.table.ICompany;
import com.itacademy.jd2.ml.linkedin.web.dto.CompanyDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CompanyToDTOConverter implements Function<ICompany, CompanyDTO> {

    @Override
    public CompanyDTO apply(ICompany entity) {
        CompanyDTO dto = new CompanyDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());

        return dto;
    }
}
