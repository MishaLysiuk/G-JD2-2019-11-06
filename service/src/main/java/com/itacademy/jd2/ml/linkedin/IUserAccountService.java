package com.itacademy.jd2.ml.linkedin;


import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;
import com.itacademy.jd2.ml.linkedin.filter.UserAccountFilter;

import java.util.List;

public interface IUserAccountService {
    IUserAccount get(Integer id);

    List<IUserAccount> getAll();

    void save(IUserAccount entity);

    void save(IUserAccount... entities);

    void delete(Integer id);

    void deleteAll();

    IUserAccount createEntity();

    List<IUserAccount> find(UserAccountFilter filter);

    long getCount(UserAccountFilter filter);

    IUserAccount findByEmail(String email);
}
