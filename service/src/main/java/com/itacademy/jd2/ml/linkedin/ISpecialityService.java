package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.ISpeciality;
import com.itacademy.jd2.ml.linkedin.filter.SpecialityFilter;

import javax.transaction.Transactional;
import java.util.List;

public interface ISpecialityService {

    ISpeciality get(Integer id);

    List<ISpeciality> getAll();

    @Transactional
    void save(ISpeciality entity);

    @Transactional
    void delete(Integer id);

    @Transactional
    void deleteAll();

    ISpeciality createEntity();

    List<ISpeciality> find(SpecialityFilter filter);

    long getCount(SpecialityFilter filter);
    
}
