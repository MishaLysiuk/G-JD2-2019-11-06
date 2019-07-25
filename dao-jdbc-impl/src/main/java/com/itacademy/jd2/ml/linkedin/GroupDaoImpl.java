package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.Group;
import com.itacademy.jd2.ml.linkedin.entity.table.IGroup;
import com.itacademy.jd2.ml.linkedin.filter.GroupFilter;
import com.itacademy.jd2.ml.linkedin.util.PreparedStatementAction;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class GroupDaoImpl extends AbstractDaoImpl<IGroup, Integer> implements IGroupDao{
    @Override
    protected String getTableName() {
        return "user_portfolio";
    }

    @Override
    public IGroup createEntity() {
        return new Group();
    }




    @Override
    public void insert(IGroup entity) {

        executeStatement(new PreparedStatementAction<IGroup>(
                String.format("insert into %s (name, created, updated) values(?,?,?)", getTableName()), true) {
            @Override
            public IGroup doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
                pStmt.setString(1, entity.getName());
                pStmt.setObject(2, entity.getCreated(), Types.TIMESTAMP);
                pStmt.setObject(3, entity.getUpdated(), Types.TIMESTAMP);

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
    public void update(IGroup entity) {
        executeStatement(new PreparedStatementAction<IGroup>(
                String.format("update %s set name=?, updated=? where id=?", getTableName())) {
            @Override
            public IGroup doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
                pStmt.setString(1, entity.getName());
                pStmt.setObject(2, entity.getUpdated(), Types.TIMESTAMP);
                pStmt.setInt(3, entity.getId());

                pStmt.executeUpdate();
                return entity;
            }
        });
    }


    @Override
    public List<IGroup> find(GroupFilter filter) {
        final StringBuilder sqlTile = new StringBuilder("");
        appendSort(filter, sqlTile);
        appendPaging(filter, sqlTile);
        return executeFindQuery(sqlTile.toString());
    }

    @Override
    public long getCount(GroupFilter filter) {
        return executeCountQuery("");
    }

    @Override
    protected IGroup parseRow(final ResultSet resultSet) throws SQLException {
        final IGroup entity = createEntity();
        entity.setId((Integer) resultSet.getObject("id"));
        entity.setName(resultSet.getString("name"));
        entity.setCreated(resultSet.getTimestamp("created"));
        entity.setUpdated(resultSet.getTimestamp("updated"));
        return entity;
    }
}
