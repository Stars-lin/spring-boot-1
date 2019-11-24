package com.dzkj.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dzkj.mapper.IAddressMapper;
import com.dzkj.pojo.Address;
import com.dzkj.service.IAddressService;

@Service
@Transactional
public class AddressService implements IAddressService{

	@Autowired
	IAddressMapper addressmapper;
	
	@Override
	public List<Address> checkByUserid(Address address) {
		return addressmapper.select(address);
	}

	@Override
	public boolean add(Address address) {
		return addressmapper.insert(address)>0;
	}

	@Override
	public boolean update(Address address) {
		return addressmapper.updateByPrimaryKey(address)>0;
	}

	@Override
	public boolean del(Address address) {
		return addressmapper.deleteByPrimaryKey(address.getA_id())>0;
	}

	@Override
	public Address findbyid(Integer address) {
		return addressmapper.selectByPrimaryKey(address);
	}

}
