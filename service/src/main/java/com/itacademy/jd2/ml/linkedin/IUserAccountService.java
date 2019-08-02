package com.itacademy.jd2.ml.linkedin;


import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;
import com.itacademy.jd2.ml.linkedin.filter.UserAccountFilter;

import javax.transaction.Transactional;
import java.util.List;

public interface IUserAccountService {
    IUserAccount get(Integer id);

    List<IUserAccount> getAll();

    @Transactional
    void save(IUserAccount entity);

    @Transactional
    void delete(Integer id);

    @Transactional
    void deleteAll();

    IUserAccount createEntity();

    List<IUserAccount> find(UserAccountFilter filter);

    long getCount(UserAccountFilter filter);

    IUserAccount findByEmail(String email);
}
