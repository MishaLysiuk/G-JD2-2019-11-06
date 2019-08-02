package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.IUserAccountDao;
import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;
import com.itacademy.jd2.ml.linkedin.filter.UserAccountFilter;
import com.itacademy.jd2.ml.linkedin.impl.entity.UserAccount;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserAccountDaoImpl extends AbstractDaoImpl<IUserAccount,Integer> implements IUserAccountDao {

    protected UserAccountDaoImpl() {
        super(UserAccount.class);
    }

    @Override
    public List<IUserAccount> find(UserAccountFilter filter) {
        return null;
    }

    @Override
    public long getCount(UserAccountFilter filter) {
        return 0;
    }

    @Override
    public IUserAccount findByEmail(String username) {
        return null;
    }

    @Override
    public IUserAccount createEntity() {
        UserAccount userAccount = new UserAccount();
        return userAccount;
    }
}
