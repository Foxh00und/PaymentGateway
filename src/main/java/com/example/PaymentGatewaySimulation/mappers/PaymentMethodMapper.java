package com.example.PaymentGatewaySimulation.mappers;

import com.example.PaymentGatewaySimulation.DTO.PaymentMethodDTO;
import com.example.PaymentGatewaySimulation.entity.PaymentMethod;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentMethodMapper {

    // Entity -> DTO
    @Mapping(source = "cardNumber", target = "maskedCardNumber")
    @Mapping(source = "user.id", target = "userId")
    PaymentMethodDTO toPaymentDTO(PaymentMethod paymentMethod);

    // DTO -> Entity
    @Mapping(source = "maskedCardNumber", target = "cardNumber")
    @Mapping(source = "userId", target = "user.id")
    @Mapping(target = "transactions", ignore = true) // Ignore les relations complexes
    PaymentMethod toPaymentEntity(PaymentMethodDTO paymentMethodDTO);
}