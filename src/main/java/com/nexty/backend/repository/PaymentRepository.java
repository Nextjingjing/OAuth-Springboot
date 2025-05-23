package com.nexty.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nexty.backend.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{
}
