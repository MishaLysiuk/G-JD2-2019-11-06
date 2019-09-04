package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.IDegreeDao;
import com.itacademy.jd2.ml.linkedin.entity.table.IDegree;
import com.itacademy.jd2.ml.linkedin.filter.DegreeFilter;
import com.itacademy.jd2.ml.linkedin.impl.AbstractDaoImpl;
import com.itacademy.jd2.ml.linkedin.impl.entity.Degree;
import com.itacademy.jd2.ml.linkedin.impl.entity.Degree_;
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
public class DegreeDaoImpl extends AbstractDaoImpl<IDegree, Integer> implements IDegreeDao {

    protected DegreeDaoImpl() {
        super(Degree.class);
    }

    @Override
    public List<IDegree> find(DegreeFilter filter) {
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();

        final CriteriaQuery<IDegree> cq = cb.createQuery(IDegree.class);

        final Root<Degree> from = cq.from(Degree.class);// select from Degree
        cq.select(from); // select what? select *

        if (filter.getSortColumn() != null) {
            final SingularAttribute<? super Degree, ?> sortProperty = toMetamodelFormat(
                    filter.getSortColumn());
            final Path<?> expression = from.get(sortProperty); // build path to

            cq.orderBy(new OrderImpl(expression, filter.getSortOrder())); // order

        }

        final TypedQuery<IDegree> q = em.createQuery(cq);
        setPaging(filter, q);

        return q.getResultList();
    }

    private SingularAttribute<? super Degree, ?> toMetamodelFormat(
            final String sortColumn) {
        switch (sortColumn) {
            case "created":
                return Degree_.created;
            case "updated":
                return Degree_.updated;
            case "id":
                return Degree_.id;
            case "name":
                return Degree_.name;
            default:
                throw new UnsupportedOperationException(
                        "sorting is not supported by column:" + sortColumn);
        }
    }

    @Override
    public long getCount(DegreeFilter filter) {
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();

        final CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        final Root<Degree> from = cq.from(Degree.class); // select from Degree
        cq.select(cb.count(from)); // select what? select count(*)
        final TypedQuery<Long> q = em.createQuery(cq);
        return q.getSingleResult(); // execute query
    }

    @Override
    public IDegree createEntity() {
        Degree degree = new Degree();
        return degree;
    }
}
