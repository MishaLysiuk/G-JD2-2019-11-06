package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.IGroupSkillDao;
import com.itacademy.jd2.ml.linkedin.entity.table.IGroupSkill;
import com.itacademy.jd2.ml.linkedin.filter.GroupFilter;
import com.itacademy.jd2.ml.linkedin.impl.entity.GroupSkill;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GroupSkillDaoImpl extends AbstractDaoImpl<IGroupSkill,Integer> implements IGroupSkillDao {

    protected GroupSkillDaoImpl() {
        super(GroupSkill.class);
    }

    @Override
    public List<IGroupSkill> find(GroupFilter filter) {
        return null;
    }

    @Override
    public long getCount(GroupFilter filter) {
        return 0;
    }

    @Override
    public IGroupSkill createEntity() {
        GroupSkill group = new GroupSkill();
        return group;
    }
}
