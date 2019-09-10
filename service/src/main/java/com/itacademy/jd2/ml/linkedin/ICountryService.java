package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.ICountry;
import com.itacademy.jd2.ml.linkedin.filter.CountryFilter;

import javax.transaction.Transactional;
import java.util.List;

public interface ICountryService {
    ICountry createEntity();

    @Transactional
    void save(ICountry entity);

    ICountry get(Integer id);

    @Transactional
    void delete(Integer id);

    @Transactional
    void deleteAll();

    List<ICountry> getAll();

    ICountry getFullInfo(Integer id);

    List<ICountry> find(CountryFilter filter);
}
