package com.address.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.address.app.entities.Address;
import com.address.app.requests.CreateAddressDTO;
import com.address.app.service.interfaces.IAddressService;

@RestController
@RequestMapping("/address/")
public class AddressController {

	@Autowired
	IAddressService addressService;

	@GetMapping("/all/{page}/{size}")
	public ResponseEntity<List<Address>> getAddresssByPage(@PathVariable(value = "page", required = true) int page,
			@PathVariable(value = "size", required = true) int size) {
		Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
		List<Address> addresses = addressService.findAll(pageable);
		return new ResponseEntity<>(addresses, HttpStatus.OK);
	}

	@GetMapping("/get/{AddressId}")
	public ResponseEntity<Address> getAddress(@PathVariable("AddressId") Long AddressId) {
		return new ResponseEntity<>(addressService.getAddress(AddressId), HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<Address> saveAddress(@RequestBody CreateAddressDTO address) {
		return new ResponseEntity<>(addressService.saveAddress(address), HttpStatus.CREATED);
	}
}
