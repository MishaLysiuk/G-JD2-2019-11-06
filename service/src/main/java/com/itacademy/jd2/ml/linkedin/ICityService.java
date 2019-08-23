package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.ICity;
import com.itacademy.jd2.ml.linkedin.filter.CityFilter;

import javax.transaction.Transactional;
import java.util.List;

public interface ICityService {
    ICity createEntity();

    @Transactional
    void save(ICity entity);

    ICity get(Integer id);

    @Transactional
    void delete(Integer id);

    @Transactional
    void deleteAll();

    List<ICity> getAll();

    List<ICity> find(CityFilter filter);
}
