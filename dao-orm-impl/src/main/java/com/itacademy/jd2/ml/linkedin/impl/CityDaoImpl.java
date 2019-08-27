package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.ICityDao;
import com.itacademy.jd2.ml.linkedin.entity.table.ICity;
import com.itacademy.jd2.ml.linkedin.entity.table.ICountry;
import com.itacademy.jd2.ml.linkedin.filter.CityFilter;
import com.itacademy.jd2.ml.linkedin.impl.entity.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CityDaoImpl extends AbstractDaoImpl<ICity,Integer> implements ICityDao {

    protected CityDaoImpl() {
        super(City.class);
    }

    @Override
    public List<ICity> find(CityFilter filter) {
        return null;
    }

    @Override
    public ICity createEntity() {
        City city = new City();
        return city;
    }

    @Override
    public List<ICountry> findCountryByRegionId(Integer regionId){
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<ICountry> cq = cb.createQuery(ICountry.class);
        final Root<Country> from = cq.from(Country.class);
        cq.select(from);

        cq.where(cb.equal(from.get(Country_.region).get(Region_.id), regionId));
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

        cq.where(cb.equal(from.get(City_.country).get(Country_.id), countryId));
        final TypedQuery<ICity> q = em.createQuery(cq);

        List<ICity> resultList = q.getResultList();
        return resultList;
    }
}
