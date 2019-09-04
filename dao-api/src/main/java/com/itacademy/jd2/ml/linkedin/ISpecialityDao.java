package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.ISpeciality;
import com.itacademy.jd2.ml.linkedin.filter.SpecialityFilter;

import java.util.List;

public interface ISpecialityDao extends IDao<ISpeciality, Integer> {


    List<ISpeciality> find(SpecialityFilter filter); // skip


    long getCount(SpecialityFilter filter); // skip

}
