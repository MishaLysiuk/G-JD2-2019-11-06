package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.ISkillDao;
import com.itacademy.jd2.ml.linkedin.entity.table.ISkill;
import com.itacademy.jd2.ml.linkedin.filter.SkillFilter;
import com.itacademy.jd2.ml.linkedin.impl.entity.Skill;
import org.springframework.stereotype.Repository;

@Repository
public class SkillDaoImpl extends AbstractDaoImpl<ISkill,Integer> implements ISkillDao {

    protected SkillDaoImpl() {
        super(Skill.class);
    }

    @Override
    public long getCount(SkillFilter filter) {
        return 0;
    }

    @Override
    public ISkill getFullInfo(Integer id) {
        return null;
    }

    @Override
    public ISkill createEntity() {
        Skill skill = new Skill();
        return skill;
    }
}
