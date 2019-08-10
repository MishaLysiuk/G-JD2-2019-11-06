package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.ICountry;
import com.itacademy.jd2.ml.linkedin.filter.CountryFilter;

import java.util.List;

public interface ICountryService {
    ICountry createEntity();

    void save(ICountry entity);

    ICountry get(Integer id);

    void delete(Integer id);

    void deleteAll();

    List<ICountry> getAll();

    List<ICountry> find(CountryFilter filter);
}
