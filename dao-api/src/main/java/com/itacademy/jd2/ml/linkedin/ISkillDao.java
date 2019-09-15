package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.ISkill;
import com.itacademy.jd2.ml.linkedin.filter.SkillFilter;

import java.util.List;

public interface ISkillDao extends IDao<ISkill, Integer> {
    long getCount(SkillFilter filter);

    ISkill getFullInfo(Integer id);

    List<ISkill> findByGroupId(Integer groupId);
}
