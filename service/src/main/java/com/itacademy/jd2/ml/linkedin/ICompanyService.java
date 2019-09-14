package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.ICompany;
import com.itacademy.jd2.ml.linkedin.filter.CompanyFilter;
import com.itacademy.jd2.ml.linkedin.impl.entity.Company;

import javax.transaction.Transactional;
import java.util.List;

public interface ICompanyService {

    ICompany get(Integer id);

    List<ICompany> getAll();

    @Transactional
    void save(ICompany entity);

    @Transactional
    void delete(Integer id);

    @Transactional
    void deleteAll();

    ICompany createEntity();

    @Transactional
    ICompany saveOrCreate(String name);

    List<ICompany> find(CompanyFilter filter);

    long getCount(CompanyFilter filter);

    List<ICompany> findByName(String name);
}
