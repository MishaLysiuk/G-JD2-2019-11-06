package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.IDegree;
import com.itacademy.jd2.ml.linkedin.filter.DegreeFilter;

import javax.transaction.Transactional;
import java.util.List;

public interface IDegreeService {

    IDegree get(Integer id);

    List<IDegree> getAll();

    @Transactional
    void save(IDegree entity);

    @Transactional
    void delete(Integer id);

    @Transactional
    void deleteAll();

    IDegree createEntity();

    List<IDegree> find(DegreeFilter filter);

    long getCount(DegreeFilter filter);
    
}
