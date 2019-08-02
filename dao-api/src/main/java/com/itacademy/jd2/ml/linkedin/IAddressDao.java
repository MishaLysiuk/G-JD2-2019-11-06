package com.itacademy.jd2.ml.linkedin;

import com.itacademy.jd2.ml.linkedin.entity.table.IAddress;
import com.itacademy.jd2.ml.linkedin.filter.AddressFilter;

import java.util.List;

public interface IAddressDao extends IDao<IAddress, Integer> {

    List<IAddress> find(AddressFilter filter);

}
