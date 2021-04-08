package com.capg.onlinesportsshopee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.onlinesportsshopee.bean.Payment;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Long>{
	
}