package com.example.PaymentGatewaySimulation.mappers;

import com.example.PaymentGatewaySimulation.DTO.AuditLogDTO;
import com.example.PaymentGatewaySimulation.entity.AuditLog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuditLogMapper {

    // Entity -> DTO
    @Mapping(source = "timeStamp", target = "timestamp") // Mapping explicite pour le nom différent
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "transaction.id", target = "transactionId")
    AuditLogDTO toAuditLogDTO(AuditLog auditLog);

    // DTO -> Entity
    @Mapping(source = "timestamp", target = "timeStamp") // Mapping explicite pour le nom différent
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "transactionId", target = "transaction.id")
    AuditLog toAuditLogEntity(AuditLogDTO auditLogDTO);
}