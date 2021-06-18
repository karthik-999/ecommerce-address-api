package com.address.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.address.app.IAccountService;
import com.address.app.entities.Account;
import com.address.app.entities.Address;
import com.address.app.repositories.AddressRepository;
import com.address.app.requests.CreateAddressDTO;
import com.address.app.service.interfaces.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	IAccountService accountService;

	@Override
	public List<Address> findAll(Pageable pageable) {

		return addressRepository.findAll(pageable).getContent();

	}

	@Override
	public Address getAddress(Long addressId) {
		Optional<Address> optionalAddress = addressRepository.findById(addressId);
		if (optionalAddress.isPresent()) {
			return optionalAddress.get();
		}
		return new Address();

	}

	@Override
	public Address saveAddress(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public Address saveAddress(CreateAddressDTO addressDTO) {
		Address address = new Address();
		if(!(addressDTO != null && addressDTO.getAccount()!= null)) {
			throw new RuntimeException("check Request values");
		}
		
		Account account = accountService.getAccount(addressDTO.getAccount()).getBody();
		if(!(account != null)) {
			throw new RuntimeException("check Account Details: Account not Exists");
		}
		address.setAccount(account);
		BeanUtils.copyProperties(addressDTO, address,"account");
		return addressRepository.save(address);
	}
}
