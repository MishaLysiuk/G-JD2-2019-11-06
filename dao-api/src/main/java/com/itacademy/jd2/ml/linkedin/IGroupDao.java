package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.IGroup;
import com.itacademy.jd2.ml.linkedin.filter.GroupFilter;

import java.util.List;

public interface IGroupDao extends IDao<IGroup, Integer> {
    List<IGroup> find(GroupFilter filter);

    long getCount(GroupFilter filter);
}
