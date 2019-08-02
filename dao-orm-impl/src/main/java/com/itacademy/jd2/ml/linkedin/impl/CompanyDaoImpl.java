package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.ICompanyDao;
import com.itacademy.jd2.ml.linkedin.entity.table.ICompany;
import com.itacademy.jd2.ml.linkedin.filter.CompanyFilter;
import com.itacademy.jd2.ml.linkedin.impl.entity.Company;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyDaoImpl extends AbstractDaoImpl<ICompany, Integer> implements ICompanyDao {

    protected CompanyDaoImpl() {
        super(Company.class);
    }

    @Override
    public List<ICompany> find(CompanyFilter filter) {
        return null;
    }

    @Override
    public long getCount(CompanyFilter filter) {
        return 0;
    }

    @Override
    public ICompany createEntity() {
        Company company = new Company();
        return company;
    }
}
