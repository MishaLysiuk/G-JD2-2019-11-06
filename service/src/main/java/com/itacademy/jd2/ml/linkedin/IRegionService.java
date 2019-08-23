package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.IRegion;
import com.itacademy.jd2.ml.linkedin.filter.RegionFilter;

import javax.transaction.Transactional;
import java.util.List;

public interface IRegionService {
    IRegion createEntity();

    @Transactional
    void save(IRegion entity);

    IRegion get(Integer id);

    @Transactional
    void delete(Integer id);

    @Transactional
    void deleteAll();

    List<IRegion> getAll();

    List<IRegion> find(RegionFilter filter);
}
