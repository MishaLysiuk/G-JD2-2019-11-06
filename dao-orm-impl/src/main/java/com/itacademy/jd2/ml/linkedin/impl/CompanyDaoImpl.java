package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.ICompanyDao;
import com.itacademy.jd2.ml.linkedin.entity.table.ICompany;
import com.itacademy.jd2.ml.linkedin.filter.CompanyFilter;
import com.itacademy.jd2.ml.linkedin.impl.entity.Company;
import com.itacademy.jd2.ml.linkedin.impl.entity.Company_;
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
public class CompanyDaoImpl extends AbstractDaoImpl<ICompany, Integer> implements ICompanyDao {

    protected CompanyDaoImpl() {
        super(Company.class);
    }

    @Override
    public List<ICompany> find(CompanyFilter filter) {
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();

        final CriteriaQuery<ICompany> cq = cb.createQuery(ICompany.class);

        final Root<Company> from = cq.from(Company.class);// select from Company
        cq.select(from); // select what? select *

        if (filter.getSortColumn() != null) {
            final SingularAttribute<? super Company, ?> sortProperty = toMetamodelFormat(
                    filter.getSortColumn());
            final Path<?> expression = from.get(sortProperty); // build path to

            cq.orderBy(new OrderImpl(expression, filter.getSortOrder())); // order

        }

        final TypedQuery<ICompany> q = em.createQuery(cq);
        setPaging(filter, q);

        return q.getResultList();
    }

    private SingularAttribute<? super Company, ?> toMetamodelFormat(
            final String sortColumn) {
        switch (sortColumn) {
            case "created":
                return Company_.created;
            case "updated":
                return Company_.updated;
            case "id":
                return Company_.id;
            case "name":
                return Company_.name;
            default:
                throw new UnsupportedOperationException(
                        "sorting is not supported by column:" + sortColumn);
        }
    }

    @Override
    public long getCount(CompanyFilter filter) {
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();

        final CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        final Root<Company> from = cq.from(Company.class); // select from Company
        cq.select(cb.count(from)); // select what? select count(*)
        final TypedQuery<Long> q = em.createQuery(cq);
        return q.getSingleResult(); // execute query
    }

    @Override
    public List<ICompany> findByName(String name) {
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<ICompany> cq = cb.createQuery(ICompany.class);
        final Root<Company> from = cq.from(Company.class);
        cq.select(from);

        cq.where(cb.like(cb.lower(from.get(Company_.name)), "%" + name.toLowerCase() + "%"));
        final TypedQuery<ICompany> q = em.createQuery(cq);

        List<ICompany> resultList = q.getResultList();

        return resultList;
    }

    @Override
    public ICompany createEntity() {
        Company company = new Company();
        return company;
    }
}
