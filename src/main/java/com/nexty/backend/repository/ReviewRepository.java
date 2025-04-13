package com.nexty.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nexty.backend.entity.Review;
import com.nexty.backend.entity.key.ReviewKey;

@Repository
public interface ReviewRepository extends JpaRepository<Review, ReviewKey>{
}
