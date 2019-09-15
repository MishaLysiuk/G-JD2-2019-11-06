package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.IEducationDao;
import com.itacademy.jd2.ml.linkedin.entity.table.IEducation;
import com.itacademy.jd2.ml.linkedin.filter.EducationFilter;
import com.itacademy.jd2.ml.linkedin.impl.entity.Education;
import com.itacademy.jd2.ml.linkedin.impl.entity.Education_;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class EducationDaoImpl extends AbstractDaoImpl<IEducation, Integer> implements IEducationDao {
    protected EducationDaoImpl() {
        super(Education.class);
    }

    @Override
    public List<IEducation> find(EducationFilter filter) {
        return null;
    }

    @Override
    public List<IEducation> findByUserId(Integer userId) {
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<IEducation> cq = cb.createQuery(IEducation.class);
        final Root<Education> from = cq.from(Education.class);
        cq.select(from);

        cq.where(cb.equal(from.get(Education_.id), userId));
        final TypedQuery<IEducation> q = em.createQuery(cq);

        List<IEducation> resultList = q.getResultList();


        return resultList;
    }

    @Override
    public IEducation getFullInfo(Integer id) {
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();

        final CriteriaQuery<IEducation> cq = cb.createQuery(IEducation.class); // define returning result
        final Root<Education> from = cq.from(Education.class); // define table for select

        cq.select(from); // define what need to be selected

        from.fetch(Education_.speciality, JoinType.LEFT);
        from.fetch(Education_.degree, JoinType.LEFT);
        from.fetch(Education_.city, JoinType.LEFT);

        // .. where id=...
        cq.where(cb.equal(from.get(Education_.id), id)); // where id=?

        final TypedQuery<IEducation> q = em.createQuery(cq);

        return getSingleResult(q);
    }

    @Override
    public IEducation createEntity() {
        Education education = new Education();
        return education;
    }


}
