package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.ICity;
import com.itacademy.jd2.ml.linkedin.filter.CityFilter;

import java.util.List;

public interface ICityService {
    ICity createEntity();

    void save(ICity entity);

    ICity get(Integer id);

    void delete(Integer id);

    void deleteAll();

    List<ICity> getAll();

    List<ICity> find(CityFilter filter);
}
