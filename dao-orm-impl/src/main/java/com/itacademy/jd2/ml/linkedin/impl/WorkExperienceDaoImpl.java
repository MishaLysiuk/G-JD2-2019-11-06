package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.IWorkExperienceDao;
import com.itacademy.jd2.ml.linkedin.entity.table.IWorkExperience;
import com.itacademy.jd2.ml.linkedin.filter.WorkExperienceFilter;
import com.itacademy.jd2.ml.linkedin.impl.entity.WorkExperience;
import com.itacademy.jd2.ml.linkedin.impl.entity.WorkExperience_;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class WorkExperienceDaoImpl extends AbstractDaoImpl<IWorkExperience,Integer> implements IWorkExperienceDao {
    protected WorkExperienceDaoImpl() {
        super(WorkExperience.class);
    }

    @Override
    public List<IWorkExperience> find(WorkExperienceFilter filter) {
        return null;
    }

    @Override
    public IWorkExperience getFullInfo(Integer id) {
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();

        final CriteriaQuery<IWorkExperience> cq = cb.createQuery(IWorkExperience.class); // define returning result
        final Root<WorkExperience> from = cq.from(WorkExperience.class); // define table for select

        cq.select(from); // define what need to be selected

        from.fetch(WorkExperience_.city, JoinType.LEFT);
        from.fetch(WorkExperience_.company, JoinType.LEFT);

        // .. where id=...
        cq.where(cb.equal(from.get(WorkExperience_.id), id)); // where id=?

        final TypedQuery<IWorkExperience> q = em.createQuery(cq);

        return getSingleResult(q);
    }

    @Override
    public IWorkExperience createEntity() {
        WorkExperience workExperience = new WorkExperience();
        return workExperience;
    }
}
