package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.IDegree;
import com.itacademy.jd2.ml.linkedin.filter.DegreeFilter;

import java.util.List;

public interface IDegreeDao extends IDao<IDegree, Integer> {


    List<IDegree> find(DegreeFilter filter); // skip


    long getCount(DegreeFilter filter); // skip

}
