package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.Group;
import com.itacademy.jd2.ml.linkedin.entity.Skill;
import com.itacademy.jd2.ml.linkedin.entity.UserPortfolio;
import com.itacademy.jd2.ml.linkedin.entity.table.IGroup;
import com.itacademy.jd2.ml.linkedin.entity.table.ISkill;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserPortfolio;
import com.itacademy.jd2.ml.linkedin.filter.SkillFilter;
import com.itacademy.jd2.ml.linkedin.util.PreparedStatementAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Set;

@Repository
public class SkillDaoImpl extends AbstractDaoImpl<ISkill, Integer> implements ISkillDao {

    private IUserPortfolioDao userPortfolioDao;
    private IGroupDao groupDao;

    @Autowired
    public SkillDaoImpl(IUserPortfolioDao userPortfolioDao, IGroupDao groupDao) {
        userPortfolioDao = userPortfolioDao;
        this.groupDao = groupDao;
    }

    @Override
    protected String getTableName() {
        return "skill";
    }

    @Override
    public ISkill createEntity() {
        return new Skill();
    }

    @Override
    public void insert(ISkill entity) {
        executeStatement(new PreparedStatementAction<ISkill>(
                String.format("insert into %s (name, user_id, group_id, created, updated) values(?,?,?,?,?)", getTableName()), true) {
            @Override
            public ISkill doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
                pStmt.setString(1, entity.getName());
                pStmt.setInt(2, entity.getUserPortfolio().getId());
                pStmt.setInt(3, entity.getGroup().getId());
                pStmt.setObject(4, entity.getCreated(), Types.TIMESTAMP);
                pStmt.setObject(5, entity.getUpdated(), Types.TIMESTAMP);

                pStmt.executeUpdate();

                final ResultSet rs = pStmt.getGeneratedKeys();
                rs.next();
                final int id = rs.getInt("id");

                rs.close();

                entity.setId(id);
                return entity;
            }
        });
    }

    @Override
    public void update(final ISkill entity) {
        executeStatement(new PreparedStatementAction<ISkill>(String
                .format("update %s set name=?, user_id=?, group_id=?, updated=? where id=?", getTableName())) {
            @Override
            public ISkill doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
                pStmt.setString(1, entity.getName());
                pStmt.setInt(2, entity.getUserPortfolio().getId());
                pStmt.setInt(3, entity.getGroup().getId());
                pStmt.setObject(4, entity.getUpdated(), Types.TIMESTAMP);
                pStmt.setInt(5, entity.getId());

                pStmt.executeUpdate();
                return entity;
            }
        });
    }

    @Override
    protected ISkill parseRow(final ResultSet resultSet, final Set<String> columns) throws SQLException {

        final ISkill entity = createEntity();
        entity.setId((Integer) resultSet.getObject("id"));
        entity.setName(resultSet.getString("name"));
        entity.setCreated(resultSet.getTimestamp("created"));
        entity.setUpdated(resultSet.getTimestamp("updated"));

        final IUserPortfolio userPortfolio = new UserPortfolio();
        userPortfolio.setId((Integer) resultSet.getObject("user_id"));
        entity.setUserPortfolio(userPortfolio);

        final IGroup group = new Group();
        group.setId((Integer) resultSet.getObject("group_id"));
        entity.setGroup(group);

        return entity;
    }

    @Override
    public long getCount(final SkillFilter filter) {
        return executeCountQuery("");
    }

    @Override
    public ISkill getFullInfo(final Integer id) {
        final ISkill course = get(id);

        if (course.getUserPortfolio() != null) {
            course.setUserPortfolio(userPortfolioDao.get(course.getUserPortfolio().getId()));
        }

        if (course.getGroup() != null) {
            course.setGroup(groupDao.get(course.getGroup().getId()));
        }

        return course;
    }
    
}
