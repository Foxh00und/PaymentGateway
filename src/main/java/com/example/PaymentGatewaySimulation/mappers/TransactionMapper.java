package com.example.PaymentGatewaySimulation.mappers;

import com.example.PaymentGatewaySimulation.DTO.TransactionDTO;
import com.example.PaymentGatewaySimulation.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    // Entity -> DTO
    @Mapping(source = "paymentMethod.id", target = "paymentMethodId")
    @Mapping(source = "user.id", target = "userId")
    TransactionDTO toTransactionDTO(Transaction transaction);

    // DTO -> Entity
    @Mapping(source = "paymentMethodId", target = "paymentMethod.id")
    @Mapping(source = "userId", target = "user.id")
    @Mapping(target = "auditLogs", ignore = true) // Ignore les audit logs lors de la création
    Transaction toTransactionEntity(TransactionDTO transactionDTO);
}