package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.IAddress;
import com.itacademy.jd2.ml.linkedin.filter.AddressFilter;

import javax.transaction.Transactional;
import java.util.List;

public interface IAddressService {
    IAddress createEntity();

    @Transactional
    void save(IAddress entity);

    IAddress get(Integer id);

    @Transactional
    void delete(Integer id);

    @Transactional
    void deleteAll();

    List<IAddress> getAll();

    List<IAddress> find(AddressFilter filter);
}
