package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.ICity;
import com.itacademy.jd2.ml.linkedin.entity.table.ICountry;

import java.util.List;

public interface IDao<ENTITY, ID> {

    ENTITY createEntity();

    ENTITY get(ID id);

    void update(ENTITY entity);

    void insert(ENTITY entity);

    void delete(ID id);

    void deleteAll();

    List<ENTITY> selectAll();
}