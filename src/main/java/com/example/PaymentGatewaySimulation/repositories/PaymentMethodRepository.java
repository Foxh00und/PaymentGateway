package com.example.PaymentGatewaySimulation.repositories;

import com.example.PaymentGatewaySimulation.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}
