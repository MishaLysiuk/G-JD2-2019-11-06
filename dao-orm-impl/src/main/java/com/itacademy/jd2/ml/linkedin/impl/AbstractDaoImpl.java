package com.itacademy.jd2.ml.linkedin.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.itacademy.jd2.ml.linkedin.IDao;
import com.itacademy.jd2.ml.linkedin.entity.table.ICity;
import com.itacademy.jd2.ml.linkedin.entity.table.ICountry;
import com.itacademy.jd2.ml.linkedin.entity.table.IRegion;
import com.itacademy.jd2.ml.linkedin.filter.AbstractFilter;
import com.itacademy.jd2.ml.linkedin.impl.entity.City;
import com.itacademy.jd2.ml.linkedin.impl.entity.City_;
import com.itacademy.jd2.ml.linkedin.impl.entity.Country;
import com.itacademy.jd2.ml.linkedin.impl.entity.Country_;

public abstract class AbstractDaoImpl<T, ID> implements IDao<T, ID> {

    @PersistenceContext
    private EntityManager entityManager;

    private final Class<? extends T> entityClass;

    protected AbstractDaoImpl(final Class<? extends T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    @Deprecated
    public List<T> selectAll() {
        final CriteriaQuery<? extends T> query = entityManager.getCriteriaBuilder().createQuery(getEntityClass());
        query.from(getEntityClass());
        final List<? extends T> lst = entityManager.createQuery(query).getResultList();
        return (List<T>) lst;
    }

    @Override
    public T get(final ID id) {
        return entityManager.find(getEntityClass(), id);
    }

    @Override
    public void insert(final T entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(T entity) {
        entity = entityManager.merge(entity);
        entityManager.flush();
    }

    @Override
    public void delete(final ID id) {
        entityManager.createQuery(String.format("delete from %s e where e.id = :id", entityClass.getSimpleName()))
                .setParameter("id", id).executeUpdate();
    }

    @Override
    public void deleteAll() {
        entityManager.createQuery(String.format("delete from %s", entityClass.getSimpleName())).executeUpdate();

    }

    @Override
    public List<ICountry> findCountryByRegionId(Integer regionId){
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<ICountry> cq = cb.createQuery(ICountry.class);
        final Root<Country> from = cq.from(Country.class);
        cq.select(from);

        cq.where(cb.equal(from.get(Country_.region), regionId));
        final TypedQuery<ICountry> q = em.createQuery(cq);

        List<ICountry> resultList = q.getResultList();
        return resultList;
    }

    @Override
    public List<ICity> findCityByCountryId(Integer countryId){
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<ICity> cq = cb.createQuery(ICity.class);
        final Root<City> from = cq.from(City.class);
        cq.select(from);

        cq.where(cb.equal(from.get(City_.country), countryId));
        final TypedQuery<ICity> q = em.createQuery(cq);

        List<ICity> resultList = q.getResultList();
        return resultList;
    }

    public Class<? extends T> getEntityClass() {
        return entityClass;
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    protected void setPaging(final AbstractFilter filter, final TypedQuery<?> q) {
        if (filter.getOffset() != null) {
            q.setFirstResult(filter.getOffset());
        }

        if (filter.getLimit() != null) {
            q.setMaxResults(filter.getLimit());
        }
    }

    protected T getSingleResult(final TypedQuery<T> q) {
        final List<T> resultList = q.getResultList();
        final int size = resultList.size();
        if (size != 1) {
            throw new IllegalArgumentException("unexpected result count:" + size);
        }
        return resultList.get(0);
    }

}