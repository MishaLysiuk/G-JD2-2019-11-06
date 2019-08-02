package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.ICityDao;
import com.itacademy.jd2.ml.linkedin.entity.table.ICity;
import com.itacademy.jd2.ml.linkedin.filter.CityFilter;
import com.itacademy.jd2.ml.linkedin.impl.entity.City;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CityDaoImpl extends AbstractDaoImpl<ICity,Integer> implements ICityDao {

    protected CityDaoImpl() {
        super(City.class);
    }

    @Override
    public List<ICity> find(CityFilter filter) {
        return null;
    }

    @Override
    public ICity createEntity() {
        return null;
    }
}
