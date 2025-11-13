package com.example.PaymentGatewaySimulation.services;

import com.example.PaymentGatewaySimulation.DTO.AuditLogDTO;
import com.example.PaymentGatewaySimulation.entity.AuditLog;
import com.example.PaymentGatewaySimulation.mappers.AuditLogMapper;
import com.example.PaymentGatewaySimulation.repositories.AuditLogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class AuditLogService {

    private AuditLogRepository auditLogRepository;
    private AuditLogMapper auditLogMapper;

    // Créer un log (appelé automatiquement par les autres services)
    public AuditLogDTO createLog(AuditLogDTO auditLogDTO) {
        AuditLog log = auditLogMapper.toAuditLogEntity(auditLogDTO);
        AuditLog saved = auditLogRepository.save(log);
        return auditLogMapper.toAuditLogDTO(saved);
    }

    // Récupérer tous les logs
    public List<AuditLogDTO> getAllLogs() {
        return auditLogRepository.findAll().stream().map(auditLogMapper::toAuditLogDTO).collect(Collectors.toList());
    }

    // Récupérer un log par ID
    public AuditLogDTO getLogById(Long id) {
        return auditLogRepository.findById(id).map(auditLogMapper::toAuditLogDTO).orElseThrow(() -> new RuntimeException("Log non trouvé"));
    }
}

