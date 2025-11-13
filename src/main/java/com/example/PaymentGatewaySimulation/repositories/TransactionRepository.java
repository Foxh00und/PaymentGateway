package com.example.PaymentGatewaySimulation.repositories;

import com.example.PaymentGatewaySimulation.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
