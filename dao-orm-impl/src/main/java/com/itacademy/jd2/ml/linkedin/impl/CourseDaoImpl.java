package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.ICourseDao;
import com.itacademy.jd2.ml.linkedin.entity.table.ICourse;
import com.itacademy.jd2.ml.linkedin.filter.CourseFilter;
import com.itacademy.jd2.ml.linkedin.impl.entity.Course;
import com.itacademy.jd2.ml.linkedin.impl.entity.Course_;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
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
    public ICourse createEntity() {
        Course course = new Course();
        return course;
    }

    @Override
    public ICourse getFullInfo(final Integer id) {
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();

        final CriteriaQuery<ICourse> cq = cb.createQuery(ICourse.class); // define returning result
        final Root<Course> from = cq.from(Course.class); // define table for select

        cq.select(from); // define what need to be selected

        from.fetch(Course_.company, JoinType.LEFT);

        from.fetch(Course_.users, JoinType.LEFT);
        cq.distinct(true); // to avoid duplicate rows in result

        // .. where id=...
        cq.where(cb.equal(from.get(Course_.id), id)); // where id=?

        final TypedQuery<ICourse> q = em.createQuery(cq);

        return getSingleResult(q);
    }

    @Override
    public List<ICourse> findByName(String name) {
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<ICourse> cq = cb.createQuery(ICourse.class);
        final Root<Course> from = cq.from(Course.class);
        cq.select(from);

        cq.where(cb.like(cb.lower(from.get(Course_.name)), "%" + name.toLowerCase() + "%"));
        final TypedQuery<ICourse> q = em.createQuery(cq);

        List<ICourse> resultList = q.getResultList();


        return resultList;
    }

}
