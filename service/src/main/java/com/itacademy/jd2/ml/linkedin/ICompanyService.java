package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.ICompany;
import com.itacademy.jd2.ml.linkedin.filter.CompanyFilter;

import java.util.List;

public interface ICompanyService {

    ICompany get(Integer id);

    List<ICompany> getAll();

    void save(ICompany entity);

    void delete(Integer id);

    void deleteAll();

    ICompany createEntity();

    List<ICompany> find(CompanyFilter filter);

    long getCount(CompanyFilter filter);
}
