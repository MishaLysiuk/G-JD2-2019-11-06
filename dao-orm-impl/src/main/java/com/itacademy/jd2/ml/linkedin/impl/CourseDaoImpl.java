package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.ICourseDao;
import com.itacademy.jd2.ml.linkedin.entity.table.ICourse;
import com.itacademy.jd2.ml.linkedin.filter.CourseFilter;
import com.itacademy.jd2.ml.linkedin.impl.entity.Course;

import java.util.List;

public class CourseDaoImpl extends AbstractDaoImpl<ICourse,Integer> implements ICourseDao {

    protected CourseDaoImpl() {
        super(Course.class);
    }

    @Override
    public List<ICourse> find(CourseFilter filter) {
        return null;
    }

    @Override
    public long getCount(CourseFilter filter) {
        return 0;
    }

    @Override
    public ICourse getFullInfo(Integer id) {
        return null;
    }

    @Override
    public ICourse createEntity() {
        return null;
    }
}
