package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.ISkill;
import com.itacademy.jd2.ml.linkedin.filter.SkillFilter;

import javax.transaction.Transactional;
import java.util.List;

public interface ISkillService {
    ISkill createEntity();

    @Transactional
    void save(ISkill entity);

    ISkill get(Integer id);

    @Transactional
    void delete(Integer id);

    @Transactional
    List<ISkill> getAll();

    long getCount(SkillFilter filter);

    ISkill getFullInfo(Integer id);
}
