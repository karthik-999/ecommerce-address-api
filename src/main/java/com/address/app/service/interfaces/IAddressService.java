package com.address.app.service.interfaces;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.address.app.entities.Address;
import com.address.app.requests.CreateAddressDTO;

public interface IAddressService {

	public List<Address> findAll(Pageable pageable);

	public Address getAddress(Long AddressId);

	public Address saveAddress(CreateAddressDTO address);

	Address saveAddress(Address address);

}
