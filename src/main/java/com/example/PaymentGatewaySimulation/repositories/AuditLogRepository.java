package com.example.PaymentGatewaySimulation.repositories;

import com.example.PaymentGatewaySimulation.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepository extends JpaRepository<AuditLog,Long> {
}
