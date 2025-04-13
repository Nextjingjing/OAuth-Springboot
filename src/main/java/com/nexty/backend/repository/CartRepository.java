package com.nexty.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nexty.backend.entity.Cart;
import com.nexty.backend.entity.key.CartKey;

@Repository
public interface CartRepository extends JpaRepository<Cart, CartKey> {
}