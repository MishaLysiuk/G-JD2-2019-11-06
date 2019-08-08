package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.IGroupSkill;
import com.itacademy.jd2.ml.linkedin.filter.GroupFilter;

import java.util.List;

public interface IGroupSkillDao extends IDao<IGroupSkill, Integer> {
    List<IGroupSkill> find(GroupFilter filter);

    long getCount(GroupFilter filter);

}
