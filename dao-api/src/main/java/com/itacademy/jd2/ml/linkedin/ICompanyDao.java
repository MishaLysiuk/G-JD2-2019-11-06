package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.ICompany;
import com.itacademy.jd2.ml.linkedin.filter.CompanyFilter;

import java.util.List;

public interface ICompanyDao extends IDao<ICompany, Integer> {

    List<ICompany> find(CompanyFilter filter); // skip


    long getCount(CompanyFilter filter); // skip {

    List<ICompany> findByName(String name);
}
