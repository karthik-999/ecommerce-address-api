package com.address.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.address.app.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {



}
