package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;
import com.itacademy.jd2.ml.linkedin.filter.UserAccountFilter;

import java.util.List;

public interface IUserAccountDao extends IDao<IUserAccount, Integer> {


    List<IUserAccount> find(UserAccountFilter filter); // skip


    long getCount(UserAccountFilter filter); // skip

    IUserAccount findByEmail(String email);

    List<IUserAccount> search(String text);
}
