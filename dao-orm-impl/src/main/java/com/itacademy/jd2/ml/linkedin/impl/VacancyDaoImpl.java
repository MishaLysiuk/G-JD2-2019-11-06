package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.IVacancyDao;
import com.itacademy.jd2.ml.linkedin.entity.table.IVacancy;
import com.itacademy.jd2.ml.linkedin.filter.VacancyFilter;
import com.itacademy.jd2.ml.linkedin.impl.entity.UserAccount_;
import com.itacademy.jd2.ml.linkedin.impl.entity.Vacancy;
import com.itacademy.jd2.ml.linkedin.impl.entity.Vacancy_;
import org.hibernate.jpa.criteria.OrderImpl;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.SingularAttribute;
import java.util.List;

@Repository
public class VacancyDaoImpl extends AbstractDaoImpl<IVacancy,Integer> implements IVacancyDao {

    protected VacancyDaoImpl() {
        super(Vacancy.class);
    }

    @Override
    public List<IVacancy> find(VacancyFilter filter) {
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<IVacancy> cq = cb.createQuery(IVacancy.class);
        final Root<Vacancy> from = cq.from(Vacancy.class);// select from Vacancy
        cq.select(from); // select what? select *

        if (filter.getSortColumn() != null) {
            final SingularAttribute<? super Vacancy, ?> sortProperty = toMetamodelFormat(
                    filter.getSortColumn());

            final Path<?> expression = from.get(sortProperty);
            cq.orderBy(new OrderImpl(expression, filter.getSortOrder()));
        }

        final TypedQuery<IVacancy> q = em.createQuery(cq);
        setPaging(filter, q);
        return q.getResultList();
    }

    @Override
    public List<IVacancy> findByCreatorId(Integer creatorId) {
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<IVacancy> cq = cb.createQuery(IVacancy.class);
        final Root<Vacancy> from = cq.from(Vacancy.class);
        cq.select(from);

        cq.where(cb.equal(from.get(Vacancy_.creator).get(UserAccount_.id), creatorId));
        final TypedQuery<IVacancy> q = em.createQuery(cq);

        List<IVacancy> resultList = q.getResultList();
        return resultList;
    }

    private SingularAttribute<? super Vacancy, ?> toMetamodelFormat(
            final String sortColumn) {
        switch (sortColumn) {
            case "company":
                return Vacancy_.company;
            case "id":
                return Vacancy_.id;
            case "jobTitle":
                return Vacancy_.jobTitle;
            case "address":
                return Vacancy_.address;
            case "contactInfo":
                return Vacancy_.contactInfo;
            default:
                throw new UnsupportedOperationException(
                        "sorting is not supported by column:" + sortColumn);
        }
    }

    @Override
    public long getCount(VacancyFilter filter) {
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        final Root<Vacancy> from = cq.from(Vacancy.class);
        cq.select(cb.count(from));
        final TypedQuery<Long> q = em.createQuery(cq);
        return q.getSingleResult();
    }

    @Override
    public IVacancy createEntity() {
        Vacancy vacancy = new Vacancy();
        return vacancy;
    }

    @Override
    public IVacancy getFullInfo(final Integer id) {
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();

        final CriteriaQuery<IVacancy> cq = cb.createQuery(IVacancy.class); // define returning result
        final Root<Vacancy> from = cq.from(Vacancy.class); // define table for select

        cq.select(from); // define what need to be selected

        from.fetch(Vacancy_.creator, JoinType.LEFT);
        from.fetch(Vacancy_.company, JoinType.LEFT);
        from.fetch(Vacancy_.city, JoinType.LEFT);

        // .. where id=...
        cq.where(cb.equal(from.get(Vacancy_.id), id)); // where id=?

        final TypedQuery<IVacancy> q = em.createQuery(cq);

        return getSingleResult(q);
    }
}
