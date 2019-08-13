package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.IVacancyDao;
import com.itacademy.jd2.ml.linkedin.entity.table.IVacancy;
import com.itacademy.jd2.ml.linkedin.filter.VacancyFilter;
import com.itacademy.jd2.ml.linkedin.impl.entity.Vacancy;
import com.itacademy.jd2.ml.linkedin.impl.entity.Vacancy_;
import org.hibernate.jpa.criteria.OrderImpl;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
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

    private SingularAttribute<? super Vacancy, ?> toMetamodelFormat(
            final String sortColumn) {
        switch (sortColumn) {
            case "created":
                return Vacancy_.active;
            case "updated":
                return Vacancy_.company;
            case "id":
                return Vacancy_.id;
            case "industryId":
                return Vacancy_.industryId;
            case "positionId":
                return Vacancy_.positionId;
            case "address":
                return Vacancy_.address;
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
}
