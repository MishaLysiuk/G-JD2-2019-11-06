package com.itacademy.jd2.ml.linkedin;


import com.itacademy.jd2.ml.linkedin.entity.table.IUserAccount;
import com.itacademy.jd2.ml.linkedin.filter.UserAccountFilter;

import javax.transaction.Transactional;
import java.util.Arrays;
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

    @Transactional
    List<IUserAccount> search(String text);

    List<IUserAccount> find(UserAccountFilter filter);

    long getCount(UserAccountFilter filter);

    IUserAccount getFullInfo(Integer id);

    IUserAccount getUserEducations(Integer id);

    IUserAccount findByEmail(String email);

    IUserAccount getUserCourses(Integer id);

    boolean checkPassword(String userPassword, String oldPassword, String newPassword, String confirmPassword);

    @Transactional
    List<IUserAccount> searchByJobTitle(String jobTitle);
}
