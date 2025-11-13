package com.example.PaymentGatewaySimulation.controllers;

import com.example.PaymentGatewaySimulation.DTO.AuditLogDTO;
import com.example.PaymentGatewaySimulation.services.AuditLogService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/audit-logs")
@AllArgsConstructor
public class AuditLogController {

    private final AuditLogService auditLogService;

    // Récupérer tous les logs
    @GetMapping
    public ResponseEntity<List<AuditLogDTO>> getAllLogs() {
        return ResponseEntity.ok(auditLogService.getAllLogs());
    }

    // Récupérer un log par ID
    @GetMapping("/{id}")
    public ResponseEntity<AuditLogDTO> getLogById(@PathVariable Long id) {
        return ResponseEntity.ok(auditLogService.getLogById(id));
    }
}
