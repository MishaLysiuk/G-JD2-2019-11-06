package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.ISkillDao;
import com.itacademy.jd2.ml.linkedin.entity.table.ISkill;
import com.itacademy.jd2.ml.linkedin.filter.SkillFilter;
import com.itacademy.jd2.ml.linkedin.impl.entity.Skill;
import com.itacademy.jd2.ml.linkedin.impl.entity.Skill_;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

@Repository
public class SkillDaoImpl extends AbstractDaoImpl<ISkill,Integer> implements ISkillDao {

    protected SkillDaoImpl() {
        super(Skill.class);
    }

    @Override
    public long getCount(SkillFilter filter) {
        return 0;
    }

    @Override
    public ISkill getFullInfo(Integer id) {
        final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();

        final CriteriaQuery<ISkill> cq = cb.createQuery(ISkill.class); // define returning result
        final Root<Skill> from = cq.from(Skill.class); // define table for select

        cq.select(from); // define what need to be selected

        from.fetch(Skill_.group, JoinType.LEFT);

        from.fetch(Skill_.users, JoinType.LEFT);
        cq.distinct(true); // to avoid duplicate rows in result

        // .. where id=...
        cq.where(cb.equal(from.get(Skill_.id), id)); // where id=?

        final TypedQuery<ISkill> q = em.createQuery(cq);

        return getSingleResult(q);
    }

    @Override
    public ISkill createEntity() {
        Skill skill = new Skill();
        return skill;
    }
}
