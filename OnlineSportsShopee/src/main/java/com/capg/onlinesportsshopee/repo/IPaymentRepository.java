package com.capg.onlinesportsshopee.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.onlinesportsshopee.bean.Payment;

public interface IPaymentRepository extends JpaRepository<Payment, Long>{
	
}
