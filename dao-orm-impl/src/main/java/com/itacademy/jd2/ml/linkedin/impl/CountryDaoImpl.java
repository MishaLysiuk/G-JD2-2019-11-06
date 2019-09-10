package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.ICountryDao;
import com.itacademy.jd2.ml.linkedin.entity.table.ICountry;
import com.itacademy.jd2.ml.linkedin.filter.CountryFilter;
import com.itacademy.jd2.ml.linkedin.filter.CourseFilter;
import com.itacademy.jd2.ml.linkedin.impl.entity.Country;
import com.itacademy.jd2.ml.linkedin.impl.entity.Country_;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CountryDaoImpl extends AbstractDaoImpl<ICountry, Integer> implements ICountryDao {
    protected CountryDaoImpl() {
        super(Country.class);
    }

    @Override
    public List<ICountry> find(CountryFilter filter) {
        return null;
    }

    @Override
    public ICountry getFullInfo(final Integer id) {
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();

        final CriteriaQuery<ICountry> cq = cb.createQuery(ICountry.class); // define returning result
        final Root<Country> from = cq.from(Country.class); // define table for select

        cq.select(from); // define what need to be selected

        from.fetch(Country_.region, JoinType.LEFT);

        // .. where id=...
        cq.where(cb.equal(from.get(Country_.id), id)); // where id=?

        final TypedQuery<ICountry> q = em.createQuery(cq);

        return getSingleResult(q);
    }

    @Override
    public ICountry createEntity() {
        Country country = new Country();
        return country;
    }
}
