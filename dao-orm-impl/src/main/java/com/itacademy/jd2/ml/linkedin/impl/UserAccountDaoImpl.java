package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.IUserAccountDao;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;
import com.itacademy.jd2.ml.linkedin.filter.UserAccountFilter;
import com.itacademy.jd2.ml.linkedin.impl.entity.UserAccount;
import com.itacademy.jd2.ml.linkedin.impl.entity.UserAccount_;
import org.hibernate.jpa.criteria.OrderImpl;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.SingularAttribute;
import java.rmi.UnexpectedException;
import java.util.List;

@Repository
public class UserAccountDaoImpl extends AbstractDaoImpl<IUserAccount, Integer> implements IUserAccountDao {

    protected UserAccountDaoImpl() {
        super(UserAccount.class);
    }

    @Override
    public List<IUserAccount> find(UserAccountFilter filter) {
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<IUserAccount> cq = cb.createQuery(IUserAccount.class);
        final Root<UserAccount> from = cq.from(UserAccount.class);
        cq.select(from);

        from.fetch(UserAccount_.motherTongue, JoinType.LEFT);

        if (filter.getSortColumn() != null) {
            final SingularAttribute<? super UserAccount, ?> sortProperty = toMetamodelFormat(
                    filter.getSortColumn());

            final Path<?> expression = from.get(sortProperty);
            cq.orderBy(new OrderImpl(expression, filter.getSortOrder()));
        }

        final TypedQuery<IUserAccount> q = em.createQuery(cq);
        setPaging(filter, q);
        return q.getResultList();
    }

    private SingularAttribute<? super UserAccount, ?> toMetamodelFormat(
            final String sortColumn) {
        switch (sortColumn) {
            case "created":
                return UserAccount_.created;
            case "updated":
                return UserAccount_.updated;
            case "id":
                return UserAccount_.id;
            case "firstName":
                return UserAccount_.firstName;
            case "lastName":
                return UserAccount_.lastName;
            default:
                throw new UnsupportedOperationException(
                        "sorting is not supported by column:" + sortColumn);
        }
    }

    @Override
    public long getCount(UserAccountFilter filter) {
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        final Root<UserAccount> from = cq.from(UserAccount.class);
        cq.select(cb.count(from));
        final TypedQuery<Long> q = em.createQuery(cq);
        return q.getSingleResult();
    }

    @Override
    public IUserAccount getFullInfo(final Integer id) {
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();

        final CriteriaQuery<IUserAccount> cq = cb.createQuery(IUserAccount.class); // define returning result
        final Root<UserAccount> from = cq.from(UserAccount.class); // define table for select

        cq.select(from); // define what need to be selected

        from.fetch(UserAccount_.motherTongue, JoinType.LEFT);
        from.fetch(UserAccount_.courses, JoinType.LEFT);
        from.fetch(UserAccount_.skills, JoinType.LEFT);
        from.fetch(UserAccount_.educations, JoinType.LEFT);
        from.fetch(UserAccount_.workExperiences, JoinType.LEFT);
        cq.distinct(true);

        // .. where id=...
        cq.where(cb.equal(from.get(UserAccount_.id), id)); // where id=?

        final TypedQuery<IUserAccount> q = em.createQuery(cq);

        return getSingleResult(q);
    }

    @Override
    public IUserAccount getUserCourses(Integer id) {
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();

        final CriteriaQuery<IUserAccount> cq = cb.createQuery(IUserAccount.class); // define returning result
        final Root<UserAccount> from = cq.from(UserAccount.class); // define table for select

        cq.select(from); // define what need to be selected

        from.fetch(UserAccount_.courses, JoinType.LEFT);
        cq.distinct(true);

        // .. where id=...
        cq.where(cb.equal(from.get(UserAccount_.id), id)); // where id=?

        final TypedQuery<IUserAccount> q = em.createQuery(cq);

        return getSingleResult(q);
    }

    @Override
    public List<IUserAccount> searchByJobTitle(String jobTitle) {
        EntityManager em = getEntityManager();
        FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);

        QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(UserAccount.class).get();
        org.apache.lucene.search.Query luceneQuery = qb.keyword().onFields("jobTitle").matching(jobTitle).createQuery();

        javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, UserAccount.class);

        return jpaQuery.getResultList();
    }

    @Override
    public IUserAccount getUserEducation(Integer id) {
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();

        final CriteriaQuery<IUserAccount> cq = cb.createQuery(IUserAccount.class); // define returning result
        final Root<UserAccount> from = cq.from(UserAccount.class); // define table for select

        cq.select(from); // define what need to be selected

        from.fetch(UserAccount_.courses, JoinType.LEFT);
        cq.distinct(true);

        // .. where id=...
        cq.where(cb.equal(from.get(UserAccount_.id), id)); // where id=?

        final TypedQuery<IUserAccount> q = em.createQuery(cq);

        return getSingleResult(q);
    }

    @Override
    public IUserAccount findByEmail(String email) {
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<IUserAccount> cq = cb.createQuery(IUserAccount.class);
        final Root<UserAccount> from = cq.from(UserAccount.class);
        cq.select(from);

        cq.where(cb.equal(from.get(UserAccount_.email), email));
        final TypedQuery<IUserAccount> q = em.createQuery(cq);

        List<IUserAccount> resultList = q.getResultList();
        if (resultList.isEmpty()) {
            return null;
        }
        if (resultList.size() == 1) {
            return resultList.get(0);
        }
        throw new RuntimeException("resultList > 1");
    }

    @Override
    public IUserAccount createEntity() {
        UserAccount userAccount = new UserAccount();
        return userAccount;
    }

    @Override
    public List<IUserAccount> search(String text) {

        EntityManager em = getEntityManager();
        FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);

        QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(UserAccount.class).get();
        org.apache.lucene.search.Query luceneQuery = qb.keyword().onFields("firstName").matching(text).createQuery();

        javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, UserAccount.class);

        return jpaQuery.getResultList();

    }

}
