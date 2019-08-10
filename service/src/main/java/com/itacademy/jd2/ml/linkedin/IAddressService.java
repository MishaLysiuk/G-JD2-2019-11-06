package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.IAddress;
import com.itacademy.jd2.ml.linkedin.filter.AddressFilter;

import java.util.List;

public interface IAddressService {
    IAddress createEntity();

    void save(IAddress entity);

    IAddress get(Integer id);

    void delete(Integer id);

    void deleteAll();

    List<IAddress> getAll();

    List<IAddress> find(AddressFilter filter);
}
