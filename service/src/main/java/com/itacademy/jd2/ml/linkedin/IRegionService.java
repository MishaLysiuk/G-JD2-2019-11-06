package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.IRegion;
import com.itacademy.jd2.ml.linkedin.filter.RegionFilter;

import java.util.List;

public interface IRegionService {
    IRegion createEntity();

    void save(IRegion entity);

    IRegion get(Integer id);

    void delete(Integer id);

    void deleteAll();

    List<IRegion> getAll();

    List<IRegion> find(RegionFilter filter);
}
