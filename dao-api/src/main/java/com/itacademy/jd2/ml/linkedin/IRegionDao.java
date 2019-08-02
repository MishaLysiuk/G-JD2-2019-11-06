package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.IRegion;
import com.itacademy.jd2.ml.linkedin.filter.RegionFilter;

import java.util.List;

public interface IRegionDao extends IDao<IRegion, Integer> {

    List<IRegion> find(RegionFilter filter);

}
