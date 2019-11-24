package com.dzkj.service;

import java.util.List;

import com.dzkj.pojo.Address;

public interface IAddressService {
   List<Address> checkByUserid(Address address);
   boolean add(Address address);
   boolean update(Address address);
   boolean del(Address address);
   Address findbyid(Integer address);
}
