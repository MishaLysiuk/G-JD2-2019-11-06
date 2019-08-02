package com.itacademy.jd2.ml.linkedin.impl;

import com.itacademy.jd2.ml.linkedin.IAddressDao;
import com.itacademy.jd2.ml.linkedin.entity.table.IAddress;
import com.itacademy.jd2.ml.linkedin.filter.AddressFilter;
import com.itacademy.jd2.ml.linkedin.impl.entity.Address;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressDaoImpl extends AbstractDaoImpl<IAddress,Integer> implements IAddressDao {

    protected AddressDaoImpl() {
        super(Address.class);
    }

    @Override
    public List<IAddress> find(AddressFilter filter) {
        return null;
    }

    @Override
    public IAddress createEntity() {
        Address address = new Address();
        return address;
    }
}
