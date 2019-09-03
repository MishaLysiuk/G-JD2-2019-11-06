package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.ICourse;
import com.itacademy.jd2.ml.linkedin.filter.CourseFilter;

import java.util.List;

public interface ICourseDao extends IDao<ICourse, Integer> {
    List<ICourse> find(CourseFilter filter); // skip

    long getCount(CourseFilter filter); // skip {

    ICourse getFullInfo(Integer id);

    List<ICourse> findByName(String name);

    List<ICourse> findByUserId(Integer userId);
}
