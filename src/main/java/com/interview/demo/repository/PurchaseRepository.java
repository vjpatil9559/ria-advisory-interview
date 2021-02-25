package com.interview.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interview.demo.entity.Product;
import com.interview.demo.entity.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

	List<Purchase> findByProductAndPurchDate(Product product, 
			Date purchDate, Pageable pageable);

}
