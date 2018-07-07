package com.csoft.payone.service.seller;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csoft.payone.service.seller.Payment;


public interface PaymentRepository extends JpaRepository<Payment, Long>{

	Payment save(Optional<Payment> findById);

}
