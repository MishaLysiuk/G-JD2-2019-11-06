package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.ICity;
import com.itacademy.jd2.ml.linkedin.entity.table.ICountry;
import com.itacademy.jd2.ml.linkedin.filter.CityFilter;

import java.util.List;

public interface ICityDao extends IDao<ICity, Integer> {

    List<ICity> find(CityFilter filter);

    List<ICountry> findCountryByRegionId(Integer regionId);

    List<ICity> findCityByCountryId(Integer countryId);
}
