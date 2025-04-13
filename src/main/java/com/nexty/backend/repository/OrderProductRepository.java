package com.nexty.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nexty.backend.entity.OrderProduct;
import com.nexty.backend.entity.key.OrderProductKey;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProductKey>{
}
