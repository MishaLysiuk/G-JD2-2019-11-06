package com.itacademy.jd2.ml.linkedin.web.converter;

import com.itacademy.jd2.ml.linkedin.ICompanyService;
import com.itacademy.jd2.ml.linkedin.entity.table.ICompany;
import com.itacademy.jd2.ml.linkedin.web.dto.CompanyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CompanyFromDTOConverter implements Function<CompanyDTO, ICompany> {

    private ICompanyService companyService;

    @Autowired
    public CompanyFromDTOConverter(ICompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    public ICompany apply(CompanyDTO dto) {
        ICompany entity = companyService.createEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }
}
