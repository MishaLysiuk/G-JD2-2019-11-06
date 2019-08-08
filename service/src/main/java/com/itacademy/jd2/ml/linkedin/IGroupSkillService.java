package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.IGroupSkill;
import com.itacademy.jd2.ml.linkedin.filter.GroupFilter;

import javax.transaction.Transactional;
import java.util.List;

public interface IGroupSkillService {
    IGroupSkill createEntity();

    @Transactional
    void save(IGroupSkill entity);

    IGroupSkill get(Integer id);

    @Transactional
    void delete(Integer id);

    @Transactional
    void deleteAll();

    List<IGroupSkill> getAll();

    List<IGroupSkill> find(GroupFilter filter);

    long getCount(GroupFilter filter);

}
