package com.nexty.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nexty.backend.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}