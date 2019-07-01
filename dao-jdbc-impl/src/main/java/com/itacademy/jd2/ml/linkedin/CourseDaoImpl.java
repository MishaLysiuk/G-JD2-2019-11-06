package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.Course;
import com.itacademy.jd2.ml.linkedin.entity.table.ICourse;
import com.itacademy.jd2.ml.linkedin.filter.CourseFilter;
import com.itacademy.jd2.ml.linkedin.util.PreparedStatementAction;

import java.sql.*;
import java.util.List;

public class CourseDaoImpl extends AbstractDaoImpl<ICourse, Integer> implements ICourseDao {
    @Override
    protected String getTableName() {
        return "course";
    }

    @Override
    public List<ICourse> find(CourseFilter filter) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public long getCount(CourseFilter filter) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public ICourse createEntity() {
        return new Course();
    }

    @Override
    public void update(ICourse iCourse) {

    }

    @Override
    public void insert(ICourse entity) {
        executeStatement(new PreparedStatementAction<ICourse>(
                String.format("insert into %s (user_id, name, company_id, start, end, final_result, created, updated) values(?,?,?,?,?,?,?,?)", getTableName()), true) {
            @Override
            public ICourse doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
                pStmt.setInt(1, entity.getUserPortfolio().getId());
                pStmt.setString(2, entity.getName());
                pStmt.setInt(3, entity.getCompany().getId());
                pStmt.setObject(4, entity.getStart(), Types.TIMESTAMP);
                pStmt.setObject(5, entity.getEnd(), Types.TIMESTAMP);
                pStmt.setInt(6, entity.getFinalResult());
                pStmt.setObject(7, entity.getCreated(), Types.TIMESTAMP);
                pStmt.setObject(8, entity.getUpdated(), Types.TIMESTAMP);

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
}
