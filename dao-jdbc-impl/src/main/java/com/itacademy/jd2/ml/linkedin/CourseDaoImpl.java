package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.Company;
import com.itacademy.jd2.ml.linkedin.entity.Course;
import com.itacademy.jd2.ml.linkedin.entity.UserPortfolio;
import com.itacademy.jd2.ml.linkedin.entity.table.ICompany;
import com.itacademy.jd2.ml.linkedin.entity.table.ICourse;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserPortfolio;
import com.itacademy.jd2.ml.linkedin.filter.CourseFilter;
import com.itacademy.jd2.ml.linkedin.util.PreparedStatementAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Repository
public class CourseDaoImpl extends AbstractDaoImpl<ICourse, Integer> implements ICourseDao {

    private IUserPortfolioDao userPortfolioDao;
    private ICompanyDao companyDao;

    @Autowired
    public CourseDaoImpl(IUserPortfolioDao userPortfolioDao, ICompanyDao companyDao) {
        this.userPortfolioDao = userPortfolioDao;
        this.companyDao = companyDao;
    }

    @Override
    protected String getTableName() {
        return "course";
    }

    @Override
    public ICourse createEntity() {
        return new Course();
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

    @Override
    public void update(final ICourse entity) {
        executeStatement(new PreparedStatementAction<ICourse>(String
                .format("update %s set user_id=?, name=?, company_id=?, start=?, end=?,final_result=?, updated=? where id=?", getTableName())) {
            @Override
            public ICourse doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
                pStmt.setInt(1, entity.getUserPortfolio().getId());
                pStmt.setString(2, entity.getName());
                pStmt.setInt(3, entity.getCompany().getId());
                pStmt.setObject(4, entity.getStart(), Types.TIMESTAMP);
                pStmt.setObject(5, entity.getEnd(), Types.TIMESTAMP);
                pStmt.setInt(6, entity.getFinalResult());
                pStmt.setObject(7, entity.getUpdated(), Types.TIMESTAMP);
                pStmt.setInt(8, entity.getId());

                pStmt.executeUpdate();
                return entity;
            }
        });

    }

    @Override
    protected ICourse parseRow(final ResultSet resultSet, final Set<String> columns) throws SQLException {

        final ICourse entity = createEntity();
        entity.setId((Integer) resultSet.getObject("id"));
        entity.setName(resultSet.getString("name"));
        entity.setStart(resultSet.getTimestamp("start"));
        entity.setEnd(resultSet.getTimestamp("end"));
        entity.setFinalResult((Integer) resultSet.getObject("final_result"));
        entity.setCreated(resultSet.getTimestamp("created"));
        entity.setUpdated(resultSet.getTimestamp("updated"));

        final IUserPortfolio userPortfolio = new UserPortfolio();
        userPortfolio.setId((Integer) resultSet.getObject("user_id"));
        entity.setUserPortfolio(userPortfolio);

        final ICompany company = new Company();
        company.setId((Integer) resultSet.getObject("company_id"));
        entity.setCompany(company);

        return entity;

    }

    @Override
    public List<ICourse> find(final CourseFilter filter) {
        final StringBuilder sql = new StringBuilder("");
        appendWHEREs(filter, sql);
        appendSort(filter, sql);
        appendPaging(filter, sql);
        return executeFindQuery(sql.toString());
    }

    @Override
    public long getCount(final CourseFilter filter) {
        return executeCountQuery("");
    }

    @Override
    public ICourse getFullInfo(final Integer id) {
        final ICourse course = get(id);

        if (course.getUserPortfolio() != null) {
            course.setUserPortfolio(userPortfolioDao.get(course.getUserPortfolio().getId()));
        }

        if (course.getCompany() != null) {
            course.setCompany(companyDao.get(course.getCompany().getId()));
        }

        return course;
    }


    private void appendWHEREs(final CourseFilter filter, final StringBuilder sb) {
        final List<String> ands = new ArrayList<String>();
        if (!StringUtils.isEmpty(filter.getName())) {
            ands.add(String.format("vin like '%%%s%%'", filter.getName()));
        }

        final Iterator<String> andsIter = ands.iterator();
        if (andsIter.hasNext()) {
            final String firtsCondition = andsIter.next();

            sb.append(String.format("where %s", firtsCondition));

            while (andsIter.hasNext()) {
                final String condition = andsIter.next();
                sb.append(String.format(" and %s", condition));
            }
        }
    }


}
