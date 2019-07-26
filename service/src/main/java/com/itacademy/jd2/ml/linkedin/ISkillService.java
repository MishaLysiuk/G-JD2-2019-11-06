package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.ISkill;
import com.itacademy.jd2.ml.linkedin.filter.SkillFilter;

import java.util.List;

public interface ISkillService {
    ISkill createEntity();

    void save(ISkill entity);

    ISkill get(Integer id);

    void delete(Integer id);

    List<ISkill> getAll();

    long getCount(SkillFilter filter);

    ISkill getFullInfo(Integer id);
}
