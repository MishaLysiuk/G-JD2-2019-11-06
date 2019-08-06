package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.ICourse;
import com.itacademy.jd2.ml.linkedin.filter.CourseFilter;

import javax.transaction.Transactional;
import java.util.List;

public interface ICourseService {
    ICourse createEntity();

    @Transactional
    void save(ICourse entity);

    ICourse get(Integer id);

    @Transactional
    void delete(Integer id);

    List<ICourse> getAll();

    List<ICourse> find(CourseFilter filter);

    long getCount(CourseFilter filter);
}
