package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.Company;
import com.itacademy.jd2.ml.linkedin.entity.table.ICompany;
import com.itacademy.jd2.ml.linkedin.filter.CompanyFilter;
import com.itacademy.jd2.ml.linkedin.util.PreparedStatementAction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

public class CompanyDaoImpl extends AbstractDaoImpl<ICompany, Integer> implements ICompanyDao {

    @Override
    protected String getTableName() {
        return "company";
    }

    @Override
    public List<ICompany> find(CompanyFilter filter) {
        final StringBuilder sqlTile = new StringBuilder("");
        appendSort(filter, sqlTile);
        appendPaging(filter, sqlTile);
        return executeFindQuery(sqlTile.toString());
    }

    @Override
    public long getCount(CompanyFilter filter) {
        return executeCountQuery("");
    }

    @Override
    public ICompany createEntity() {
        return new Company();
    }

    @Override
    public void update(ICompany entity) {
        executeStatement(new PreparedStatementAction<ICompany>(
                String.format("update %s set name=?, updated=? where id=?", getTableName())) {
            @Override
            public ICompany doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
                pStmt.setString(1, entity.getName());
                pStmt.setObject(2, entity.getUpdated(), Types.TIMESTAMP);
                pStmt.setInt(3, entity.getId());

                pStmt.executeUpdate();
                return entity;
            }
        });
    }

    @Override
    public void insert(ICompany entity) {
        executeStatement(new PreparedStatementAction<ICompany>(
                String.format("insert into %s (name, created, updated) values(?,?,?)", getTableName()), true) {
            @Override
            public ICompany doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
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
    protected ICompany parseRow(final ResultSet resultSet) throws SQLException {
        final ICompany entity = createEntity();
        entity.setId((Integer) resultSet.getObject("id"));
        entity.setName(resultSet.getString("name"));
        entity.setCreated(resultSet.getTimestamp("created"));
        entity.setUpdated(resultSet.getTimestamp("updated"));
        return entity;
    }
}
