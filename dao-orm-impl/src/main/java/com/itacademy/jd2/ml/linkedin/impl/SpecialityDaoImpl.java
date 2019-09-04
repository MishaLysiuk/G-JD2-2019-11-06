package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.ISpecialityDao;
import com.itacademy.jd2.ml.linkedin.entity.table.ISpeciality;
import com.itacademy.jd2.ml.linkedin.filter.SpecialityFilter;
import com.itacademy.jd2.ml.linkedin.impl.entity.Speciality;
import com.itacademy.jd2.ml.linkedin.impl.entity.Speciality_;
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
public class SpecialityDaoImpl extends AbstractDaoImpl<ISpeciality, Integer> implements ISpecialityDao {

    protected SpecialityDaoImpl() {
        super(Speciality.class);
    }

    @Override
    public List<ISpeciality> find(SpecialityFilter filter) {
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();

        final CriteriaQuery<ISpeciality> cq = cb.createQuery(ISpeciality.class);

        final Root<Speciality> from = cq.from(Speciality.class);// select from Speciality
        cq.select(from); // select what? select *

        if (filter.getSortColumn() != null) {
            final SingularAttribute<? super Speciality, ?> sortProperty = toMetamodelFormat(
                    filter.getSortColumn());
            final Path<?> expression = from.get(sortProperty); // build path to

            cq.orderBy(new OrderImpl(expression, filter.getSortOrder())); // order

        }

        final TypedQuery<ISpeciality> q = em.createQuery(cq);
        setPaging(filter, q);

        return q.getResultList();
    }

    private SingularAttribute<? super Speciality, ?> toMetamodelFormat(
            final String sortColumn) {
        switch (sortColumn) {
            case "created":
                return Speciality_.created;
            case "updated":
                return Speciality_.updated;
            case "id":
                return Speciality_.id;
            case "name":
                return Speciality_.name;
            default:
                throw new UnsupportedOperationException(
                        "sorting is not supported by column:" + sortColumn);
        }
    }

    @Override
    public long getCount(SpecialityFilter filter) {
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();

        final CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        final Root<Speciality> from = cq.from(Speciality.class); // select from Speciality
        cq.select(cb.count(from)); // select what? select count(*)
        final TypedQuery<Long> q = em.createQuery(cq);
        return q.getSingleResult(); // execute query
    }

    @Override
    public ISpeciality createEntity() {
        Speciality speciality = new Speciality();
        return speciality;
    }
}
