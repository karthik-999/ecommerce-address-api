package com.address.app.requests;

import lombok.Data;

@Data
public class CreateAddressDTO {

	String houseNumber;

	String streetAddress;

	String city;

	String state;

	String zipCode;

	Long account;
}
