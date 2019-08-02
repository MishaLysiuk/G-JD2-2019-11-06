package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.IGroupDao;
import com.itacademy.jd2.ml.linkedin.entity.table.IGroup;
import com.itacademy.jd2.ml.linkedin.filter.GroupFilter;
import com.itacademy.jd2.ml.linkedin.impl.entity.Group;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GroupDaoImpl extends AbstractDaoImpl<IGroup,Integer> implements IGroupDao {

    protected GroupDaoImpl() {
        super(Group.class);
    }

    @Override
    public List<IGroup> find(GroupFilter filter) {
        return null;
    }

    @Override
    public long getCount(GroupFilter filter) {
        return 0;
    }

    @Override
    public IGroup createEntity() {
        Group group = new Group();
        return group;
    }
}
