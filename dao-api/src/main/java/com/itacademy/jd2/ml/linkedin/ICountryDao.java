package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.ICountry;
import com.itacademy.jd2.ml.linkedin.filter.CountryFilter;

import java.util.List;

public interface ICountryDao extends IDao<ICountry, Integer> {

    List<ICountry> find(CountryFilter filter);

}
