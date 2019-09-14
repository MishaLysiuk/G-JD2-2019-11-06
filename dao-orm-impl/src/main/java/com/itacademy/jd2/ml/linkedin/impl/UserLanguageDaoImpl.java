package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.IUserLanguageDao;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserLanguage;
import com.itacademy.jd2.ml.linkedin.filter.UserLanguageFilter;
import com.itacademy.jd2.ml.linkedin.impl.entity.UserAccount_;
import com.itacademy.jd2.ml.linkedin.impl.entity.UserLanguage;
import com.itacademy.jd2.ml.linkedin.impl.entity.UserLanguage_;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserLanguageDaoImpl extends AbstractDaoImpl<IUserLanguage,Integer> implements IUserLanguageDao {
    protected UserLanguageDaoImpl() {
        super(UserLanguage.class);
    }

    @Override
    public List<IUserLanguage> find(UserLanguageFilter filter) {
        return null;
    }

    @Override
    public List<IUserLanguage> findByUserId(Integer loggedUserId) {
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<IUserLanguage> cq = cb.createQuery(IUserLanguage.class);
        final Root<UserLanguage> from = cq.from(UserLanguage.class);
        cq.select(from);
        from.fetch(UserLanguage_.level, JoinType.LEFT);
        from.fetch(UserLanguage_.language, JoinType.LEFT);

        cq.where(cb.equal(from.get(UserLanguage_.user).get(UserAccount_.id), loggedUserId));
        final TypedQuery<IUserLanguage> q = em.createQuery(cq);

        List<IUserLanguage> resultList = q.getResultList();
        return resultList;
    }

    @Override
    public IUserLanguage getFullInfo(Integer id) {
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();

        final CriteriaQuery<IUserLanguage> cq = cb.createQuery(IUserLanguage.class); // define returning result
        final Root<UserLanguage> from = cq.from(UserLanguage.class); // define table for select

        cq.select(from); // define what need to be selected

        from.fetch(UserLanguage_.language, JoinType.LEFT);
        from.fetch(UserLanguage_.level, JoinType.LEFT);

        // .. where id=...
        cq.where(cb.equal(from.get(UserLanguage_.id), id)); // where id=?

        final TypedQuery<IUserLanguage> q = em.createQuery(cq);

        return getSingleResult(q);
    }

    @Override
    public IUserLanguage createEntity() {
        UserLanguage userLanguage = new UserLanguage();
        return userLanguage;
    }
}
