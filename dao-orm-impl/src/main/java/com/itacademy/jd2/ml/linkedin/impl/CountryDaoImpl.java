package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.ICountryDao;
import com.itacademy.jd2.ml.linkedin.entity.table.ICountry;
import com.itacademy.jd2.ml.linkedin.filter.CourseFilter;
import com.itacademy.jd2.ml.linkedin.impl.entity.Country;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryDaoImpl extends AbstractDaoImpl<ICountry, Integer> implements ICountryDao {
    protected CountryDaoImpl() {
        super(Country.class);
    }

    @Override
    public List<ICountry> find(CourseFilter filter) {
        return null;
    }

    @Override
    public ICountry createEntity() {
        Country country = new Country();
        return country;
    }
}
