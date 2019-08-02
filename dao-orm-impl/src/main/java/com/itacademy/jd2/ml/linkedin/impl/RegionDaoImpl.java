package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.IRegionDao;
import com.itacademy.jd2.ml.linkedin.entity.table.IRegion;
import com.itacademy.jd2.ml.linkedin.filter.RegionFilter;
import com.itacademy.jd2.ml.linkedin.impl.entity.Region;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegionDaoImpl extends AbstractDaoImpl<IRegion,Integer> implements IRegionDao {
    protected RegionDaoImpl() {
        super(Region.class);
    }

    @Override
    public List<IRegion> find(RegionFilter filter) {
        return null;
    }

    @Override
    public IRegion createEntity() {
        Region region = new Region();
        return region;
    }
}
